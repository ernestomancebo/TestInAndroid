package com.ernesto.testinandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ElementosListas extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		final String[] datos = { "A", "3", "Ch" };

		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, datos);

		final Spinner spn = (Spinner) findViewById(R.id.spn);
		final TextView txt = (TextView) findViewById(R.id.txtListas);

		adaptador
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spn.setAdapter(adaptador);

		spn.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int position, long id) {
				txt.setText("Seleccionado: " + datos[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				txt.setText("Nada seleccionado");
			}

		});
	}

}
