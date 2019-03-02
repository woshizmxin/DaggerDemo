package com.marsthink.daggerdemo.NoParameterConstructor;

import javax.inject.Inject;

/**
 * 无参注入
 */
public class User {

    private String name;

    @Inject
    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}