package com.dawn.takerxjava;

import com.dawn.trx.LogUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class q {

    public static void main(String[] args) {
//        r();
        zip();
        Observable.just("");

    }

    public static void r() {

        new ObservableCreate<>(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

//                e.onNext("send data");

            }
        }).startWith("startwith").subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                System.out.println("=====onNext====>" + value);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public static void merger(){

        final long t=System.currentTimeMillis();
        Observable<String> observable1= Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Thread.sleep(3000);
                e.onNext("one");
                e.onComplete();

            }
        }).subscribeOn(Schedulers.newThread());
        Observable<String> observable2=  Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Thread.sleep(6000);
                e.onNext("two");
                e.onComplete();

            }
        }).subscribeOn(Schedulers.newThread());


        Observable.merge(observable2,observable1)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {
                        System.out.println("=====onNext====>" + value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("=====onComplete====>"+(System.currentTimeMillis()-t));

                    }
                });
    }
    public static void zip(){

        Observable<String> observable1= Observable.just("1","2","3");
        Observable<String> observable2= Observable.just("1","2");

        Observable.zip(observable2, observable1, new BiFunction<String, String, Object>() {
            @Override
            public String apply(String s, String s2) throws Exception {
                return s+"and"+s2;
            }
        }).subscribe(new Observer<Object>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                System.out.println("==value=========>"+value);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
    public static void debounce(final String s){

        Observable<String> observable1= Observable.just("1","2","3");
        Observable<String> observable2= Observable.just("1","2");

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext(s);
            }
        }).debounce(400, TimeUnit.MILLISECONDS).subscribe(new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                LogUtil.i("==value=========>"+value);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }



}
