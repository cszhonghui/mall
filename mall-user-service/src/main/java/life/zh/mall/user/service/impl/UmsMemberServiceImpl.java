package life.zh.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import life.zh.mall.entity.UmsMember;
import life.zh.mall.service.IUmsMemberService;
import life.zh.mall.user.mapper.UmsMemberMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-04
 */
@Service
public class UmsMemberServiceImpl implements IUmsMemberService {
    @Autowired
    private UmsMemberMapper umsMemberMapper;
    public List<UmsMember> list(){
        QueryWrapper queryWrapper=new QueryWrapper();
        return umsMemberMapper.selectList(queryWrapper);
    }


}
