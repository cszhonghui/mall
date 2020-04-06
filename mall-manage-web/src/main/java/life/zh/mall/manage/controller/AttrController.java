package life.zh.mall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import life.zh.mall.dto.AttrDTO;
import life.zh.mall.entity.PmsBaseAttrInfo;
import life.zh.mall.entity.PmsBaseAttrValue;
import life.zh.mall.service.IPmsAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AttrController {
    @Reference
    private IPmsAttrService pmsAttrService;

    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> getAttrInfoList(Long catalog3Id){
        return pmsAttrService.getAttrInfoListByCatalog3Id(catalog3Id);
    }
    @RequestMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId){
        return pmsAttrService.getAttrValueListByAttrId(attrId);
    }

    @RequestMapping("/saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        System.out.println(pmsBaseAttrInfo);
        pmsAttrService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }

}

