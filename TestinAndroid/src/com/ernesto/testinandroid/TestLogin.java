package com.ernesto.testinandroid;

import com.ernesto.testinandroid.controller.LoginControl;
import com.ernesto.testinandroid.controller.OnLoginListener;

import android.app.Activity;
import android.os.Bundle;

public class TestLogin extends Activity {
	LoginControl ctrlLogin;

	@Override
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.testlogin);

		ctrlLogin = (LoginControl) findViewById(R.id.ctrlLogin);
		ctrlLogin.setOnLoginListener(new OnLoginListener() {
			@Override
			public void onLogin(String usuario, String password) {
				if (usuario.equals("admin") && password.equals("123"))
					ctrlLogin.setMensaje("Aprobado");
				else
					ctrlLogin.setMensaje("Denegado");
			}
		});

	}
}
