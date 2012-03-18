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
		setContentView(R.layout.query_result_host);// 这里使用了上面创建的xml文件（Tab页面的布局）
		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabSpec spec;
		Intent intent; // Reusable Intent for each tab

		// 第一个TAB
		intent = new Intent(this, CDlgMaterial.class);// 新建一个Intent用作Tab1显示的内容
		spec = tabHost
				.newTabSpec("tab1")
				// 新建一个 Tab
				.setIndicator("Tab1",
						res.getDrawable(android.R.drawable.ic_media_play))// 设置名称以及图标
				.setContent(intent);// 设置显示的intent，这里的参数也可以是R.id.xxx
		tabHost.addTab(spec);// 添加进tabHost

		// 第二个TAB
		intent = new Intent(this, CDlgEquip.class);// 第二个Intent用作Tab1显示的内容
		spec = tabHost
				.newTabSpec("tab2")
				// 新建一个 Tab
				.setIndicator("Tab2",
						res.getDrawable(android.R.drawable.ic_menu_camera))// 设置名称以及图标
				.setContent(intent);// 设置显示的intent，这里的参数也可以是R.id.xxx
		tabHost.addTab(spec);// 添加进tabHost

		tabHost.setCurrentTab(1);
	}

}
