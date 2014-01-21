package com.platine.mycreche.activities.recherche;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import com.platine.mycreche.R;
import com.platine.mycreche.listeners.generals.AnnulerListener;
import com.platine.mycreche.listeners.generals.MailListener;
import com.platine.mycreche.listeners.generals.TelephoneListener;
import com.platine.mycreche.listeners.recherche.MapsListener;

public class InformationCrecheActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information_creche);
		
		//Récupération des boutons de l'interface
		Button telephone = (Button)(findViewById(R.id.telephone));
		Button mail = (Button)(findViewById(R.id.emailCreche));
		Button maps = (Button)findViewById(R.id.maps);
		Button annuler = (Button)findViewById(R.id.annulerDetailCreche);
		
		telephone.setOnClickListener(new TelephoneListener(getApplicationContext()));
		mail.setOnClickListener(new MailListener(this));
		annuler.setOnClickListener(new AnnulerListener(this));
		maps.setOnClickListener(new MapsListener(getApplicationContext()));
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}
}
