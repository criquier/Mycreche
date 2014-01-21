package com.platine.mycreche.utils;

import java.util.List;

import android.content.Context;
import android.util.Log;

import com.platine.mycreche.DAO.AssitanceMaternelleDAO;
import com.platine.mycreche.DAO.CrecheDAO;
import com.platine.mycreche.DAO.UtilisateurDAO;
import com.platine.mycreche.model.AssitanceMaternelle;
import com.platine.mycreche.model.Creche;
import com.platine.mycreche.model.Utilisateur;
/**
 * 
 * @author Thierno Saidou Barry
 *
 */
public class InitDB {
 public static void fillDB(Context cxt){
	 Log.i("", "===================FILL DB==============================");
	 // instanciation des DAO pour chaque Table
	 CrecheDAO crecheDAO=new CrecheDAO(cxt);
	 UtilisateurDAO userDAO=new UtilisateurDAO(cxt);
	 AssitanceMaternelleDAO assDAO=new AssitanceMaternelleDAO(cxt);
	 
	 // création d'un utilisateur si la BD n'en contient pas
	 if(userDAO.count()==0){
		 Utilisateur u1=new Utilisateur("myscreche", "creche");
		 userDAO.save(u1);
	 }
	 
	 // création de crèches si la BD n'en contient pas
	 if(crecheDAO.count()==0){
		 Creche c1=new Creche("Bebe Sisters");
		 c1.setNumRue("7");
		 c1.setNomRue("Des Stations");
		 c1.setCommune("Lille");
		 c1.setCodePostal("59800");
		 c1.setAdresseMail("contact@bebesister.com");
		 c1.setDescription("Alors voici les bébé syster le top of the top of the world");
		 c1.setLatitude((long) 50.63);
		 c1.setLongitude((long) 3.05);
		 
		 Creche c2=new Creche("Kiki");
		 c2.setNumRue("5");
		 c2.setNomRue("Du Pont Neuf");
		 c2.setCommune("Lille");
		 c2.setCodePostal("59800");
		 c2.setAdresseMail("contact@kiki.fr");
		 c2.setDescription("Alors voici les bébé syster le top of the top of the world");
		 c2.setLatitude((long) 50.64);
		 c2.setLongitude((long) 3.06);
		 
		 Creche c3=new Creche("Looki looki");
		 c3.setNumRue("32");
		 c3.setNomRue("Alhpand");
		 c3.setCommune("Avion");
		 c3.setCodePostal("62210");
		 c3.setAdresseMail("contact@lookilooki.com");
		 c3.setDescription("Alors voici les bébé syster le top of the top of the world");
		 c3.setLatitude((long) 50.41);
		 c3.setLongitude((long) 2.82);
		 
		 
		 

		 crecheDAO.save(c1);
		 crecheDAO.save(c2);
		 crecheDAO.save(c3);
	 }
	 
	 // création d'assistante Maternelle  si la BD n'en contient pas
	 if(assDAO.count()==0){
		 AssitanceMaternelle a1=new AssitanceMaternelle("Habi", "Bah");
		 AssitanceMaternelle a2=new AssitanceMaternelle("Luky", "Luck");
		 AssitanceMaternelle a3=new AssitanceMaternelle("Lufi", "Tomi");
		 assDAO.save(a1);
		 assDAO.save(a2);
		 assDAO.save(a3);
	 }
	 
	 // Affichage du contenu de la BD
	 // Liste des utilisateurs
	 List<Utilisateur> users=userDAO.getAllUtilisateurs();
	 Log.i("", "===================USERS==============================");
	 for (Utilisateur u : users) {
		
			Log.i("user",u.getLogin()+"Mot de Passe:"+u.getMotPasse());
		}
	 //Liste des creches
	 List<Creche> creches=crecheDAO.getAllCreches();
	 Log.i("", "===================USERS==============================");
	 for (Creche c : creches) {
		
			Log.i("creche","Nom:"+c.getNom());
		}
 }
}
