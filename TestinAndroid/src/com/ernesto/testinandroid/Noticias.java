package com.ernesto.testinandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ernesto.testinandroid.adapter.AdaptadorNoticias;
import com.ernesto.testinandroid.datahandler.SaxParser;
import com.ernesto.testinandroid.model.Noticia;

public class Noticias extends Activity {

	List<Noticia> lista = new ArrayList<Noticia>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_noticias);

		SaxParser parser = new SaxParser(
				"http://www.europapress.es/rss/rss.aspx");
		lista.addAll(parser.parse());
		final Noticia[] noticias = lista.toArray(new Noticia[lista.size()]);

		AdaptadorNoticias adaptador = new AdaptadorNoticias(this, noticias);
		final ListView listaNoticias = (ListView) findViewById(R.id.lstNoticias);
		listaNoticias.setAdapter(adaptador);
		registerForContextMenu(listaNoticias);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_ctx_noticias, menu);

		menu.setHeaderTitle(lista.get(info.position).getTitulo());

		MenuItem desc = menu.findItem(R.id.ctx_descripcion_noticia);
		desc.setTitle(lista.get(info.position).getDescripcion());

		final String URL = lista.get(info.position).getLink().toString();
		MenuItem enlace = menu.findItem(R.id.ctx_enlace_noticia);
		enlace.setTitle(URL);

		enlace.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse(URL));
				startActivity(browserIntent);
				return true;
			}
		});

	}
}
