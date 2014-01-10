package com.ernesto.testinandroid.adapter;

import com.ernesto.testinandroid.R;
import com.ernesto.testinandroid.model.Noticia;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdaptadorNoticias extends ArrayAdapter {

	Activity context;
	Noticia[] datos;

	public AdaptadorNoticias(Activity context, Noticia[] datos) {
		super(context, R.layout.listitem_noticias, datos);
		this.context = context;
		this.datos = datos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View item;
		ViewHolder holder;

		if ((item = convertView) == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			item = inflater.inflate(R.layout.listitem_noticias, null);

			holder = new ViewHolder(
					(TextView) item.findViewById(R.id.lblTitulo_Noticia),
					(TextView) item.findViewById(R.id.lblDescripcion_Noticia),
					(TextView) item.findViewById(R.id.lblFecha_Noticia));

			item.setTag(holder);
		} else {
			holder = (ViewHolder) item.getTag();
		}

		holder.titulo.setText(datos[position].getTitulo());
		holder.descripcion.setText(datos[position].getDescripcion());
		holder.fecha.setText(datos[position].getFecha());

		return item;
	}

	static class ViewHolder {
		TextView titulo;
		TextView descripcion;
		TextView fecha;

		ViewHolder(TextView titulo, TextView subtitulo, TextView fecha) {
			this.titulo = titulo;
			this.descripcion = subtitulo;
			this.fecha = fecha;
		}
	}
}
