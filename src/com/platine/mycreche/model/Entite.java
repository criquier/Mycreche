package com.platine.mycreche.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * 
 * @author Thierno Saidou barry
 * Classe de base regroupant les propietes communes aux classes
 * Creche et Assistante Maternelle
 *
 */
public class Entite {
	@DatabaseField(generatedId=true)
	  /**
	   * Identifie de manière unique chaque objet de la classe
	   * Cette propriéte est gerée automatiquement par la base de donné à travers
	   * L'annotation DatabaseField(generatedId=true) 
	   */
	 protected long id;
	 /**
	  * DatabaseField indique que la propriété est un champs de la BD
	  */
	  @DatabaseField
	 protected String numRue;
	  @DatabaseField
	 protected String nomRue;
	  @DatabaseField
	 protected String codePostal;
	  @DatabaseField
	 protected String commune;
	  @DatabaseField
	 protected String adresseMail;
	  @DatabaseField
	 protected String telephone;
	  @DatabaseField
	 protected String nom;
	 // constructeurs
	public Entite(){}
	public Entite(String nom){
		this.nom=nom;
	}
	public Entite(String rue,String nomRue, String cp, String commune, 
			String mail, String telephone, String nom){
		this.nomRue=rue;
		this.nomRue=nomRue;
		this.codePostal=cp;
		this.commune=commune;
		this.adresseMail=mail;
		this.telephone=telephone;
		this.nom=nom;
	}
	 //getters et Setters
	public String getNumRue() {
		return numRue;
	}
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	 

 
}
