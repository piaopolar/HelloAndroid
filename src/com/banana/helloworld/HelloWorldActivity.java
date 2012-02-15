package com.banana.helloworld;

import com.banana.network.GetInfo;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class HelloWorldActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        findViewById(R.id.Pre).setOnClickListener(new OnClickListener()
        {  
            public void onClick(View v)
            {  
            	TextView tv = (TextView) findViewById(R.id.Text);
            	tv.setText("GetHtml...");
            	try {
					tv.setText(new String(GetInfo.testGetHtml()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
            }
        });
        
        findViewById(R.id.Next).setOnClickListener(new OnClickListener()
        {  
            public void onClick(View v)
            {  
            	TextView tv = (TextView) findViewById(R.id.Text);
            	tv.setText("");
            }
        });
        
//        TextView tv = new TextView(this);
//        tv.setText("Now project name is Hello Android");
//        setContentView(tv);
    }
}