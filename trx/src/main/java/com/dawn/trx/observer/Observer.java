package com.dawn.trx.observer;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public interface Observer {

    void onNext(String s);

    void onComplete(String s);

}
