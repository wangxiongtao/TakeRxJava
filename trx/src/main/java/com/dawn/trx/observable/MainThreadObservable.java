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
        mainHandler=new Handler(Looper.getMainLooper());
    }

    @Override
    public void subscribe(Observer o) {
        observable.subscribe(new MainThreadObserver(o));

    }

    private  class MainThreadObserver implements Observer,Runnable{
        Observer o;
        int anInt;
        String string;


        public MainThreadObserver(Observer o) {
            this.o = o;
        }

        @Override
        public void onNext(String s) {
            string=s;
            anInt=1;
            schedule();



        }

        @Override
        public void onComplete(String s) {
            string=s;
            anInt=2;
            schedule();

        }

        private void schedule(){
            Message message=Message.obtain(mainHandler,this);
            mainHandler.sendMessage(message);
        }

        @Override
        public void run() {
            LogUtil.i("====又切换到主线程了===>");
            switch (anInt){
                case 1:
                    o.onNext(string);
                    break;
                case 2:
                    o.onComplete(string);
                    break;
            }

        }
    }

}
