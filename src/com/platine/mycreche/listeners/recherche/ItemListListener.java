package com.platine.mycreche.listeners.recherche;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.platine.mycreche.activities.recherche.InformationCrecheActivity;

public class ItemListListener implements OnClickListener {

	protected Context context;
	protected long idCreche;
	
	public ItemListListener(Context context, long id){
		this.context = context;
		this.idCreche = id;
	}
	
	public void onClick(View v) {
		Intent intent = new Intent(context,InformationCrecheActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("idCreche", this.idCreche);
		context.startActivity(intent);
	}

}
