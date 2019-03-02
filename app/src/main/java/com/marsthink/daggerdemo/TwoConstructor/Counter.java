package com.marsthink.daggerdemo.TwoConstructor;

public class Counter {
    private int sum;

    public Counter() {
    }

    public Counter(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum++;
    }
}