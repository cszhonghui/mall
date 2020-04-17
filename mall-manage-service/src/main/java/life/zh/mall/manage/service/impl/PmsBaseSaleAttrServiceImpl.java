package life.zh.mall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import life.zh.mall.entity.PmsBaseAttrInfo;
import life.zh.mall.entity.PmsBaseSaleAttr;
import life.zh.mall.entity.PmsProductSaleAttr;
import life.zh.mall.manage.mapper.PmsBaseAttrInfoMapper;
import life.zh.mall.manage.mapper.PmsBaseSaleAttrMapper;
import life.zh.mall.manage.mapper.PmsProductSaleAttrMapper;
import life.zh.mall.manage.mapper.PmsProductSaleAttrValueMapper;
import life.zh.mall.service.IPmsBaseSaleAttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class PmsBaseSaleAttrServiceImpl implements IPmsBaseSaleAttrService {
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper ;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper ;
    @Override
    public List<PmsBaseSaleAttr> getSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectList(new QueryWrapper());
    }

    @Override
    public List<PmsProductSaleAttr> getSaleAttrListBySpuId(Long spuId) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("product_id",spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrList=pmsProductSaleAttrMapper.selectList(queryWrapper);
        pmsProductSaleAttrList.stream().forEach(a->{
            QueryWrapper queryWrapper1=new QueryWrapper();
            queryWrapper1.eq("sale_attr_id",a.getId());
            queryWrapper1.eq("product_id",spuId);
            a.setSpuSaleAttrValueList(pmsProductSaleAttrValueMapper.selectList(queryWrapper1));
        });
        return pmsProductSaleAttrList;
    }
}
