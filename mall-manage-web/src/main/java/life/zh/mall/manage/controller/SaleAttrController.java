package life.zh.mall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import life.zh.mall.entity.PmsBaseSaleAttr;
import life.zh.mall.entity.PmsProductSaleAttr;
import life.zh.mall.service.IPmsBaseSaleAttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class SaleAttrController {
    @Reference
    IPmsBaseSaleAttrService baseSaleAttrService;

    @RequestMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        return baseSaleAttrService.getSaleAttrList();
    }
    @RequestMapping("/spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(Long spuId){
        return baseSaleAttrService.getSaleAttrListBySpuId(spuId);
    }

}
