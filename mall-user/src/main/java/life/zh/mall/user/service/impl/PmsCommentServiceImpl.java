package life.zh.mall.user.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import life.zh.mall.entity.PmsComment;
import life.zh.mall.user.mapper.PmsCommentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-04
 */
@Service
public class PmsCommentServiceImpl extends ServiceImpl<PmsCommentMapper, PmsComment> implements IService<PmsComment> {

}
