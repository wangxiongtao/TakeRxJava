package com.dawn.trx;

import com.dawn.trx.observable.IEmitter;
import com.dawn.trx.observable.ObservableCreate;
import com.dawn.trx.observable.RealObservable;
import com.dawn.trx.observer.Observer;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class Client {
    public static void main(String[] args) {
      new RealObservable(new ObservableCreate() {
          @Override
          public void fun(IEmitter emitter) {
              emitter.onNext("dsadsadsa");
              LogUtil.i("==able===thread==>"+Thread.currentThread().getName());
              LogUtil.i("==able===onNext==>");
          }
      }).subscribe(new Observer() {
          @Override
          public void onNext(String s) {
              LogUtil.i("==onNext======>"+s);
              LogUtil.i("==onNext===thread==>"+Thread.currentThread().getName());


          }

          @Override
          public void onComplete(String s) {

          }
      });
    }
}
