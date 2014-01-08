package com.ernesto.testinandroid.controller;

import com.ernesto.testinandroid.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginControl extends LinearLayout {

	private OnLoginListener listener;

	private EditText txtUsuario, txtPassword;
	private Button btnLogin;
	private TextView lblMensaje;

	public LoginControl(Context context) {
		super(context);
		inicializar();
	}

	public LoginControl(Context contex, AttributeSet attrs) {
		super(contex, attrs);
		inicializar();

		TypedArray tArray = getContext().obtainStyledAttributes(attrs,
				R.styleable.LoginControl);
		btnLogin.setText(tArray.getString(R.styleable.LoginControl_login_text));
		tArray.recycle();
	}

	private void inicializar() {
		String infoServices = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater lInflater = (LayoutInflater) getContext()
				.getSystemService(infoServices);
		lInflater.inflate(R.layout.login, this, true);

		txtUsuario = (EditText) findViewById(R.id.txtUsuario);
		txtPassword = (EditText) findViewById(R.id.txtPassword);
		btnLogin = (Button) findViewById(R.id.btnLogin);
		lblMensaje = (TextView) findViewById(R.id.lblMensaje);

		asignarEventos();
	}

	private void asignarEventos() {
		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onLogin(txtUsuario.getText().toString(), txtPassword
						.getText().toString());
			}
		});
	}

	public void setOnLoginListener(OnLoginListener l) {
		this.listener = l;
	}

	public void setMensaje(String msj) {
		lblMensaje.setText(msj);
	}

}
