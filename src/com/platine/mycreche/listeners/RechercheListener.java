package com.platine.mycreche.listeners;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class RechercheListener implements OnClickListener {

	protected Context context;
	
	public RechercheListener(Context c){
		context = c;
	}
	
	@Override
	public void onClick(View v) {
		Log.v("Listener recherche","Recherche");
	}

}
