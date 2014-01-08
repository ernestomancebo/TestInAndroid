package com.ernesto.testinandroid;

import android.os.Bundle;
import android.widget.TabHost;
import android.app.Activity;
import android.content.res.Resources;

public class Tabs extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabs);

		Resources res = getResources();
		TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
		tabs.setup();

		TabHost.TabSpec spec;

		spec = tabs.newTabSpec("Tab1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("TAB",
				res.getDrawable(android.R.drawable.ic_btn_speak_now));
		tabs.addTab(spec);

		spec = tabs.newTabSpec("Tab2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("BAT",
				res.getDrawable(android.R.drawable.ic_dialog_info));
		tabs.addTab(spec);

		tabs.setCurrentTab(0);
	}
}
