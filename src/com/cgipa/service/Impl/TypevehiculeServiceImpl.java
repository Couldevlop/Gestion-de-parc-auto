package com.cgipa.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Services;
import com.cgipa.domaine.Site;
import com.cgipa.domaine.TypeVehicule;
import com.cgipa.service.ITypevehicule;

public class TypevehiculeServiceImpl implements ITypevehicule {
	Connection cnx=Singleton.ObtenirConnectionDB();

	@Override
	public int getIdTypevehicule() {
		ResultSet re = null;
		int rep = 0;
		String req=" SELECT max(idtypevehicule) as maxid from typevehicule";
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
//		System.out.println("-----------------Voici l'ID du type de vehicule------------------------");
//		System.out.println(rep);
//		System.out.println("----------------------------------------------------------------------------------");
		return rep;
	

	}

	public Services AjouterTypevehicule(Site s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ConsulterTypevehicule() {
		String req="SELECT *  from typevehicule ";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String details=rs.getString("libelletypevehicule");
				System.out.println(details);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void SupprimerTypevehicule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeVehicule AjouterTypevehicule(TypeVehicule t) {
		// TODO Auto-generated method stub
		return null;
	}

}
