package com.wik4apps.sendbroadcastprep;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.CellSignalStrengthCdma;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.example.Broadcast"))
        {
            Toast.makeText(context,"MyReceiver is called",Toast.LENGTH_LONG).show();
            Intent intent2 = new Intent(context, MyIntentService2.class);
            intent2.putExtra("MYSTR","this is my string");
            context.startService(intent2);
        }
        if(intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNE"))
        {
            Toast.makeText(context,"Power Disconnected",Toast.LENGTH_LONG).show();
        }

        if(intent.getAction().equals("android.intent.action.SIG_STR"))
        {
            Bundle extras = intent.getExtras();
            Log.d("PHONE", extras.toString());
            Toast.makeText(context,"Signal changed",Toast.LENGTH_LONG).show();
        }

    }
}