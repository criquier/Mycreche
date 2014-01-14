package com.platine.mycreche.activities.contact;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import com.platine.mycreche.R;
import com.platine.mycreche.listeners.contact.EnvoieMailListener;
import com.platine.mycreche.listeners.generals.AnnulerListener;
import com.platine.mycreche.listeners.generals.TelephoneListener;

public class InformationContactActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information_contact);
		
		//récupération des boutons du layout
		Button annuler = (Button)findViewById(R.id.annulerRechercheAvance);
		Button envoieMail = (Button)findViewById(R.id.envoieMail);
		Button tel = (Button)findViewById(R.id.tel);
		Button mail = (Button)findViewById(R.id.mail);
		
		//initialisation des listener
		annuler.setOnClickListener(new AnnulerListener(this));
		tel.setOnClickListener(new TelephoneListener(this.getApplicationContext()));	
		envoieMail.setOnClickListener(new EnvoieMailListener(this.getApplicationContext()));
	}

	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}
}
