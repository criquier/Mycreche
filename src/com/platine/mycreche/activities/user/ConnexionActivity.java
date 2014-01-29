package com.platine.mycreche.activities.user;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import com.platine.mycreche.R;
import com.platine.mycreche.listeners.user.ConnexionListener;

public class ConnexionActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_connexion);
		
		//Récupération des boutons de l'interface
				Button connexion = (Button)(findViewById(R.id.boutonConnexion));
				Button annuler = (Button)(findViewById(R.id.annuler));
		// on recupere le login et le mot de passe
				EditText login=(EditText)(findViewById(R.id.editTextPseudo));
				EditText password=(EditText)(findViewById(R.id.editTextPassWord));
			
								
	  // On Intercepte le click sur le boutton en appellant le listener
				connexion.setOnClickListener(new ConnexionListener(this,login,password));
				
				
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}

}
