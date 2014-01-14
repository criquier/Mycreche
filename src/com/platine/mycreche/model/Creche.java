package com.platine.mycreche.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author Thierno Saidou barry
 * La classe crèche herite de la classe entité et permet de modeliser une crèche
 */
@DatabaseTable
public class Creche extends Entite {
	@DatabaseField
	public String description;
	@DatabaseField
	public String type;
	@DatabaseField
	public Long latitude;
	@DatabaseField
	public Long longitude;
	
	// Constructeurs
	public Creche(){ super();}
	
	public Creche(String nom){ super(nom);}
	
	public Creche(String nom, String des, String type,Long latitude, Long longitude){
		super(nom);
		this.description=des;
		this.type=type;
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public Creche(String nom,Long latitude, Long longitude){
		super(nom);
		this.latitude=latitude;
		this.longitude=longitude;
	}
	
	//getters et setters
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	
	

}
