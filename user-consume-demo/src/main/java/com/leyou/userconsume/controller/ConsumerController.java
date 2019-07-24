package com.leyou.userconsume.controller;

import com.leyou.userconsume.pojo.User;
import com.leyou.userconsume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @auther chenwei
 * @create 2019-07-23 9:53
 */

@RestController
@RequestMapping("consume")
public class ConsumerController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> consume(@RequestParam("ids") List<Long> ids){
        return userService.queryUserByIds(ids);
    }
}
