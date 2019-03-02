package com.marsthink.daggerdemo;

import com.marsthink.daggerdemo.HasParameterConstructor.SellMoeModule;
import com.marsthink.daggerdemo.ThirdProvider.OkHttpMoudle;
import com.marsthink.daggerdemo.TwoConstructor.CounterMoudule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {OkHttpMoudle.class, SellMoeModule.class, CounterMoudule.class})
public interface ActivityComponent {
    void inject(MainActivity MainActivity);
}