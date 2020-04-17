package life.zh.mall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import life.zh.mall.entity.*;
import life.zh.mall.manage.mapper.*;
import life.zh.mall.service.IPmsSpuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class PmsSpuInfoServiceImpl implements IPmsSpuService {
    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;
    @Override
    public List<PmsProductInfo> getSpuListCatalog3Id(Long catalog3Id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("catalog3_id",catalog3Id);
        return pmsProductInfoMapper.selectList(queryWrapper);
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        pmsProductInfoMapper.insert(pmsProductInfo);
        pmsProductInfo.getSpuImageList().stream().forEach(a->{
            a.setProductId(pmsProductInfo.getId());
            pmsProductImageMapper.insert(a);
        });

        pmsProductInfo.getSpuSaleAttrList().stream().forEach(a->{

            a.setProductId(pmsProductInfo.getId());

            pmsProductSaleAttrMapper.insert(a);
            a.getSpuSaleAttrValueList().stream().forEach(b->{
                b.setProductId(pmsProductInfo.getId());
                b.setSaleAttrId(a.getId());
                pmsProductSaleAttrValueMapper.insert(b);
            });
        });
    }

    @Override
    public List<PmsProductImage> getSpuImageList(Long spuId) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("product_id",spuId);
        return pmsProductImageMapper.selectList(queryWrapper);
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(Long productId,Long skuId) {
        QueryWrapper queryWrapper0=new QueryWrapper();
        queryWrapper0.eq("sku_id",skuId);
        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValues=pmsSkuSaleAttrValueMapper.selectList(queryWrapper0);
        Map<Long,Long> skuSaleAttrValueMap=new HashMap<>();
        pmsSkuSaleAttrValues.stream().forEach(a->{
            skuSaleAttrValueMap.put(a.getSaleAttrId(),a.getSaleAttrValueId());
        });

        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("product_id",productId);
        List<PmsProductSaleAttr> pmsProductSaleAttrList=pmsProductSaleAttrMapper.selectList(queryWrapper);
        pmsProductSaleAttrList.stream().forEach(a ->{
            QueryWrapper queryWrapper1=new QueryWrapper();
            queryWrapper1.eq("sale_attr_id",a.getSaleAttrId());
            queryWrapper1.eq("product_id",productId);
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValueList=pmsProductSaleAttrValueMapper.selectList(queryWrapper1);
            pmsProductSaleAttrValueList.stream().forEach(b->{
                if(b.getId()==skuSaleAttrValueMap.get(b.getSaleAttrId()))
                    b.setIsChecked(1);
                else
                    b.setIsChecked(0);
            });
            a.setSpuSaleAttrValueList(pmsProductSaleAttrValueList);
        });
        return pmsProductSaleAttrList;

    }


}
