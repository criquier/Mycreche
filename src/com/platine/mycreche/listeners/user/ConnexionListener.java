package com.platine.mycreche.listeners.user;

import com.platine.mycreche.DAO.UtilisateurDAO;
import com.platine.mycreche.model.Utilisateur;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class ConnexionListener extends Activity implements OnClickListener {

	UtilisateurDAO dao;
	protected Context context;
	protected EditText login;
	protected EditText password;
	

	
	public  ConnexionListener(Context ctx,EditText login,EditText password) {
		dao=new UtilisateurDAO(ctx);
		this.context = ctx;
		this.login=login;
		this.password=password;

		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// on verifie les informations sont correctes
		
	}

}
