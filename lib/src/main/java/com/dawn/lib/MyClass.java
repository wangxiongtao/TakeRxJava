package com.dawn.lib;

import com.dawn.lib.observable.IStringCallback;
import com.dawn.lib.observable.Observable;
import com.dawn.lib.observer.Observer;

public class MyClass {
    public static void main(String[] args) {
        new Observable(new IStringCallback() {
            @Override
            public void string(Observer observer) {
                observer.onNext("sdasadsadsa");
            }
        }).subscribe(new Observer());
    }
}
