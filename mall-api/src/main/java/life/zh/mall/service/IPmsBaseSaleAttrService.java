package life.zh.mall.service;

import life.zh.mall.entity.PmsBaseSaleAttr;
import life.zh.mall.entity.PmsProductSaleAttr;

import java.util.List;

public interface IPmsBaseSaleAttrService {
    List<PmsBaseSaleAttr> getSaleAttrList();

    List<PmsProductSaleAttr> getSaleAttrListBySpuId(Long spuId);
}
