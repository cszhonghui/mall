package life.zh.mall.user.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import life.zh.mall.entity.OmsOrderItem;
import life.zh.mall.user.mapper.OmsOrderItemMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-04
 */
@Service
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements IService<OmsOrderItem> {

}
