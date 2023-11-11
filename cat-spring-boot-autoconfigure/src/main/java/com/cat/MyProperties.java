package com.cat;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 14629
 */
@Deprecated
@ConfigurationProperties(prefix = "cat")
public class MyProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
