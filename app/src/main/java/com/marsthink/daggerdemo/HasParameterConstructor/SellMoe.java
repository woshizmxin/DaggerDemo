package com.marsthink.daggerdemo.HasParameterConstructor;

public class SellMoe {

    private int age;

    public SellMoe(int age) {
        this.age = age;
    }

    public String sellMoe() {
        return "我特么" + age + "岁了还是可爱得要死";
    }
}