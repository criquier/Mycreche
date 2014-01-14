package com.platine.mycreche.listeners.recherche;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

public class MapsListener implements OnClickListener {

	protected Context context;
	
	public MapsListener(Context context){
		this.context = context;
	}
	
	public void onClick(View v) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.650,3.083?q=50.650,3.083(Creche1)"));
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		this.context.startActivity(intent);
	}

}
