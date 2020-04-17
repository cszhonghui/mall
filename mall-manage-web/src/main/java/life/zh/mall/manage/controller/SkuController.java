package life.zh.mall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import life.zh.mall.service.ISkuService;
import life.zh.mall.entity.PmsSkuInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
public class SkuController {
    @Reference
    ISkuService skuService;

    @RequestMapping("/saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo){
        log.info(pmsSkuInfo.toString());
        skuService.saveSkuInfo(pmsSkuInfo);
        return "success";
    }
}
