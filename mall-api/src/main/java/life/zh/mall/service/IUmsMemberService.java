package life.zh.mall.service;

import life.zh.mall.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-03
 */
public interface IUmsMemberService{
    List<UmsMember> list();

}
