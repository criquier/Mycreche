package com.platine.mycreche.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * 
 * @author Thierno Saidou barry
 *
 */
@DatabaseTable
public class AssitanceMaternelle extends Entite {
	@DatabaseField
	private String prenom;
	@DatabaseField
	private boolean reconnuCAF;
	@DatabaseField
	private boolean disponible;
	
	// constrcuteur
	public AssitanceMaternelle(){super();}
	public AssitanceMaternelle(String nom,String prenom){
		super(nom);
		this.prenom=prenom;
		
	}
	//getters et setters
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public boolean isReconnuCAF() {
		return reconnuCAF;
	}
	public void setReconnuCAF(boolean reconnuCAF) {
		this.reconnuCAF = reconnuCAF;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
