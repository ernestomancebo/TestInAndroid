package com.ernesto.testinandroid.controller;

import java.util.GregorianCalendar;

import com.ernesto.testinandroid.R;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

public class WidgetController extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetMannager,
			int[] appWidgetIDs) {
		for (int i = 0; i < appWidgetIDs.length; i++)
			actualizarWidget(context, appWidgetMannager, appWidgetIDs[i]);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(
				"com.ernesto.testinandroid.ACTUALIZAR_WIDGET")) {
			int widgetID = intent.getIntExtra(
					AppWidgetManager.EXTRA_APPWIDGET_ID,
					AppWidgetManager.INVALID_APPWIDGET_ID);

			AppWidgetManager widgetManager = AppWidgetManager
					.getInstance(context);

			if (widgetID != AppWidgetManager.INVALID_APPWIDGET_ID) {
				actualizarWidget(context, widgetManager, widgetID);
			}
		}
	}

	public static void actualizarWidget(Context context,
			AppWidgetManager appWidgetMannager, int widgetID) {
		SharedPreferences prefs = context.getSharedPreferences("WidgetPrefs",
				Context.MODE_PRIVATE);

		RemoteViews controles = new RemoteViews(context.getPackageName(),
				R.layout.widget);

		controles.setTextViewText(R.id.lblMensaje,
				prefs.getString("msj_" + widgetID, "Hora actual: "));

		String hora = new GregorianCalendar().getTime().toLocaleString();
		controles.setTextViewText(R.id.txtHora, hora);

		appWidgetMannager.updateAppWidget(widgetID, controles);

		Intent intent = new Intent(
				"com.ernesto.testinandroid.ACTUALIZAR_WIDGET");
		intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);

		PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
				widgetID, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		controles
				.setOnClickPendingIntent(R.id.btnActualizarHora, pendingIntent);
	}
}
