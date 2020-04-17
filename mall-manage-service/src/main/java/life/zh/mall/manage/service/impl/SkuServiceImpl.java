package life.zh.mall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import life.zh.mall.entity.PmsProductSaleAttr;
import life.zh.mall.entity.PmsProductSaleAttrValue;
import life.zh.mall.entity.PmsSkuInfo;
import life.zh.mall.entity.PmsSkuSaleAttrValue;
import life.zh.mall.manage.mapper.*;
import life.zh.mall.service.ISkuService;
import life.zh.mall.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.DelegatingServletInputStream;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SkuServiceImpl implements ISkuService {
    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;
    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;
    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;
    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfoMapper.insert(pmsSkuInfo);
        pmsSkuInfo.getSkuAttrValueList().stream().forEach(a->{
            a.setSkuId(pmsSkuInfo.getId());
            pmsSkuAttrValueMapper.insert(a);
        });
        pmsSkuInfo.getSkuSaleAttrValueList().stream().forEach(a->{
            a.setSkuId(pmsSkuInfo.getId());
            pmsSkuSaleAttrValueMapper.insert(a);
        });
        pmsSkuInfo.getSkuImageList().stream().forEach(a->{
            a.setSkuId(pmsSkuInfo.getId());
            pmsSkuImageMapper.insert(a);
        });
    }

    public PmsSkuInfo getSkuByIdFromDb(Long skuId) {
        PmsSkuInfo pmsSkuInfo=pmsSkuInfoMapper.selectById(skuId);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("sku_id",skuId);
        pmsSkuInfo.setSkuImageList(pmsSkuImageMapper.selectList(queryWrapper));
        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValues=pmsSkuSaleAttrValueMapper.selectList(queryWrapper);
        Map<Long,Long> skuSaleAttrValueMap=new HashMap<>();
        pmsSkuSaleAttrValues.stream().forEach(a->{
            skuSaleAttrValueMap.put(a.getSaleAttrId(),a.getSaleAttrValueId());
        });

        queryWrapper=new QueryWrapper();
        queryWrapper.eq("product_id",pmsSkuInfo.getProductId());
        List<PmsProductSaleAttr> pmsProductSaleAttrList=pmsProductSaleAttrMapper.selectList(queryWrapper);
        ;

        pmsProductSaleAttrList.stream().forEach(a->{
            QueryWrapper queryWrapper1=new QueryWrapper();
            queryWrapper1.eq("product_id",pmsSkuInfo.getProductId());
            queryWrapper1.eq("sale_attr_id",a.getSaleAttrId());
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValueList=pmsProductSaleAttrValueMapper.selectList(queryWrapper1);
            pmsProductSaleAttrValueList.stream().forEach(b->{
                if(b.getId()==skuSaleAttrValueMap.get(b.getSaleAttrId()))
                    b.setIsChecked(1);
                else
                    b.setIsChecked(0);
            });
            a.setSpuSaleAttrValueList(pmsProductSaleAttrValueList);
        });

        return  pmsSkuInfo;


    }
    @Override
    public PmsSkuInfo getSkuById(Long skuId) {
        PmsSkuInfo pmsSkuInfo;

        //连接缓存
        Jedis jedis=redisUtil.getJedis();
        //查询缓存
        String skuKey = "sku:"+skuId+"info";
        String skuJson=jedis.get(skuKey);
        if(!StringUtils.isBlank(skuJson)){
            pmsSkuInfo=JSON.parseObject(skuJson,PmsSkuInfo.class);
        }
        else{        //如果缓存中没有，查询mysql,查询mysql是受保护的
            pmsSkuInfo= getSkuByIdFromDb(skuId);

            if(pmsSkuInfo!=null){
                jedis.set("sku:"+skuId+":insfo",JSON.toJSONString(pmsSkuInfo));
            }else{
                //防止缓存穿透，防止多次利用不存在的id进行查询数据库
                jedis.setex("sku:"+skuId+":insfo",60*3,JSON.toJSONString(""));
            }

        }
        jedis.close();
        return  pmsSkuInfo;
    }

    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(Long productId) {
        return pmsSkuInfoMapper.selectSkuSaleAttrValueListBySpu(productId);
    }
}
