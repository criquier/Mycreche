package com.platine.mycreche.listeners.generals;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class AnnulerListener implements OnClickListener {

	protected Activity activity;
	
	public AnnulerListener(Activity a){
		activity = a;
	}
	
	public void onClick(View v) {
		//on dépile la derniere activité (on la ferme)
		this.activity.finish();
	}

}
