package com.test;

import com.cat.log.Log;
import com.cat.cache.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 14629
 */
@Component
public class test {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(test.class);
    //</editor-fold>
    @Autowired
    private RedisService redisService;

//<editor-fold defaultstate="collapsed" desc="delombok">
//</editor-fold>
//    @AllArgsConstructor
//    @Data
//    static class P{
//        String name;
//    }
    @Log(title = "test")
    public String test1(P p) {
//        P p=new P("zhangsan");
//        redisService.setCacheObject("zhangsan",p);
//        Object zhangsan = redisService.getCacheObject("zhangsan");
        //System.out.println("zhangsan");
        //throw new RuntimeException("456");
        return "zhangsan ";
        //System.out.println(myService.addSuffix("789"));
    }
}
