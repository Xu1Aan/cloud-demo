package com.pzhu.consumer.web;

import com.pzhu.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

  //  @Autowired
   // private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id")Long id){
        //根据服务id获取实例
       // List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //从实例中取出ip和端口
       // ServiceInstance serviceInstance = instances.get(0);
        //随机，轮询，hash
       // String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
        String url = "http://user-service/user/"+id;
        User user = restTemplate.getForObject(url, User.class);
        return  user;
    }
}
