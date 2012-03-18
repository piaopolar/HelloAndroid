package com.banana.helloworld;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class QueryListHost extends TabActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.query_result_host);// ����ʹ�������洴����xml�ļ���Tabҳ��Ĳ��֣�
		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabSpec spec;
		Intent intent; // Reusable Intent for each tab

		// ��һ��TAB
		intent = new Intent(this, CDlgMaterial.class);// �½�һ��Intent����Tab1��ʾ������
		spec = tabHost
				.newTabSpec("tab1")
				// �½�һ�� Tab
				.setIndicator("Tab1",
						res.getDrawable(android.R.drawable.ic_media_play))// ���������Լ�ͼ��
				.setContent(intent);// ������ʾ��intent������Ĳ���Ҳ������R.id.xxx
		tabHost.addTab(spec);// ��ӽ�tabHost

		// �ڶ���TAB
		intent = new Intent(this, CDlgEquip.class);// �ڶ���Intent����Tab1��ʾ������
		spec = tabHost
				.newTabSpec("tab2")
				// �½�һ�� Tab
				.setIndicator("Tab2",
						res.getDrawable(android.R.drawable.ic_menu_camera))// ���������Լ�ͼ��
				.setContent(intent);// ������ʾ��intent������Ĳ���Ҳ������R.id.xxx
		tabHost.addTab(spec);// ��ӽ�tabHost

		tabHost.setCurrentTab(1);
	}

}
