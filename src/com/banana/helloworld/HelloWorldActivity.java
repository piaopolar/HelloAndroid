package com.banana.helloworld;

import android.app.Activity;

import android.os.Bundle;
import android.widget.TextView;

public class HelloWorldActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.main);
        TextView tv = new TextView(this);
        tv.setText("Now project name is Hello Android");
        setContentView(tv);
    }
}