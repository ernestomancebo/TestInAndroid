package com.ernesto.testinandroid.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
}
