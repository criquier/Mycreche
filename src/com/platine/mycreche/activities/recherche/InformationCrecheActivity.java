package com.platine.mycreche.activities.recherche;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.platine.mycreche.R;
import com.platine.mycreche.DAO.CrecheDAO;
import com.platine.mycreche.listeners.generals.AnnulerListener;
import com.platine.mycreche.listeners.generals.MailListener;
import com.platine.mycreche.listeners.generals.TelephoneListener;
import com.platine.mycreche.listeners.recherche.MapsListener;
import com.platine.mycreche.model.Creche;

public class InformationCrecheActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information_creche);
		
		//Récupération des boutons de l'interface
		Button telephone = (Button)(findViewById(R.id.telephone));
		Button mail = (Button)(findViewById(R.id.emailCreche));
		Button maps = (Button)findViewById(R.id.boutonInscription);
		Button annuler = (Button)findViewById(R.id.annulerDetailCreche);
		
		//recupération des textView
		TextView description = (TextView)findViewById(R.id.descriptionCreche);
		TextView nom = (TextView)findViewById(R.id.nomCreche);
		TextView adresse = (TextView)findViewById(R.id.adresseCreche);
		TextView distance = (TextView)findViewById(R.id.distanceCreche);
		
		Bundle extra = getIntent().getExtras();
		
		CrecheDAO manager = new CrecheDAO(getApplicationContext());
		Creche creche = new Creche();
		
		if(extra != null){
			long idCreche = extra.getLong("idCreche");
			creche = manager.getCreche(idCreche);
			description.setText(creche.getDescription());
			nom.setText(creche.getNom());
			adresse.setText(creche.getNumRue()+" rue "+creche.getNomRue()+", "+creche.getCodePostal()+" "+creche.getCommune());
			distance.setText("0km");
		}
		
		
		
		//on affecte les listeners
		telephone.setOnClickListener(new TelephoneListener(getApplicationContext(),creche.getTelephone()));
		mail.setOnClickListener(new MailListener(this,creche.getAdresseMail()));
		annuler.setOnClickListener(new AnnulerListener(this));
		maps.setOnClickListener(new MapsListener(getApplicationContext(),creche));
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}
}
