package com.ernesto.testinandroid;

import com.ernesto.testinandroid.util.Util;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
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
		final Button bntLogin = (Button) findViewById(R.id.btnLogin);
		final Button bntNoticias = (Button) findViewById(R.id.btnNoticias);
		final CheckBox chk = (CheckBox) findViewById(R.id.chkTst);
		final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);

		btnHola.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(Principal.this, FrmMensaje.class);

				Bundle bundle = new Bundle();
				bundle.putString(
						"NOMBRE",
						Util.readFromProperties(getResources().openRawResource(
								R.raw.testing)));
				bundle.putBoolean("CHK", chk.isChecked());
				intent.putExtras(bundle);

				startActivity(intent);
			}
		});

		btnPrueba.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Principal.this, Image.class);
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

		bntLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Principal.this, TestLogin.class);
				startActivity(intent);
			}
		});

		bntNoticias.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Util.isConnectedToInternet(getApplicationContext())) {
					Intent intent = new Intent(Principal.this, Noticias.class);
					startActivity(intent);
				} else {
					Toast t = Toast.makeText(getApplicationContext(),
							"Problemas de conexión", Toast.LENGTH_SHORT);
					t.show();
				}
			}
		});

		registerForContextMenu(txtNombre);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.principal, menu);
		menu.setGroupEnabled(R.id.grpmn1, true);
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_ctx_txteditar, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);

		switch (item.getItemId()) {
		case (R.id.ctx_txteditar_1):
			txtNombre.setText("Selecciono 1");
			return true;
		case (R.id.ctx_txteditar_2):
			txtNombre.setText("Selecciono 2");
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}

}
