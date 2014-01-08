package com.ernesto.testinandroid;

import com.ernesto.testinandroid.adapter.AdaptadorTitulos;
import com.ernesto.testinandroid.model.Titulos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Titular extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lstopciones);

		final byte size = 20;
		Titulos[] data = new Titulos[size];

		for (int t = 0; t < size; t++) {
			data[t] = new Titulos("Titulo " + t, "Subtitulo largo " + t);
		}

		AdaptadorTitulos adpatador = new AdaptadorTitulos(this, data);
		final ListView lista = (ListView) findViewById(R.id.lstOpciones);
		lista.setAdapter(adpatador);
	}
}
