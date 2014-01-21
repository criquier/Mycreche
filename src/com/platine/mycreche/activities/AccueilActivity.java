package com.platine.mycreche.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import com.platine.mycreche.R;
import com.platine.mycreche.listeners.MonCompteListener;
import com.platine.mycreche.listeners.contact.ContactListener;
import com.platine.mycreche.listeners.recherche.RechercheListener;
import com.platine.mycreche.utils.InitDB;


public class AccueilActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		//initialisation de la Base de donnée. cette fonction met du contenu
		// dans la BD de donnée si elle n'en contient pas
		InitDB.fillDB(this);
		//récupération des boutons
		Button contact = (Button)(findViewById(R.id.contact));
		Button recherche = (Button)(findViewById(R.id.recherche));
		Button monCompte = (Button)findViewById(R.id.moncompte);
		
		//initialisation des listeners des boutons
		contact.setOnClickListener(new ContactListener(this.getApplicationContext()));
		recherche.setOnClickListener(new RechercheListener(this.getApplicationContext()));
		monCompte.setOnClickListener(new MonCompteListener());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}

}
