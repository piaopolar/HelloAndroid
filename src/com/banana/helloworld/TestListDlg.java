package com.banana.helloworld;

import java.util.ArrayList;
import java.util.HashMap;
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

	private String[] myTitle = { "思想决定行为", "行为形成习惯", "习惯决定性格", "性格决定命运",
			"狂热的Android开发者" };

	private String[] myDescript = { "说话办事儿，首先要有一个好的思想，有了好思想，才能体现在行动上",
			"能够坚持的行动将成为习惯", "对事对人的习惯性行为表现为人的性格", "往往成就大事的人，都有着很好的性格",
			"狂热的Android程序员需要有一个好性格" };

	private String[] myNote = { "备注1", "备注2", "备注3", "备注4", "备注5" };

	// private ListView listView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_list_dlg);

		ListView listView = (ListView) findViewById(R.id.listResult);

		ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();
		
		JSon.SetContext(this);
		mData = JSon.getArrayList("xianlvqiyuan.json");

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