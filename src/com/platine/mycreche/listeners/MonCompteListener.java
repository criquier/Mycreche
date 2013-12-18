package com.platine.mycreche.listeners;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MonCompteListener implements OnClickListener {

	public MonCompteListener(){
		
	}
	
	public void onClick(View v) {
		Log.v("Mon Compte Listener","On affiche la page de connexion");
	}

}
