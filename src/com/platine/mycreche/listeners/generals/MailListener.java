package com.platine.mycreche.listeners.generals;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MailListener implements OnClickListener {

	protected Context context;
	
	public MailListener(Context c){
		this.context = c;
	}
	
	@Override
	public void onClick(View v) {
		Log.v("mail listener","on lui propose d'envoyer un mail");
	}

}
