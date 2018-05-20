package com.cgipa.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Services;
import com.cgipa.domaine.Site;
import com.cgipa.service.IServices;

public class ServiceImpl implements IServices{
	Connection cnx=Singleton.ObtenirConnectionDB();

	@Override
	public int getIdServices() {
		ResultSet re = null;
		int rep = 0;
		String req=" SELECT max(idservice) as maxid from services";
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
//		System.out.println("-----------------Voici l'ID de la table service------------------------");
//		System.out.println(rep);
//		System.out.println("---------------------------------------------------------------------------------");
		return rep;
	}

	@Override
	public Services AjouterServices(Site s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ConsulterService() {
		String req="SELECT *  from services ";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String details=rs.getString("libellee");
				String chefservice=rs.getString("chef_service");
				System.out.println(details);
				System.out.println(chefservice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void SupprimerService() {
		// TODO Auto-generated method stub
		
	}

}
