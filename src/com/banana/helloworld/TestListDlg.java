package com.banana.helloworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.banana.basecode.JSon;

public class TestListDlg extends Activity {

	private ArrayList<Map<String, Object>> mData;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_list_dlg);

		ListView listView = (ListView) findViewById(R.id.listResult);

		mData = new ArrayList<Map<String, Object>>();

		JSon.SetContext(this);
		List<Map<String, Object>> list = JSon.getList("xianlvqiyuan.json");
		mData = (ArrayList<Map<String, Object>>) list;

		SimpleAdapter adapter = new SimpleAdapter(this, mData,
				R.layout.list_item, new String[] { "question", "answer1",
						"price1", "answer2", "price2" }, new int[] {
						R.id.question, R.id.answer1, R.id.price1, R.id.answer2,
						R.id.price2 });

		listView.setAdapter(adapter);

		findViewById(R.id.btnBack).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(TestListDlg.this,
						HelloWorldActivity.class);
				startActivity(intent);
			}
		});
		

		EditText mEditText  = (EditText)findViewById(R.id.edtKeyWord);
        mEditText.addTextChangedListener(mTextWatcher);
	}

    TextWatcher mTextWatcher = new TextWatcher() {

		public void afterTextChanged(Editable s) {
			
			EditText mEditText  = (EditText)findViewById(R.id.edtKeyWord);
			String keyWord = mEditText.getText().toString();
			ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
			for(Map<String,Object> m : mData ){
			     String strQuestion = m.get("question") == null? "":(String)m.get("question");
			     if (strQuestion.indexOf(keyWord) != -1) {
			    	 result.add(m);
			     }
			}

			ListView listView = (ListView) findViewById(R.id.listResult);
			SimpleAdapter adapter = new SimpleAdapter(TestListDlg.this, result,
					R.layout.list_item, new String[] { "question", "answer1",
							"price1", "answer2", "price2" }, new int[] {
							R.id.question, R.id.answer1, R.id.price1, R.id.answer2,
							R.id.price2 });

			listView.setAdapter(adapter);
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			
		}
    };
}