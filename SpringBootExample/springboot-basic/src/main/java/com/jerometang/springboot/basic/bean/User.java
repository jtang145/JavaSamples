package com.jerometang.springboot.basic.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by jtang on 7/3/2017.
 */
@Configuration
@PropertySource(value="classpath:test.properties")
@ConfigurationProperties(prefix="com.jerometang")
public class User {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
