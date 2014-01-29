package com.platine.mycreche.activities.user;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import com.platine.mycreche.R;
import com.platine.mycreche.listeners.user.InscriptionListener;

public class InscriptionActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_inscription);
		
		//Récupération des boutons de l'interface
				Button inscription = (Button)(findViewById(R.id.boutonInscription));
				Button annuler = (Button)(findViewById(R.id.annulerDetailCreche));
		// on recupere le login et le mot de passe
				EditText login=(EditText)(findViewById(R.id.editTextPseudo));
				EditText password=(EditText)(findViewById(R.id.editTextPassWord));
				EditText passwordConfirmation=(EditText)(findViewById(R.id.editTextConfirmationPassWord));
				
	
				
	  // On Intercepte le click sur le boutton en appellant le listener
				inscription.setOnClickListener(new InscriptionListener(this,login,password,passwordConfirmation));
				
				
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}

}
