package com.banana.helloworld;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class TestListDlg extends ListActivity {
	
	static final String[] COUNTRIES = new String[] {    "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",    "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",};
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_list_dlg);


//		ListView list=new ListView(this);
//		ArrayAdapter<String> arrayadapter =new ArrayAdapter<String>(this, android.R.layout.test_list_dlg,COUNTRIES);
//		list.setAdapter(arrayadapter);
//		list.setOnItemClickListener(this);
//
//		findViewById(R.id.btnBack).setOnClickListener(new OnClickListener() {
//			public void onClick(View v) {
//				Intent intent = new Intent(TestListDlg.this,
//						HelloWorldActivity.class);
//				startActivity(intent);
//			}
//		});
	}
}