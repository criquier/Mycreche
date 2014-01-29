package com.platine.mycreche.listeners.user;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.platine.mycreche.DAO.UtilisateurDAO;
import com.platine.mycreche.model.Utilisateur;

public class InscriptionListener implements OnClickListener {
	
	UtilisateurDAO dao;
	protected Context context;
	protected EditText login;
	protected EditText password;
	protected EditText passwordConf;
	

	
	public InscriptionListener(Context ctx,EditText login,EditText password1,EditText password2) {
		dao=new UtilisateurDAO(ctx);
		this.context = ctx;
		this.login=login;
		this.password=password1;
		this.passwordConf=password2;
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("MOT DE PASSE", "mot de passse: "+password.getText().toString()+" Confirmation: "+passwordConf.getText().toString());
		// On verifie si les deux mot de passe sont identiques et qu'elles ne sont pas nulles
				if(password.equals(passwordConf) && !login.equals("") && !password.equals("")  ){
					// On enregistre les informations dans la base de données
					Utilisateur u=new Utilisateur(login.getText().toString(), password.getText().toString());
					dao.save(u);
					// on appelle le webservice qui va enregistrer le user dans la base de données
					Toast.makeText(this.context,"Inscription Réussie",Toast.LENGTH_LONG).show();
					
				}else{
					// On affiche un Toast pour lui indiquer que les mots de passe ne sont pas identiques
					Toast.makeText(this.context,"Erreurs dans la saisie des informations",Toast.LENGTH_LONG).show();
				}
		

	}

}
