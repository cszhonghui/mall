package life.zh.mall.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import life.zh.mall.service.IUmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author ZhongHui
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/ums-member")
public class UmsMemberController {
    @Reference
    IUmsMemberService umsMemberService;


    @RequestMapping("/list")
    public Object list(){
        //System.out.println(memberId);
        return umsMemberService.list();
    }

}
