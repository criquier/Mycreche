package com.platine.mycreche.listeners.recherche;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

import com.platine.mycreche.model.Creche;

public class MapsListener implements OnClickListener {

	protected Context context;
	protected Creche creche;
	
	public MapsListener(Context context,Creche creche){
		this.context = context;
		this.creche = creche;
	}
	
	public void onClick(View v) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+creche.getLatitude()+","+creche.getLongitude()+"?q="+creche.getLatitude()+","+creche.getLongitude()+"("+creche.getNom()+")"));
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		this.context.startActivity(intent);
	}

}
