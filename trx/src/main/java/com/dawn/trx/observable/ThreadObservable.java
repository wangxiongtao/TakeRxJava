package com.dawn.trx.observable;

import com.dawn.trx.LogUtil;
import com.dawn.trx.observer.Observer;

/**
 * Created by Administrator on 2018/6/5 0005.
 * 切换到子线程 简答实现
 */

public class ThreadObservable extends MyObservable {
    private Observable observable;

    public ThreadObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void subscribe(Observer o) {
        final ThreadObserver observer=new ThreadObserver(o);
        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtil.i("====切换到子线程===>");
                observable.subscribe(observer);
            }
        }).start();


    }

    private class ThreadObserver implements Observer{
        Observer observer;

        public ThreadObserver(Observer observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(String s) {
            observer.onNext(s);

        }

        @Override
        public void onComplete(String s) {

        }
    }
}
