package com.platine.mycreche.activities.contact;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import com.platine.mycreche.R;
import com.platine.mycreche.listeners.contact.EnvoieMailListener;
import com.platine.mycreche.listeners.generals.AnnulerListener;

public class MailActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_envoie_mail);
		
		//Récupération des boutons de l'interface
		Button annuler = (Button)(findViewById(R.id.annulerRechercheAvance));
		Button envoyermail = (Button)(findViewById(R.id.envoie));
		
		//Récupération des fields text
		EditText email = (EditText)findViewById(R.id.editTextEmail);
		EditText titre = (EditText)findViewById(R.id.editTextTitre);
		EditText message = (EditText)findViewById(R.id.editTextMessage);
		
		//Récupération du contenu des fields
		String emailContenu = email.getText().toString();
		String titreContenu = titre.getText().toString();
		String messageContenu = message.getText().toString();
		
		//initialisation des Listeners
		annuler.setOnClickListener(new AnnulerListener(this));
		envoyermail.setOnClickListener(new EnvoieMailListener(this.getApplicationContext(),emailContenu,titreContenu,messageContenu));		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}
}
