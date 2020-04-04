package life.zh.mall.user.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import life.zh.mall.entity.UmsMember;
import life.zh.mall.user.mapper.UmsMemberMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-04
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements IService<UmsMember> {

}
