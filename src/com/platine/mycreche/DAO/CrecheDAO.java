package com.platine.mycreche.DAO;

import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.platine.mycreche.model.Creche;

public class CrecheDAO extends DatabaseHelper {
	//L 'objet DAO utilisé pour accèder à nos Objets Creche
			private Dao<Creche, Integer> crecheDao = null;
			private RuntimeExceptionDao<Creche, Integer> simpleRuntimeDao = null;
		//constrcuteur
		public CrecheDAO(Context cxt){super(cxt);}
		/**
		 * les methodes CRUD
		 */
		// Persite un objet Ville
			public void save(Creche c){
				getCrecheDao().create(c);
			}
			
			// Extrait de la base de donnée l'objet Creche dont le nom est nom
			public List<Creche> getCreche(String commune){
				PreparedQuery<Creche> preparedQuery=null;
				
				Where<Creche, Integer> queryBuilder;
				try {
					queryBuilder = getCrecheDao().queryBuilder().where().eq("commune", commune);
					preparedQuery = queryBuilder.prepare();
				} 
				catch (java.sql.SQLException e) {
				}
				
		         return getCrecheDao().query(preparedQuery); 
												
			}
			// Extrait de la base de donnée l'objet Creche dont l'Id es id
						public Creche getCreche(int id){
							return getCrecheDao().queryForId(id);
						}
			// Recupère tous les objets villes contenue dans la BD
			// Comme pour les precedentes methodes on aurait pu utiliser getAllCrechesDao()
			// Mais cette methode n'est pas encore optimisée pour Android et genère souvent des Bugs
			// C'est pour cette raison que l'on pass par un QueryBuilder qui permet d'ecrire des requêtes personnalisées
			public List<Creche> getAllCreches() {
				Log.i("tous", "creation");
				QueryBuilder<Creche,Integer> queryBuilder =getCrecheDao().queryBuilder().orderBy("nom", true);
				PreparedQuery<Creche> preparedQuery=null;
				
					try {
						preparedQuery = queryBuilder.prepare();
					} catch (java.sql.SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				return getCrecheDao().query(preparedQuery);
						
			}
			// Supprime toutes les instances de Creche contenues dans la BD
			public void deleteAllCreches(){
				getCrecheDao().clearObjectCache();
				
			}
			// retourn le nombre d'instance de Creche contenu dans la BD
			public long count(){
				return getCrecheDao().countOf();
			}
		/**
		 * Crée l'interface DAO  pour la classe Creche s'il n'existe pas et le met dans 
		 * la Cache
		 */
		public Dao<Creche, Integer> getDao() throws SQLException {
			if (crecheDao == null) {
				try {
					crecheDao = getDao(Creche.class);
				} catch (java.sql.SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return crecheDao;
		}
		/**
		 * Retourne l'interface DAO se trouvant dans la Cache
		 */
		public RuntimeExceptionDao<Creche, Integer> getCrecheDao() {
			if (simpleRuntimeDao == null) {
				simpleRuntimeDao = getRuntimeExceptionDao(Creche.class);
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
