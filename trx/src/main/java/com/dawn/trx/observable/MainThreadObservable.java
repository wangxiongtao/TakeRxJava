package com.dawn.trx.observable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.dawn.trx.LogUtil;
import com.dawn.trx.observer.Observer;


/**
 * Created by Administrator on 2018/6/5 0005.
 * 切换到主线程
 */

public class MainThreadObservable extends MyObservable {
    private Observable observable;
    private Handler mainHandler;

    public MainThreadObservable(Observable observable) {
        this.observable = observable;
        mainHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void subscribe(Observer o) {
        observable.subscribe(new MainThreadObserver(o));//简单handler实现 RxJava里面是用Scheduler+handler

    }

    private class MainThreadObserver implements Observer, Runnable {
        Observer o;
        boolean isOnext;
        boolean isOnComplete;
        String string1;
        String string2;


        public MainThreadObserver(Observer o) {
            this.o = o;
        }

        @Override
        public void onNext(String s) {
            string1 = s;
            isOnext = true;
            LogUtil.i("====onNext  mmmmmmm===>"+Thread.currentThread().getName());
            schedule();


        }

        @Override
        public void onComplete(String s) {
            string2 = s;
            isOnComplete = true;
            schedule();

        }

        private void schedule() {
            Message message = Message.obtain(mainHandler, this);
            mainHandler.sendMessage(message);
        }

        @Override
        public void run() {
            LogUtil.i("====又切换到主线程了===>");
            if (isOnext) {
                o.onNext(string1);
                isOnext = false;
            }
            if (isOnComplete) {
                o.onComplete(string2);
                isOnComplete = false;
            }


        }
    }

}
