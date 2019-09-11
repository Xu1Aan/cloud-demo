package com.pzhu.consumer.web;

import com.pzhu.consumer.client.UserClient;
import com.pzhu.consumer.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
@Slf4j
//@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    //  @Autowired
    // private DiscoveryClient discoveryClient;

    // @Autowired
    // private DiscoveryClient discoveryClient;
    //@HystrixCommand(fallbackMethod = "queryByIdFallback")


//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id")Long id){
       return userClient.queryById(id);
    }
//    public String defaultFallback(){
//        log.error("服务器正忙！");
//        return "服务器正忙！";
//    }

    /*@GetMapping("/{id}")
    public User queryById(@PathVariable("id")Long id){
        //根据服务id获取实例
        // List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //从实例中取出ip和端口
        // ServiceInstance serviceInstance = instances.get(0);
        // 随机，轮询，hash
        // String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
        String url = "http://user-service/user/"+id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }*/
}
