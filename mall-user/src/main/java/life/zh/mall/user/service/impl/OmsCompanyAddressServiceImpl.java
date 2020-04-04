package life.zh.mall.user.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import life.zh.mall.entity.OmsCompanyAddress;
import life.zh.mall.user.mapper.OmsCompanyAddressMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公司收发货地址表 服务实现类
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-04
 */
@Service
public class OmsCompanyAddressServiceImpl extends ServiceImpl<OmsCompanyAddressMapper, OmsCompanyAddress> implements IService<OmsCompanyAddress> {

}
