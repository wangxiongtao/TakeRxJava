package com.dawn.trx.observable;

import com.dawn.trx.observer.Observer;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public interface Observable {
    void subscribe(Observer o);
}
