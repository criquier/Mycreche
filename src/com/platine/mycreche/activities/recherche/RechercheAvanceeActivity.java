package com.platine.mycreche.activities.recherche;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.platine.mycreche.R;
import com.platine.mycreche.listeners.generals.AnnulerListener;
import com.platine.mycreche.listeners.recherche.KmSeekBarListener;
import com.platine.mycreche.listeners.recherche.RechercheListener;

public class RechercheAvanceeActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recherche_avancee);
		
		Button recherche = (Button)findViewById(R.id.rechercheAvancee);
		Button annuler = (Button)findViewById(R.id.annulerRechercheAvance);
		
		EditText label = (EditText)findViewById(R.id.editTextLabel);
	
		SeekBar km = (SeekBar)findViewById(R.id.seekBarKm);
		
		TextView kmlabel = (TextView)findViewById(R.id.kmlabel);
		
		annuler.setOnClickListener(new AnnulerListener(this));
		recherche.setOnClickListener(new RechercheListener(this.getApplicationContext(),false));
		
		km.setMax(200);
		km.setOnSeekBarChangeListener(new KmSeekBarListener(this.getApplicationContext(),kmlabel,km));
		
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}
}
