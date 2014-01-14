package com.platine.mycreche.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * 
 * @author Thierno Saidou barry
 * Cette classe permet de gerer les utilisateurs
 *
 */
@DatabaseTable
public class Utilisateur {
	@DatabaseField
	private String login;
	@DatabaseField
	private String motPasse;
	
	// Constructeur
	public Utilisateur(){}
	public Utilisateur(String login,String passe){
		this.login=login;
		this.motPasse=passe;
	}
	
	// getters et setters
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	
}
