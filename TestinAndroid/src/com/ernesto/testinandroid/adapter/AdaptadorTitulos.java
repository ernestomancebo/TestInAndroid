package com.ernesto.testinandroid.adapter;

import com.ernesto.testinandroid.R;
import com.ernesto.testinandroid.model.Titulos;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdaptadorTitulos extends ArrayAdapter {
	Activity context;
	Titulos[] datos;

	public AdaptadorTitulos(Activity context, Titulos[] datos) {
		super(context, R.layout.listitem_titular, datos);
		this.context = context;
		this.datos = datos;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View item;
		ViewHolder holder;

		if ((item = convertView) == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			item = inflater.inflate(R.layout.listitem_titular, null);

			holder = new ViewHolder(
					(TextView) item.findViewById(R.id.lblTitulo),
					(TextView) item.findViewById(R.id.lblSubtitulo));

			item.setTag(holder);
		} else {
			holder = (ViewHolder) item.getTag();
		}

		holder.titulo.setText(datos[position].getTitulo());
		holder.subtitulo.setText(datos[position].getSubtitulo());

		return item;
	}

	static class ViewHolder {
		TextView titulo;
		TextView subtitulo;

		ViewHolder(TextView titulo, TextView subtitulo) {
			this.titulo = titulo;
			this.subtitulo = subtitulo;
		}
	}
}
