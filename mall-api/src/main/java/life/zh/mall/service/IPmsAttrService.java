package life.zh.mall.service;

import life.zh.mall.dto.AttrDTO;
import life.zh.mall.entity.PmsBaseAttrInfo;
import life.zh.mall.entity.PmsBaseAttrValue;

import java.util.List;

public interface IPmsAttrService {
    List<PmsBaseAttrInfo> getAttrInfoListByCatalog3Id(Long catalog3Id);

    List<PmsBaseAttrValue> getAttrValueListByAttrId(Long attrId);

    String saveOrUpdateAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
}
