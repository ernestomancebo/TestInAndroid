package com.ernesto.testinandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
		listaNoticias.setOnScrollListener(new OnScrollListener() {

			boolean isScrolling = false;

			@Override
			public void onScrollStateChanged(AbsListView arg0, int scrollState) {
				if (scrollState != 0)
					isScrolling = true;
				else
					isScrolling = false;
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {

				// Scrolled up until the beginning of the list
				if (isScrolling && listaNoticias.getFirstVisiblePosition() == 0) {
					Toast msjToast = Toast.makeText(getApplicationContext(),
							"Inicio de la lista", Toast.LENGTH_SHORT);
					msjToast.show();
				}

				// Scrolled down until the end of the list
				if (listaNoticias.getLastVisiblePosition() == listaNoticias
						.getAdapter().getCount() - 1
						&& listaNoticias.getChildAt(
								listaNoticias.getChildCount() - 1).getBottom() <= listaNoticias
								.getHeight()) {
					Toast msjToast = Toast.makeText(getApplicationContext(),
							"Fin de la lista", Toast.LENGTH_SHORT);
					msjToast.show();
				}
			}
		});
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
