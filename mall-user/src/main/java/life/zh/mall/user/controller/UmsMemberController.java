package life.zh.mall.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import life.zh.mall.user.service.impl.UmsMemberReceiveAddressServiceImpl;
import life.zh.mall.user.service.impl.UmsMemberServiceImpl;
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
    @Autowired
    UmsMemberServiceImpl umsMemberService;
    @Autowired
    UmsMemberReceiveAddressServiceImpl umsMemberReceiveAddressService;

    @RequestMapping("/list")
    public Object list(){
        //System.out.println(memberId);

        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("member_id",1L);

        return umsMemberReceiveAddressService.list(queryWrapper);
    }

}
