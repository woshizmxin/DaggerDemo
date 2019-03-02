package com.marsthink.daggerdemo.TwoConstructor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * 同一个模型下的提供者的方法名不能雷同，无论参数是否相同。
 * 这个和常规的Java代码有出入，请牢记！
 */

@Module
public class CounterMoudule {
    private int sum;

    public CounterMoudule(int sum) {
        this.sum = sum;
    }

    @Provides
    @Named("sumProvider")
    public int sumProvider() {
        return this.sum;
    }

    @Provides
    @CurrentCounter
    public Counter currentCounterProvider() {
        return new Counter();
    }

    @Provides
    @TotalCounter
    public Counter totalCunterProvider(int sum) {
        return new Counter(sum);
    }
}