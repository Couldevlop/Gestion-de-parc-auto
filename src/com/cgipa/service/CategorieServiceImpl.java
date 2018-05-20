package com.cgipa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Categorie;
import com.cgipa.domaine.Site;

public class CategorieServiceImpl implements ICategorie{
	Connection cnx=Singleton.ObtenirConnectionDB();


	@Override
	public int getIdCategorie() {
		ResultSet re = null;
		int rep = 0;
		String req=" SELECT max(idcategorie) as maxid from categorie";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
			re=ps.executeQuery();
			while(re.next())
			{
				 rep = re.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("-----------------Voici l'ID de la table categorie------------------------");
//		System.out.println(rep);
//		System.out.println("----------------------------------------------------------------------------------");
		return rep;
	}

	@Override
	public Categorie AjouterCategorie(Site s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ConsulterCategorie() {
		String req="SELECT *  from categorie ";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String details=rs.getString("libellecategorie");
				System.out.println(details);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
