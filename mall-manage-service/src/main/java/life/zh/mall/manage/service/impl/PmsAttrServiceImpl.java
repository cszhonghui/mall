package life.zh.mall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import life.zh.mall.dto.AttrDTO;
import life.zh.mall.entity.PmsBaseAttrInfo;
import life.zh.mall.entity.PmsBaseAttrValue;
import life.zh.mall.manage.mapper.PmsBaseAttrInfoMapper;
import life.zh.mall.manage.mapper.PmsBaseAttrValueMapper;
import life.zh.mall.service.IPmsAttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsAttrServiceImpl implements IPmsAttrService {
    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Override
    public List<PmsBaseAttrInfo> getAttrInfoListByCatalog3Id(Long catalog3Id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("catalog3_id",catalog3Id);
        return pmsBaseAttrInfoMapper.selectList(queryWrapper);
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueListByAttrId(Long attrId) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("attr_id",attrId);
        return pmsBaseAttrValueMapper.selectList(queryWrapper);
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);
        pmsBaseAttrInfo.getAttrValueList().stream().forEach(a->{
            a.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.insert(a);
        });
        return "success";
    }
}
