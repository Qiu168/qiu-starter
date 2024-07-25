package com.example.www.controller;

import com.cat.idempotent.core.annotation.Idempotent;
import com.example.www.R;
import com.example.www.RedisCache;
import com.example.www.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author _qiu
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RedisCache redisCache;
    @PostMapping("/login")
    @Idempotent//需要redis支持

    public R login(@RequestBody User user){
        redisCache.RedisCache(user.getUsername());
        return R.ok(user);
    }
}
