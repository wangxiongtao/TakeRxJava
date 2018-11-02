package com.dawn.takerxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.dawn.trx.LogUtil;
import com.dawn.trx.observable.IEmitter;
import com.dawn.trx.observable.ObservableCreate;
import com.dawn.trx.observable.RealObservable;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableJust;


public class MainActivity extends AppCompatActivity {
    private EditText editText;
    long t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        editText=findViewById(R.id.ed);



        Subscriber<String>subscriber=new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
        new ObservableJust<String>("dsad");


//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                long current=System.currentTimeMillis();
//               if( current-t1>1000) {
//                   if (s.length() > 0) {
//                       t1=current;
//                       LogUtil.i("=======onnext===>" + s.toString());
//
//                   }
//
//
//               }
//
//            }
//        });








    }

//    public void go(){
//        new RealObservable(new ObservableCreate() {
//            @Override
//            public void fun(IEmitter emitter) {
//                emitter.onNext("dsadsadsa");
//                emitter.onComplete("onComplete");
//                LogUtil.i("==able===thread==>"+Thread.currentThread().getName());
//
//            }
//        }).subscribeOn().observableOn().subscribe(new  Observer() {
//            @Override
//            public void onNext(String s) {
//                LogUtil.i("==onNext======>"+s);
//                LogUtil.i("==onNext===thread==>"+Thread.currentThread().getName());
//
//
//            }
//
//            @Override
//            public void onComplete(String s) {
//                LogUtil.i("==onComplete======>"+s);
//                LogUtil.i("==onComplete===thread==>"+Thread.currentThread().getName());
//
//            }
//        });
//
//    }
}
