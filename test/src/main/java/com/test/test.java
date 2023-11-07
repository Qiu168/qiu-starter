package com.test;

import com.cat.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 14629
 */
@Slf4j
@Component
public class test {
    @Autowired
    private MyService myService;
    public void test1(){
        System.out.println(myService.addSuffix("789"));
    }
}
