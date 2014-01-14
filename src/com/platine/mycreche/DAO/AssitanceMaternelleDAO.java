package com.platine.mycreche.DAO;

import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.platine.mycreche.model.AssitanceMaternelle;

public class AssitanceMaternelleDAO extends DatabaseHelper {
	//L 'objet DAO utilisée pour accèder à nos Objets AssitanceMaternelle
	private Dao<AssitanceMaternelle, Integer> assitanceMaternelleDao = null;
	private RuntimeExceptionDao<AssitanceMaternelle, Integer> simpleRuntimeDao = null;
//constrcuteur
public AssitanceMaternelleDAO(Context cxt){super(cxt);}
/**
 * les methodes CRUD
 */
// Persite un objet Ville
	public void save(AssitanceMaternelle c){
		getAssitanceMaternelleDAO().create(c);
	}
	
	// Extrait de la base de donnée l'objet AssitanceMaternelle dont l'Id es id
	public AssitanceMaternelle getVille(int id){
		return getAssitanceMaternelleDAO().queryForId(id);
	}
	// Recupère tous les objets villes contenue dans la BD
	// Comme pour les precedentes methodes on aurait pu utiliser getAllVilleDao()
	// Mais cette methode n'est pas encore optimisée pour Android et genère souvent des Bugs
	// C'est pour cette raison que l'on pass par un QueryBuilder qui permet d'ecrire des requêtes personnalisées
	public List<AssitanceMaternelle> getAllVilles() {
		Log.i("tous", "creation");
		QueryBuilder<AssitanceMaternelle,Integer> queryBuilder =getAssitanceMaternelleDAO().queryBuilder().orderBy("nom", true);
		PreparedQuery<AssitanceMaternelle> preparedQuery=null;
		
			try {
				preparedQuery = queryBuilder.prepare();
			} catch (java.sql.SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return getAssitanceMaternelleDAO().query(preparedQuery);
				
	}
	// Supprime toutes les instances de AssitanceMaternelle contenues dans la BD
	public void deleteAllAssitanceMaternelles(){
		getAssitanceMaternelleDAO().clearObjectCache();
		
	}
	// retourn le nombre d'instance de AssitanceMaternelle contenu dans la BD
	public long count(){
		return getAssitanceMaternelleDAO().countOf();
	}
/**
 * Crée l'interface DAO  pour la classe AssitanceMaternelle s'il n'existe pas et le met dans 
 * la Cache
 */
public Dao<AssitanceMaternelle, Integer> getDao() throws SQLException {
	if (assitanceMaternelleDao == null) {
		try {
			assitanceMaternelleDao = getDao(AssitanceMaternelle.class);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return assitanceMaternelleDao;
}
/**
 * Retourne l'interface DAO se trouvant dans la Cache
 */
public RuntimeExceptionDao<AssitanceMaternelle, Integer> getAssitanceMaternelleDAO() {
	if (simpleRuntimeDao == null) {
		simpleRuntimeDao = getRuntimeExceptionDao(AssitanceMaternelle.class);
	}
	return simpleRuntimeDao;
}

/**
 * Ferme la BD et nettoie la cache
 */
@Override
public void close() {
	super.close();
	simpleRuntimeDao = null;
}
}
