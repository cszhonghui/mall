package life.zh.mall.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import life.zh.mall.entity.PmsSkuInfo;

import java.util.List;

/**
 * <p>
 * 库存单元表 Mapper 接口
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-04
 */
public interface PmsSkuInfoMapper extends BaseMapper<PmsSkuInfo> {

    List<PmsSkuInfo> selectSkuSaleAttrValueListBySpu(Long productId);
}
