package com.platine.mycreche.listeners.contact;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.platine.mycreche.activities.contact.InformationContactActivity;

public class ContactListener implements OnClickListener {

	protected Context context;
	
	public ContactListener(Context c){
		context = c;
	}
	
	@Override
	public void onClick(View v) {
		//On crée un intent vers l'activité nommé informationContact
		Intent intent = new Intent(this.context, InformationContactActivity.class);
		
		//On initialise les flafs
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		//on lance l'activité
		context.startActivity(intent);
	}

}
