package com.platine.mycreche.listeners.recherche;

import android.content.Context;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class KmSeekBarListener implements OnSeekBarChangeListener {

	protected Context context;
	protected TextView label;
	protected SeekBar km;
	
	public KmSeekBarListener(Context c,TextView label, SeekBar km){
		this.context = c;
		this.label = label;
		this.km = km;
	}
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		int kmValue = this.km.getProgress();
		this.label.setText(kmValue+" km");
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

}
