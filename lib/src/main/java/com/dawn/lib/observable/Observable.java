package com.dawn.lib.observable;

import com.dawn.lib.observer.Observer;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class Observable {
    public IStringCallback callback;

    public Observable(IStringCallback callback) {
        this.callback = callback;
    }

    public void subscribe(final Observer observer){
        Observer o=new Observer(){
            @Override
            public void onNext(String s) {
                observer.onNext(s);
            }
        };
        callback.string(o);

    }



}
