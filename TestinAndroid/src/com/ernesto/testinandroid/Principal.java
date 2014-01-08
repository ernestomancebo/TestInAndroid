package com.ernesto.testinandroid;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

		final Button btnHola = (Button) findViewById(R.id.btnSaludar);
		final Button btnPrueba = (Button) findViewById(R.id.btnPrueba);
		final Button btnTab = (Button) findViewById(R.id.btnTab);

		btnHola.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final CheckBox chk = (CheckBox) findViewById(R.id.chkTst);
				final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);

				Intent intent = new Intent(Principal.this, FrmMensaje.class);

				Bundle bundle = new Bundle();
				bundle.putString("NOMBRE", txtNombre.getText().toString());
				bundle.putBoolean("CHK", chk.isChecked());
				intent.putExtras(bundle);

				startActivity(intent);
			}
		});

		btnPrueba.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Principal.this, Titular.class);
				startActivity(intent);
			}
		});

		btnTab.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Principal.this, Tabs.class);
				startActivity(intent);
			}
		});
	}
}
