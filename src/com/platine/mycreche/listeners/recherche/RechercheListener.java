package com.platine.mycreche.listeners.recherche;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.platine.mycreche.activities.recherche.RechercheActivity;
import com.platine.mycreche.activities.recherche.RechercheAvanceeActivity;

public class RechercheListener implements OnClickListener {

	protected Context context;
	protected EditText label;
	protected Boolean avancee;
	
	public RechercheListener(Context c){
		this.context = c;
		this.avancee = false;
	}
	
	public RechercheListener(Context c,boolean avancee){
		this.context = c;
		this.avancee = avancee;
	}
	
	public RechercheListener(Context c,boolean avancee, EditText label){
		this.context = c;
		this.label = label;
		this.avancee = avancee;
	}
	
	@Override
	public void onClick(View v) {
		// Si c'est la recherche avancée
		if(this.avancee){
			Intent intent = new Intent(this.context, RechercheAvanceeActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			this.context.startActivity(intent);
		}
		else{
			// Nous sommes en mode recherche normale
				Intent intent = new Intent(this.context, RechercheActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				if(this.label!=null)
				intent.putExtra("adresse", label.getText().toString());
				this.context.startActivity(intent);

				if(this.label!=null)
					Toast.makeText(this.context, "vous recherche au alentours de "+label.getText().toString(), Toast.LENGTH_LONG).show();
			}
		}

}
