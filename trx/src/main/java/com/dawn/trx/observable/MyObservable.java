package com.dawn.trx.observable;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public abstract class MyObservable implements Observable {
    public MyObservable subscribeOn() {
        return new ThreadObservable(this);
    }

    public MyObservable observableOn() {
        return new MainThreadObservable(this);
    }


}
