package com.cat;

/**
 * @author 14629
 */
@Deprecated
public class MyService {
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MyService.class);
    private MyProperties myProperties;

    public MyService(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    public String addPrefix(String s) {
        return this.myProperties.getPrefix() + "-" + s;
    }

//<editor-fold defaultstate="collapsed" desc="delombok">
//</editor-fold>
    public String addSuffix(String s) {
        return s + "-" + this.myProperties.getSuffix();
    }
}
