package com.cat;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 14629
 */
@Slf4j
@Deprecated
public class MyService {

    private MyProperties myProperties;

    public MyService(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    public String addPrefix(String s) {
        return this.myProperties.getPrefix() + "-" + s;
    }
    public String addSuffix(String s) {
        return s+ "-" + this.myProperties.getSuffix() ;
    }
}
