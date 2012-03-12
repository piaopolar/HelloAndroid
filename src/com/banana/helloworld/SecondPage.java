package com.banana.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.banana.helloworld.HelloWorldActivity;

public class SecondPage extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_dlg);
        
        
        findViewById(R.id.Back2First).setOnClickListener(new OnClickListener()
        {  
            public void onClick(View v)
            {  
            	Intent SecondPage = new Intent(SecondPage.this, HelloWorldActivity.class);
            	startActivity(SecondPage);
            }
        });
        
        findViewById(R.id.ToList).setOnClickListener(new OnClickListener()
        {  
            public void onClick(View v)
            {  
            	TextView tv = (TextView) findViewById(R.id.Text);
            	tv.setText("");
            }
        });
    }
}
