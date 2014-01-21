package com.platine.mycreche.listeners.generals;

import com.platine.mycreche.utils.Constantes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MailListener implements OnClickListener {

	protected Context context;
	protected String adresse;
	
	public MailListener(Context c){
		this.context = c;
		this.adresse = Constantes.EMAIL_EQUIPE;
	}
	
	public MailListener(Context c, String adresse){
		this.context = c;
		this.adresse = adresse;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		
		//initialisation du flag
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setType("text/plain");
		
		//préparation des données à transmettre
		//le mail sera celui que l'on créera pour recevoir les informations des utilisateurs
		intent.putExtra(Intent.EXTRA_EMAIL, this.adresse);

		//on lance l'activité
		this.context.startActivity(Intent.createChooser(intent, "Send Email"));
		Log.v("mail listener","on lui propose d'envoyer un mail");
	}

}
