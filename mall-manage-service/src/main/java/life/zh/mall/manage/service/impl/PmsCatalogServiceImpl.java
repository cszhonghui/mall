package life.zh.mall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import life.zh.mall.entity.PmsBaseCatalog1;
import life.zh.mall.entity.PmsBaseCatalog2;
import life.zh.mall.entity.PmsBaseCatalog3;
import life.zh.mall.manage.mapper.PmsBaseCatalog1Mapper;
import life.zh.mall.manage.mapper.PmsBaseCatalog2Mapper;
import life.zh.mall.manage.mapper.PmsBaseCatalog3Mapper;
import life.zh.mall.service.IPmsCatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsCatalogServiceImpl implements IPmsCatalogService {
    @Autowired
    private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Autowired
    private PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Autowired
    private PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        QueryWrapper queryWrapper=new QueryWrapper();
        return pmsBaseCatalog1Mapper.selectList(queryWrapper);
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2ByCatalog1(Long catalog1Id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("catalog1_id",catalog1Id);
        return pmsBaseCatalog2Mapper.selectList(queryWrapper);
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3ByCatalog2(Long catalog2Id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("catalog2_id",catalog2Id);
        return pmsBaseCatalog3Mapper.selectList(queryWrapper);
    }
}
