package com.leyou.userconsume.Mapper;

import com.leyou.userconsume.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @auther chenwei
 * @create 2019-07-23 9:55
 */

@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;

    public User queryUserById(Long id){
        String url = "http://localhost:8087/user/"+id;
        return restTemplate.getForObject(url, User.class);
    }
}
