package com.pzhu.consumer.client;

import com.pzhu.consumer.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("未查询到！");
        return user;
    }
}
