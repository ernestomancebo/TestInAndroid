package com.ernesto.testinandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class Image extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);

		ImageView img = (ImageView) findViewById(R.id.imgView);
		img.setImageResource(R.drawable.ic_launcher);
	}

}
