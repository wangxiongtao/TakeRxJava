package com.dawn.trx;

import android.nfc.Tag;
import android.util.Log;


/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class LogUtil {
    private static final  String TAG="OH";
    private static boolean DEBUG=true;
    public static void  i(String msg){
        if(DEBUG){
            System.out.println(msg);
//            Log.i(TAG,msg);
        }

    }

}
