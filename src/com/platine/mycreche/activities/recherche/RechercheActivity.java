package com.platine.mycreche.activities.recherche;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.platine.mycreche.R;
import com.platine.mycreche.listeners.recherche.RechercheListener;

public class RechercheActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recherche);
		
		Button recherche = (Button)findViewById(R.id.buttonRechercher);
		
		EditText labelRecherche = (EditText)findViewById(R.id.editTextRecherche);
	
		TextView rechercheA = (TextView)findViewById(R.id.rechercheAvancee);
		
		
		recherche.setOnClickListener(new RechercheListener(this.getApplicationContext(),false,labelRecherche));
		rechercheA.setOnClickListener(new RechercheListener(this.getApplicationContext(),true));
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}
}
