package com.ernesto.testinandroid.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Util {

	public static String readFromProperties(InputStream is) {

		String rv = new String();

		try {
			Properties prop = new Properties();
			prop.load(is);

			rv = prop.getProperty("ernesto");

		} catch (IOException e) {
			System.err.println("Failed to open microlog property file");
			e.printStackTrace();
			rv = e.toString();
		} finally {
			return rv;
		}

	}

	public static boolean isConnectedToInternet(Context c) {
		ConnectivityManager connectivity = (ConnectivityManager) c
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null)
				for (int i = 0; i < info.length; i++)
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}

		}
		return false;
	}
}
