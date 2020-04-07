package life.zh.mall.service;

import life.zh.mall.entity.PmsProductInfo;

import java.util.List;

public interface IPmsSpuService {
    List<PmsProductInfo> getSpuListCatalog3Id(Long catalog3Id);
}
