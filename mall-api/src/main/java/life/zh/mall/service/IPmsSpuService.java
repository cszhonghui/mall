package life.zh.mall.service;

import life.zh.mall.entity.PmsProductImage;
import life.zh.mall.entity.PmsProductInfo;
import life.zh.mall.entity.PmsProductSaleAttr;

import java.util.List;

public interface IPmsSpuService {
    List<PmsProductInfo> getSpuListCatalog3Id(Long catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductImage> getSpuImageList(Long spuId);

    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(Long productId,Long skuId);
}
