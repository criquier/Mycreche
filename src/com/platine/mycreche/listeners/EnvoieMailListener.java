package com.platine.mycreche.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.platine.mycreche.activities.contact.InformationContactActivity;
import com.platine.mycreche.activities.contact.MailActivity;

public class EnvoieMailListener implements OnClickListener {

	protected Context context;
	protected String email,titre,message;
	
	//constructeur pour affiche de la page d'envoie de mail
	public EnvoieMailListener(Context c){
		this.context = c;
		this.email = null;
		this.titre = null;
		this.message = null;
	}
	
	//constructeur pour envoie du mail
	public EnvoieMailListener(Context c,String email,String titre,String message){
		this.context = c;
		this.email = email;
		this.titre = titre;
		this.message = message;
	}
	
	public void onClick(View v) {
		//si on est sur la page de mail on envoie le mail
		if(this.email != null){
			//TODO erreur a corriger : from outside of an Activity context requires the FLAG_ACTIVITY_NEW_TASK
			Intent intent = new Intent(Intent.ACTION_SEND);
			
			//initialisation du flag
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setType("text/plain");
			
			//préparation des données à transmettre
			//le mail sera celui que l'on créera pour recevoir les informations des utilisateurs
			intent.putExtra(Intent.EXTRA_EMAIL, this.email);
			intent.putExtra(Intent.EXTRA_SUBJECT, this.titre);
			intent.putExtra(Intent.EXTRA_TEXT, this.message);
	
			//on lance l'activité
			this.context.startActivity(Intent.createChooser(intent, "Send Email"));
		
			//on redirige vers la page d'information
			intent = new Intent(this.context,InformationContactActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			this.context.startActivity(intent);		
			
		}
		else{
			//sinon on envoie l'utilisateur sur la page d'envoie de mail
			Intent intent = new Intent(this.context,MailActivity.class);
			
			//initialisation des flags
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			//on lance l'activité
			this.context.startActivity(intent);			
		}
	}

}
