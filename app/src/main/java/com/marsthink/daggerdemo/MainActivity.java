package com.marsthink.daggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.marsthink.daggerdemo.HasParameterConstructor.SellMoe;
import com.marsthink.daggerdemo.HasParameterConstructor.SellMoeModule;
import com.marsthink.daggerdemo.NoParameterConstructor.User;
import com.marsthink.daggerdemo.TwoConstructor.Counter;
import com.marsthink.daggerdemo.TwoConstructor.CounterMoudule;
import com.marsthink.daggerdemo.TwoConstructor.CurrentCounter;
import com.marsthink.daggerdemo.TwoConstructor.TotalCounter;

import javax.inject.Inject;

import dagger.Lazy;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "zhoumao";
    @Inject
    User user;
    @Inject
    OkHttpClient okHttpClient;
    // 延迟加载，等到使用时，才加载
    @Inject
    Lazy<SellMoe> sellMoe;
    @CurrentCounter
    @Inject
    Counter currentCounter;
    @TotalCounter
    @Inject
    Counter totalCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
    }

    private void initData() {
        DaggerActivityComponent.builder().counterMoudule(new CounterMoudule(1000)).sellMoeModule(
                new SellMoeModule(80)).build().inject(this);

        Log.e(TAG, "currentCounter: " + currentCounter.getSum());
        Log.e(TAG, "totalCounter: " + totalCounter.getSum());

        okHttpClient.cache();
        Log.e(TAG, "initData: " + sellMoe.get().sellMoe());
        user.setName("测试");
        Log.e(TAG, "initData: " + user.getName());
    }
}
