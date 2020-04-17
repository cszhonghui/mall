package life.zh.mall.service;

import life.zh.mall.entity.PmsSkuInfo;

import java.util.List;

public interface ISkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuById(Long skuId);

    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(Long productId);
}
