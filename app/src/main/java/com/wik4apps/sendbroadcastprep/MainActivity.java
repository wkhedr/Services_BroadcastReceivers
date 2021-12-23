package com.wik4apps.sendbroadcastprep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new
                IntentFilter("com.example.Broadcast");
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        filter.addAction("android.intent.action.SIG_STR");
        MyReceiver receiver = new MyReceiver();
        registerReceiver(receiver, filter);

    }

    public void SendBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.Broadcast");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);

    }

    public void onClickMe(View view) {
        TextView tv = findViewById(R.id.textView);
        counter++;
        tv.setText(String.format("counter = %d", counter));
//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, 10000);


        /*long endTime = System.currentTimeMillis() + 20 * 1000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime -
                                    System.currentTimeMillis());
                        } catch (Exception e) {
                        }
                    }
                }
                tv.setText("Button Pressed");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();*/

    }
}


