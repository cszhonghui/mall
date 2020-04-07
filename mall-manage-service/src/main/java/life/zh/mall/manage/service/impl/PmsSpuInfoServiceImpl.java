package life.zh.mall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import life.zh.mall.entity.PmsProductInfo;
import life.zh.mall.manage.mapper.PmsProductInfoMapper;
import life.zh.mall.service.IPmsSpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsSpuInfoServiceImpl implements IPmsSpuService {
    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Override
    public List<PmsProductInfo> getSpuListCatalog3Id(Long catalog3Id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("catalog3_id",catalog3Id);
        return pmsProductInfoMapper.selectList(queryWrapper);
    }
}
