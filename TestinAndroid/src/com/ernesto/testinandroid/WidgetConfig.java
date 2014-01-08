package com.ernesto.testinandroid;

import com.ernesto.testinandroid.controller.WidgetController;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WidgetConfig extends Activity {

	private int widgetID = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_config);

		Bundle params = getIntent().getExtras();
		widgetID = params.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
				AppWidgetManager.INVALID_APPWIDGET_ID);

		final Button btnAceptar = (Button) findViewById(R.id.btnAceptar);
		final Button btnCancelar = (Button) findViewById(R.id.btnCancelar);
		final EditText txtEditar = (EditText) findViewById(R.id.txtMensaje);

		btnCancelar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		btnAceptar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SharedPreferences pref = getSharedPreferences("WidgetPrefs",
						Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = pref.edit();

				editor.putString("msj_" + widgetID, txtEditar.getText()
						.toString());

				AppWidgetManager manager = AppWidgetManager
						.getInstance(WidgetConfig.this);
				WidgetController.actualizarWidget(WidgetConfig.this, manager,
						widgetID);

				Intent resultado = new Intent();
				resultado.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
						widgetID);
				setResult(RESULT_OK, resultado);

				finish();
			}
		});
		setResult(RESULT_CANCELED);

	}
}
