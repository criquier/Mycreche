package com.platine.mycreche.listeners;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

public class TelephoneListener implements OnClickListener {

	private Context context;

	public TelephoneListener(Context c){
		this.context = c;
	}
	
	@Override
	public void onClick(View v) {
		//on crée un intent vers laction de telephoner
		Intent intent = new Intent(Intent.ACTION_CALL);
		 
		//on initialise les flags
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		//on met en place les paramètres
		String uri = "tel:06666666";
		intent.setData(Uri.parse(uri));

		//on lance l'activité
		context.startActivity(intent);
	}

}
