package com.platine.mycreche.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.platine.mycreche.activities.user.InscriptionActivity;

public class MonCompteListener implements OnClickListener {
	protected Context context;

	public MonCompteListener(Context cxt){
		this.context=cxt;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//On crée un intent vers l'activité nommé informationContact
		Intent intent = new Intent(this.context, InscriptionActivity.class);
		
		//On initialise les flafs
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		//on lance l'activité
		context.startActivity(intent);

	}
}
