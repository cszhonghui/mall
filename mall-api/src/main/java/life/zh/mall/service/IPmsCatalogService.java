package life.zh.mall.service;

import life.zh.mall.entity.PmsBaseCatalog1;
import life.zh.mall.entity.PmsBaseCatalog2;
import life.zh.mall.entity.PmsBaseCatalog3;

import java.util.List;

public interface IPmsCatalogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog3> getCatalog3ByCatalog2(Long catalog2Id);

    List<PmsBaseCatalog2> getCatalog2ByCatalog1(Long catalog1Id);
}
