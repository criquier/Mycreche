package com.platine.mycreche.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.platine.mycreche.model.AssitanceMaternelle;
import com.platine.mycreche.model.Creche;
import com.platine.mycreche.model.Utilisateur;
/**
 * 
 * @author Thierno saidou BARRY
 * Cette classe herite OrmLiteSqliteOpenHelper donc elle possède toutes les
 * Methodes permettant de faire  des opérations sur notre BD (ouverture, fermeture,...)
 * 
 */


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	// Nom de la Base de Donnée, on pourra donner le nom que l'on veut
	private static final String DATABASE_NAME = "mycreche.db";
	
	// A chaque fois que la BD est modifie, cette version est incrémentée
	private static final int DATABASE_VERSION = 1;

	public DatabaseHelper(Context context) {
		
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		 Log.i("", "===================Helper==============================");
		Log.i("message","chargement du helper");
	}

	/**
	 * Cette methode est appellée implicitement lors de la première création de la BD
	 * C'est en ce moment que les tables de notre BD sont créées
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
	
			
			try {
				Log.i(DatabaseHelper.class.getName(), "Creation");
				TableUtils.createTable(connectionSource, Creche.class);
				TableUtils.createTable(connectionSource, AssitanceMaternelle.class);
				TableUtils.createTable(connectionSource, Utilisateur.class);
			} catch (java.sql.SQLException e) {
				// TODO Auto-generated catch block
				Log.e(DatabaseHelper.class.getName(), "Impossible de créer la BD", e);
			}
		
			
		
	

		
	}

	/**
	 * Cette methode est appellées lors de la mise à jour de la BD
	 * L'anciènne est supprimée et la une nouvelle est crée avec une incrementation 
	 * De la version de la BD
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		
			
			try {
				onCreate(db, connectionSource);
				Log.i(DatabaseHelper.class.getName(), "Mise à jour");
				TableUtils.dropTable(connectionSource, Creche.class, true);
				TableUtils.dropTable(connectionSource, AssitanceMaternelle.class, true);
				TableUtils.dropTable(connectionSource, Utilisateur.class, true);
			} catch (java.sql.SQLException e) {
				// TODO Auto-generated catch block
				Log.e(DatabaseHelper.class.getName(), "Impossible de supprimer la BD", e);
			}
			
			
	

	}


	


	
}