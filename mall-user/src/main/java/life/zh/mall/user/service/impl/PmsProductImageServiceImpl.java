package life.zh.mall.user.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import life.zh.mall.entity.PmsProductImage;
import life.zh.mall.user.mapper.PmsProductImageMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品图片表 服务实现类
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-04
 */
@Service
public class PmsProductImageServiceImpl extends ServiceImpl<PmsProductImageMapper, PmsProductImage> implements IService<PmsProductImage> {

}
