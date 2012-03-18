package com.banana.helloworld;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.util.EncodingUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.banana.network.GetInfo;

import android.app.Activity;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.*;
import android.widget.*;

import com.banana.helloworld.SecondPage;

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
//            	TextView tv = (TextView) findViewById(R.id.Text);
//            	tv.setText("GetHtml...");
//            	try {
//					tv.setText(new String(GetInfo.testGetHtml()));
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}  

            	Intent SecondPage = new Intent(HelloWorldActivity.this, TestListDlg.class);
            	startActivity(SecondPage);
            }
        });
        
        
        
        findViewById(R.id.Next).setOnClickListener(new OnClickListener()
        {  
            public void onClick(View v)
            {  
            	
               	Intent SecondPage = new Intent(HelloWorldActivity.this, QueryListHost.class);
            	startActivity(SecondPage);

//				InputStream is;
//				int code = 999;
//				try {
//					is = getAssets().open("2.json");
//                    byte[] data = new byte[is.available()];
//                    is.read(data);
//                    String content = new String(data);
//                    System.out.println("data begin");
//                    System.out.println(content);
//                    System.out.println("data end");
//                    JSONObject jsonContent = new JSONObject(content);
//                    code = jsonContent.getInt("code");
//
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (JSONException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

				// \Test\assets\yan.txt这里有这样的文件存在

            	
            	
//            	Uri uriTest = Uri.parse("http://sxd.91.com");
//            	Intent intent = new Intent(Intent.ACTION_VIEW, uriTest);
//            	startActivity(intent);
//            	TextView tv = (TextView) findViewById(R.id.Text);
//            	tv.setText("");
            }
        });
        
    }
}