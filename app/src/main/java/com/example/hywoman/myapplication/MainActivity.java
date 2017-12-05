package com.example.hywoman.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends Activity { private int i = 0; private TextView myi;

    @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView
            (R.layout.activity_main); myi = (TextView) findViewById(R.id.i);
    } Handler handler = new Handler() { @Override public void handleMessage(Message msg) { updateThread(); } };
    @Override protected void onStart() { super.onStart(); Thread myThread = new Thread(new Runnable() { public void run()
    { while (true) { try { handler.sendMessage(handler.obtainMessage()); Thread.sleep(1000); }
    catch (Throwable t) { } } } });
        myThread.start(); } private void updateThread() { i++; myi.setText(String.valueOf(i));
    }
}