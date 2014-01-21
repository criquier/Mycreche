package com.platine.mycreche.utils;
/**
 * author: Thierno Saidou BARRY
 * Cette classe permettra à nos fonctions de retourner deux objets en même temps
 * Dans le cas de la determination des villes situées dans un rayon R
 * Cette structure sera utilisée pour retourner la ville et la distance 
 * La separant de la ville d'origine. Donc le calcul de distance 
 * Entre les deux villes se fait une seule fois. Toutes les autres fonctions 
 * De l'application vont reutilisées ce resultat
 */
import java.io.Serializable;

public class Pair<F, S> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 930879842806261219L;
	private F premier; //premier member of pair
    private S second; //second member of pair
    // Constructeur
    public Pair(F premier, S second) {
        this.premier = premier;
        this.second = second;
    }
    // modifie le premier element de la Pair
    public void setpremier(F premier) {
        this.premier = premier;
    }
    // modifie le deuxième element de la Pair
    public void setSecond(S second) {
        this.second = second;
    }
    // retourne le premier element de la Pair
    public F getpremier() {
        return premier;
    }
    // retourne le deuxième element de la Pair
    public S getSecond() {
        return second;
    }
}