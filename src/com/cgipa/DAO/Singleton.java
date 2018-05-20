package com.cgipa.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class Singleton {
	private static final String url="jdbc:mysql://localhost/cgipa?eroDateTimeBehavior = convertToNull";
	private static final String use="root";
	private static final String pwd="";
	private static Connection cn;
	String sql;
	private Statement st;
	
	
public Singleton(){}

public static Connection ObtenirConnectionDB()
{
	if(cn == null)
	{
		try {
			cn=DriverManager.getConnection(url, use, pwd);
			
//			JOptionPane.showMessageDialog(null, "pilote chargé avec succès");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de chargement de pilote");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	
	return cn;
	
}


//-------------- POUR L'EXECUTION DES REQUETS--------------------------------	
	public ResultSet executionQuery(String sql)
	{
		ResultSet rs = null;
		try {
			st =cn.createStatement();
			rs=st.executeQuery(sql);
			System.out.println(sql);
		} catch (SQLException ex) {
			System.err.println(ex);
		}
		
		return rs;
		
	}
	
	
	//--------------------POUR L'EXCUTION DES REQUETSES UPDATE--------------------------
	
	public String executionUpdate(String sql)
	{
		String result = "";
		try {
			st=cn.createStatement();
			st.executeQuery(sql);
			result =sql;
		} catch (SQLException ex) {
			result = ex.toString();
		}
		return result;
		
	}
	
	
	
	//-------------------POUR AFFICHER TOUS LES ELEMNTS---------------------------------
	
	public ResultSet querySelectAll(String nomTable)
	{
		String SQL = "SELECT * FROM " + nomTable;
		System.out.println(SQL);
		return this.executionQuery(SQL);
	}
	
	
//--------------------POUR AFFICHER TOUS LES ELEMENTS AVEC PARAMETRES---------------------	
	
	public ResultSet querySelectAll(String nomTable, String etat)
	{
		String sql = "SELECT * FROM " + nomTable + " WHERE " + etat;
		return this.executionQuery(sql);
	}	
	
	

	//----------------POUR AFFICHER LE RESULTAT EN FONCTION DES COLONNES CHOISIES-----------
	
public ResultSet querySelect(String[] nomColonne, String nomTable)	
{
	int i;
	sql= " SELECT ";
	for (i = 0; i <= nomColonne.length - 1; i++)
	{
		sql += nomColonne[i];
		if(i < nomColonne.length - 1)
		{
			sql += ",";
		}
	}
	sql += " FROM " + nomTable;
	return this.executionQuery(sql);
}


//----------------POUR AFFICHER LE RESULTAT EN FONCTION DES COLONNES CHOISIES ET DU PARAMETRE-----------

public ResultSet fcSelectCommand(String[] nomColonne, String nomTable, String etat)
{
	int i;
	sql= " SELECT ";
	for (i = 0; i <= nomColonne.length - 1; i++)
	{
		sql += nomColonne[i];
		if(i < nomColonne.length - 1)
		{
			sql += ",";
		}
	}
	sql +=" FROM " + nomTable + " WHERE " + etat;
	return this.executionQuery(sql);
	
}
	 

//----------------------POUR INSERER LES DONNEES-------------------------

public String queryInsert(String nomTable, String[] contenuTableau)
{
	int i;
	sql= " INSERT INTO " + nomTable + "VALUES(";
	for (i = 0; i <= contenuTableau.length - 1;  i++)
	{
		sql += " ' " + contenuTableau[i] + " ' ";
		if(i < contenuTableau.length - 1)
		{
			sql += ",";
		}
	}
	sql +=" )";
	return this.executionUpdate(sql);
	
}


//----------------------POUR INSERER LES DONNEES avec nom de table, noms des colonnes-------------------------

public String queryInsert(String nomTable,  String[]nomColonne  ,  String[] contenuTableau)
{
	int i;
	sql= " INSERT INTO " + nomTable + "(";
	for (i = 0; i <= nomColonne.length - 1;  i++)
	{
		sql += nomColonne[i];
		if(i < nomColonne.length - 1)
		{
			sql += ",";
		}
	}
	sql += ")  VALUES(";
	for (i = 0; i <= contenuTableau.length - 1;  i++)
	{
		sql +=" ' " + contenuTableau[i] + " ' ";
		if(i < contenuTableau.length - 1)
		{
			sql += ",";
		}
			
	}
	sql += ")";
	return this.executionUpdate(sql);
	
}

}

