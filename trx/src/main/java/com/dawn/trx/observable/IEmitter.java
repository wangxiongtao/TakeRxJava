package com.dawn.trx.observable;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public interface IEmitter {
    void onNext(String s);

    void onComplete(String s);
}
