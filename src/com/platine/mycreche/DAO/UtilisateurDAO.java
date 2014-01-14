package com.platine.mycreche.DAO;

import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.platine.mycreche.model.Utilisateur;


public class UtilisateurDAO extends DatabaseHelper {
	//L 'objet DAO utilisée pour accèder à nos Objets Utilisateur
		private Dao<Utilisateur, Integer> utilisateurDao = null;
		private RuntimeExceptionDao<Utilisateur, Integer> simpleRuntimeDao = null;
	//constrcuteur
	public UtilisateurDAO(Context cxt){super(cxt);}
	/**
	 * les methodes CRUD
	 */
	// Persite un objet Utilisateur
		public void save(Utilisateur u){
			getUtilisateurDao().create(u);
		}
		
		// Extrait de la base de donnée l'objet Utilisateur dont l'Id es id
		public Utilisateur getUtilisateur(int id){
			return getUtilisateurDao().queryForId(id);
		}
		// Recupère tous les objets Utilsateurs contenue dans la BD
		// Comme pour les precedentes methodes on aurait pu utiliser getAllUtilisateurDao()
		// Mais cette methode n'est pas encore optimisée pour Android et genère souvent des Bugs
		// C'est pour cette raison que l'on pass par un QueryBuilder qui permet d'ecrire des requêtes personnalisées
		public List<Utilisateur> getAllUtilisateurs() {
			Log.i("tous", "creation");
			QueryBuilder<Utilisateur,Integer> queryBuilder =getUtilisateurDao().queryBuilder().orderBy("login", true);
			PreparedQuery<Utilisateur> preparedQuery=null;
			
				try {
					preparedQuery = queryBuilder.prepare();
				} catch (java.sql.SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return getUtilisateurDao().query(preparedQuery);
					
		}
		// Supprime toutes les instances de Utilisateurs contenues dans la BD
		public void deleteAllUtilisateurs(){
			getUtilisateurDao().clearObjectCache();
			
		}
		// retourn le nombre d'instance de Utilisateurcontenu dans la BD
		public long count(){
			return getUtilisateurDao().countOf();
		}
	/**
	 * Crée l'interface DAO  pour la classe Utilisateur s'il n'existe pas et le met dans 
	 * la Cache
	 */
	public Dao<Utilisateur, Integer> getDao() throws SQLException {
		if (utilisateurDao == null) {
			try {
				utilisateurDao = getDao(Utilisateur.class);
			} catch (java.sql.SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return utilisateurDao;
	}
	/**
	 * Retourne l'interface DAO se trouvant dans la Cache
	 */
	public RuntimeExceptionDao<Utilisateur, Integer> getUtilisateurDao() {
		if (simpleRuntimeDao == null) {
			simpleRuntimeDao = getRuntimeExceptionDao(Utilisateur.class);
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
