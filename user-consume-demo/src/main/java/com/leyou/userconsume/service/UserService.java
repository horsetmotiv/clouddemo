package com.leyou.userconsume.service;

import com.leyou.userconsume.Mapper.UserDao;
import com.leyou.userconsume.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther chenwei
 * @create 2019-07-23 9:53
 */

@Service
public class UserService {
//    @Autowired
//    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<User> queryUserByIds(List<Long> ids){
        List<User> users = new ArrayList<>();
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        ServiceInstance instance = instances.get(0);
//
//        String baseUrl = "http://" + instance.getHost() + ":" +instance.getPort()+"/user/";
//        ids.forEach(id->{
//            users.add(this.restTemplate.getForObject(baseUrl+id, User.class));
//            try{
//                Thread.sleep(500);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        });
//        return users;


        // 地址直接写服务名称即可
        String baseUrl = "http://user-service/user/";
        ids.forEach(id -> {
            // 我们测试多次查询，
            users.add(this.restTemplate.getForObject(baseUrl + id, User.class));
            // 每次间隔500毫秒
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return users;
    }

//    public List<User> queryUserByIds(List<Long> ids){
//        List<User> users = new ArrayList<>();
//        for(Long id: ids){
//            User user = userDao.queryUserById(id);
//            users.add(user);
//        }
//        return users;
//    }
}
