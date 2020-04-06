package life.zh.mall.dto;

import life.zh.mall.entity.PmsBaseAttrInfo;
import life.zh.mall.entity.PmsBaseAttrValue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AttrDTO implements Serializable {
    private List<PmsBaseAttrValue> pmsBaseAttrValueList;
    private Long pmsBaseAttrInfo;
}
