package com.marsthink.daggerdemo.HasParameterConstructor;

import dagger.Module;
import dagger.Provides;

/**
 * 带参注入
 */

@Module
public class SellMoeModule {
    private int age;

    public SellMoeModule(int age) {
        this.age = age;
    }

    //提供参数的提供者
    @Provides
    public int ageProvider() {
        return age;
    }

    //提供对象的提供者
    @Provides
    public SellMoe sellMoeProvider(int age) {
        return new SellMoe(age);
    }
}
