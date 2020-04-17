package life.zh.mall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import life.zh.mall.entity.PmsProductImage;
import life.zh.mall.entity.PmsProductInfo;
import life.zh.mall.service.IPmsBaseSaleAttrService;
import life.zh.mall.service.IPmsSpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class SpuController {
    @Reference
    IPmsSpuService pmsSpuService;
    @RequestMapping("/spuList")
    public Object getSpuListByCatalog3Id(Long catalog3Id){
        List<PmsProductInfo> pmsProductInfoList=pmsSpuService.getSpuListCatalog3Id(catalog3Id);
        return pmsProductInfoList;
    }

    @RequestMapping("/saveSpuInfo")
    public Object saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        pmsSpuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }
    @RequestMapping("/fileUpload")
    public Object saveImg(@RequestParam("file") MultipartFile multipartFile){
       //上傳至 fastdfs并返回地址
        return "success";
    }

    @RequestMapping("/spuImageList")
    public List<PmsProductImage> spuImageList(Long spuId){
        return pmsSpuService.getSpuImageList(spuId);
    }
}
