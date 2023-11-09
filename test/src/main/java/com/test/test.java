package com.test;

import com.cat.log.Log;
import com.cat.redis.RedisService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author 14629
 */
@Slf4j
@Component
public class test {
    @Autowired
    private RedisService redisService;
    @AllArgsConstructor
    @Data
    static class P{
        String name;
    }
    @Log
    public void test1(){
        P p=new P("zhangsan");
        redisService.setCacheObject("zhangsan",p);
        Object zhangsan = redisService.getCacheObject("zhangsan");
        System.out.println(zhangsan);
        //System.out.println(myService.addSuffix("789"));
    }
}
