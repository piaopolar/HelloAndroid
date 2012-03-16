package com.banana.helloworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.banana.basecode.JSon;

public class TestListDlg extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_list_dlg);

		ListView listView = (ListView) findViewById(R.id.listResult);

		ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();
		
		JSon.SetContext(this);
		List<Map<String,Object>> list = JSon.getList("xianlvqiyuan.json");
		mData = (ArrayList<Map<String, Object>>) list;

		SimpleAdapter adapter = new SimpleAdapter(this, mData,
				R.layout.list_item, new String[] { "question", "answer1",
						"price1" }, new int[] { R.id.title, R.id.descript,
						R.id.note });

		listView.setAdapter(adapter);

		findViewById(R.id.btnBack).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(TestListDlg.this,
						HelloWorldActivity.class);
				startActivity(intent);
			}
		});
	}
}