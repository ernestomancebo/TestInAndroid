package com.ernesto.testinandroid;

import com.ernesto.testinandroid.adapter.AdaptadorTitulos;
import com.ernesto.testinandroid.model.Titulos;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
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
		registerForContextMenu(lista);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

		final ListView lista = (ListView) findViewById(R.id.lstOpciones);
		menu.setHeaderTitle(((Titulos) lista.getAdapter()
				.getItem(info.position)).getTitulo());
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_ctx_lista, menu);
	}

}
