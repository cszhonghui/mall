package life.zh.mall.user.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import life.zh.mall.entity.OmsOrder;
import life.zh.mall.user.mapper.OmsOrderMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-04
 */
@Service
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder> implements IService<OmsOrder> {

}
