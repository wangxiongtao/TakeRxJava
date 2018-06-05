package com.dawn.trx.observable;

import com.dawn.trx.LogUtil;
import com.dawn.trx.observer.Observer;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class RealObservable extends MyObservable {
    private ObservableCreate observableCreate;

    public RealObservable(ObservableCreate observableCreate) {
        this.observableCreate = observableCreate;
    }

    @Override
    public void subscribe(Observer o) {
        CreateEmitter createEmitter=new CreateEmitter(o);
        observableCreate.fun(createEmitter);

    }

   private class CreateEmitter implements IEmitter{
        Observer observer;

        CreateEmitter(Observer observer) {
           this.observer = observer;
       }

       @Override
       public void onNext(String s) {
           observer.onNext(s);

       }

       @Override
       public void onComplete(String s) {
            observer.onComplete(s);

       }
   }



}
