package com.ernesto.testinandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FrmMensaje extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frmmensaje);

		TextView txtMensaje = (TextView) findViewById(R.id.txtMensaje);
		Bundle bundle = getIntent().getExtras();

		txtMensaje.setText("Hi " + bundle.getString("NOMBRE") + "\n"
				+ bundle.getBoolean("CHK"));
	}
}
