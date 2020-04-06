package life.zh.mall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import life.zh.mall.entity.PmsBaseCatalog1;
import life.zh.mall.entity.PmsBaseCatalog2;
import life.zh.mall.entity.PmsBaseCatalog3;
import life.zh.mall.service.IPmsCatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CatalogController {
    @Reference
    IPmsCatalogService CatalogService;

    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){

        return CatalogService.getCatalog1();
    }
    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2ByCatalog1(Long catalog1Id){

        return CatalogService.getCatalog2ByCatalog1(catalog1Id);
    }
    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3ByCatalog2(Long catalog2Id){

        return CatalogService.getCatalog3ByCatalog2(catalog2Id);
    }
}
