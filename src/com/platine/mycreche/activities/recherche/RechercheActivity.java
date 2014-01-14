package com.platine.mycreche.activities.recherche;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.platine.mycreche.R;
import com.platine.mycreche.listeners.recherche.RechercheListener;

public class RechercheActivity extends ListActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recherche);
		
		Button recherche = (Button)findViewById(R.id.buttonRechercher);
			
		EditText labelRecherche = (EditText)findViewById(R.id.editTextRecherche);
		
		TextView rechercheA = (TextView)findViewById(R.id.rechercheAvancee);
	
		
		Bundle extra = getIntent().getExtras();
		String adresse = extra.getString("adresse");
		if(adresse != ""){
			labelRecherche.setText(adresse);
		}
		
		String[] listeStrings = {"France","Allemagne","Russie"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.element_liste_creche,listeStrings);
		
		this.setListAdapter(adapter);
		
		recherche.setOnClickListener(new RechercheListener(this.getApplicationContext(),false,labelRecherche));
		rechercheA.setOnClickListener(new RechercheListener(this.getApplicationContext(),true));
	}

	public void onListItemClick(ListView l, View v, int position, long id){
		Intent intent = new Intent(this,InformationCrecheActivity.class);
		startActivity(intent);
	}
		
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}
}
