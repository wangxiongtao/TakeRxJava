package com.dawn.trx.observable;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public abstract class MyObservable implements Observable {
    /**
     * 切换到子线程
     * @return
     */
    public MyObservable subscribeOn() {
        return new ThreadObservable(this);
    }

    /**
     * 切换到主线程
     * @return
     */
    public MyObservable observableOn() {
        return new MainThreadObservable(this);
    }


}
