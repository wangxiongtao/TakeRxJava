package com.dawn.takerxjava.newp;

import com.dawn.takerxjava.B;
import com.dawn.takerxjava.BSon;

/**
 * Created by Administrator on 2018/6/12 0012.
 */

public class A2 {
    public void fun1(){
        new B(){
            @Override
            protected void fun() {
                super.fun();
            }
        }.fun();

    }
}
