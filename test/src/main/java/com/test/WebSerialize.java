package com.test;

import com.alibaba.fastjson2.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 14629
 */
@RestController
@RequestMapping("/test")
public class WebSerialize {
    @GetMapping("/json")
    public P json(){
        P p = new P("123", "456", "1564164515@qq.com");
        System.out.println(JSON.toJSONString(p));
        return p;
    }
}
