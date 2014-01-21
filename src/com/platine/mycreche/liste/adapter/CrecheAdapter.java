package com.platine.mycreche.liste.adapter;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.platine.mycreche.R;
import com.platine.mycreche.model.Creche;

public class CrecheAdapter extends BaseAdapter {

	protected List<Creche> creches;
	protected Activity activity;
	
	public CrecheAdapter(Activity activity, List<Creche> creches){
		this.creches = creches;
		this.activity = activity;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return creches.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return creches.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return creches.get(position).getId();
	}

	public class ViewHolder{
		protected TextView NomCreche;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	        View view = null;
	        if (convertView == null) {

	            LayoutInflater inflator = activity.getLayoutInflater();

	            view = inflator.inflate(R.layout.element_liste_creche, null);

	            view.setClickable(true);
	           
	            final ViewHolder viewHolder = new ViewHolder();

	            viewHolder.NomCreche = (TextView) view.findViewById(R.id.NomCreche);
	            view.setTag(viewHolder);
	       
	        } else {
	            view = convertView;
	        }

	        ViewHolder holder = (ViewHolder) view.getTag();
	        holder.NomCreche.setText(creches.get(position).getNom());
	       
	        // on intercepte le click sur les items de la liste
	        view.setOnClickListener(new OnClickListener() {

	            @Override
	            public void onClick(View v) {
	              
	            }
	        });
	      
	        return view;
		    
	}

}
