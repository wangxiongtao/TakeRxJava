package com.dawn.takerxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dawn.trx.LogUtil;
import com.dawn.trx.observable.IEmitter;
import com.dawn.trx.observable.ObservableCreate;
import com.dawn.trx.observable.RealObservable;
import com.dawn.trx.observer.Observer;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go();

    }

    public void go(){
        new RealObservable(new ObservableCreate() {
            @Override
            public void fun(IEmitter emitter) {
                emitter.onNext("dsadsadsa");
                emitter.onComplete("onComplete");
                LogUtil.i("==able===thread==>"+Thread.currentThread().getName());

            }
        }).subscribeOn().observableOn().subscribe(new Observer() {
            @Override
            public void onNext(String s) {
                LogUtil.i("==onNext======>"+s);
                LogUtil.i("==onNext===thread==>"+Thread.currentThread().getName());


            }

            @Override
            public void onComplete(String s) {
                LogUtil.i("==onComplete======>"+s);
                LogUtil.i("==onComplete===thread==>"+Thread.currentThread().getName());

            }
        });

    }
}
