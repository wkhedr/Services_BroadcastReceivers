package com.wik4apps.sendbroadcastprep;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class MyIntentService2 extends IntentService {


    public MyIntentService2() {
        super("MyIntentService2");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String str = intent.getStringExtra("MYSTR");
            synchronized (this) {
                try {
                    wait(5000);
                    Log.d("MYSTR", str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }


}