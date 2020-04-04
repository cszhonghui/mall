package life.zh.mall.user.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import life.zh.mall.entity.OmsCartItem;
import life.zh.mall.user.mapper.OmsCartItemMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-04
 */
@Service
public class OmsCartItemServiceImpl extends ServiceImpl<OmsCartItemMapper, OmsCartItem> implements IService<OmsCartItem> {

}
