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

public class TestListDlg extends Activity {

	private String[] myTitle = { "˼�������Ϊ", "��Ϊ�γ�ϰ��", "ϰ�߾����Ը�", "�Ը��������",
			"���ȵ�Android������" };

	private String[] myDescript = { "˵�����¶�������Ҫ��һ���õ�˼�룬���˺�˼�룬�����������ж���",
			"�ܹ���ֵ��ж�����Ϊϰ��", "���¶��˵�ϰ������Ϊ����Ϊ�˵��Ը�", "�����ɾʹ��µ��ˣ������źܺõ��Ը�",
			"���ȵ�Android����Ա��Ҫ��һ�����Ը�" };

	private String[] myNote = { "��ע1", "��ע2", "��ע3", "��ע4", "��ע5" };

	// private ListView listView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_list_dlg);

		ListView listView = (ListView) findViewById(R.id.listResult);

		ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();
		int lengh = myTitle.length;

		for (int i = 0; i < lengh; i++) {

			Map<String, Object> item = new HashMap<String, Object>();

			item.put("title", myTitle[i]);

			item.put("Descript", myDescript[i]);

			item.put("note", myNote[i]);

			mData.add(item);

		}

		SimpleAdapter adapter = new SimpleAdapter(this, mData,
				R.layout.list_item, new String[] { "title", "Descript",
						"note" }, new int[] { R.id.title, R.id.descript,
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