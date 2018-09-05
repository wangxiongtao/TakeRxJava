package com.dawn.takerxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dawn.trx.LogUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

public class Main2Activity extends AppCompatActivity {
    private ObservableOnSubscribe<String>onSubscribe;
    private String string="1234";
    private int anInt=1;
    Observable<String> observable;
    ObservableEmitter<String> emitter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        onSubscribe=new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                emitter=e;

            }
        };
        observable=Observable.create(onSubscribe).debounce(400, TimeUnit.MILLISECONDS);

        observable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtil.i("======accept========>"+s);
            }
        });


    }
    public void onClick(View v){
        anInt++;
        string=anInt+"";


        emitter.onNext(string);




    }
}
