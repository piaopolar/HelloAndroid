package com.banana.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.ArrayList;

import com.testMyListView.TableAdapter;
import com.testMyListView.TableAdapter.TableCell;
import com.testMyListView.TableAdapter.TableRow;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

/**
 * @author hellogv
 */

public class CDlgMaterial extends Activity {
	/** Called when the activity is first created. */
	ListView lv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.material);
		this.setTitle("ListView����Ӧʵ�ֱ��---hellogv");
		lv = (ListView) this.findViewById(R.id.ListView01);
		ArrayList<TableRow> table = new ArrayList<TableRow>();
		TableCell[] titles = new TableCell[5];// ÿ��5����Ԫ
		int width = this.getWindowManager().getDefaultDisplay().getWidth()
				/ titles.length;
		// �������
		for (int i = 0; i < titles.length; i++) {
			titles[i] = new TableCell("����" + String.valueOf(i), width + 8 * i,
					LayoutParams.FILL_PARENT, TableCell.STRING);
		}
		table.add(new TableRow(titles));
		// ÿ�е�����
		TableCell[] cells = new TableCell[5];// ÿ��5����Ԫ
		for (int i = 0; i < cells.length - 1; i++) {
			cells[i] = new TableCell("No." + String.valueOf(i),
					titles[i].width, LayoutParams.FILL_PARENT, TableCell.STRING);
		}
		cells[cells.length - 1] = new TableCell(android.R.drawable.ic_media_play,
				titles[cells.length - 1].width, LayoutParams.WRAP_CONTENT,
				TableCell.IMAGE);
		// �ѱ�������ӵ����
		for (int i = 0; i < 12; i++)
			table.add(new TableRow(cells));
		TableAdapter tableAdapter = new TableAdapter(this, table);
		lv.setAdapter(tableAdapter);
		lv.setOnItemClickListener(new ItemClickEvent());
	}

	class ItemClickEvent implements AdapterView.OnItemClickListener {
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Toast.makeText(CDlgMaterial.this,
					"ѡ�е�" + String.valueOf(arg2) + "��" + "arg3" + String.valueOf(arg3), 500).show();
		}
	}
}
