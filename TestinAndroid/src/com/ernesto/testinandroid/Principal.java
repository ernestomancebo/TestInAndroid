package com.ernesto.testinandroid;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

		final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
		final Button btnHola = (Button) findViewById(R.id.btnSaludar);

		btnHola.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Principal.this, FrmMensaje.class);

				Bundle bundle = new Bundle();
				bundle.putString("NOMBRE", txtNombre.getText().toString());
				intent.putExtras(bundle);

				startActivity(intent);
			}
		});
	}

}
