package com.cgipa.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Site;
import com.cgipa.service.ISiteServive;

public class SiteServiceImpl implements ISiteServive{
	Connection cnx=Singleton.ObtenirConnectionDB();

	public int getIdSite() {
		ResultSet re = null;
		int rep = 0;
		String req=" SELECT max(idsite) as maxid from sites";
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
//		System.out.println("-----------------Voici l'ID de la table site------------------------");
//		System.out.println(rep);
//		System.out.println("----------------------------------------------------------------------------------");
		return rep;
	}

	public Site AjouterSite(Site s) {
		// TODO Auto-generated method stub
		return null;
	}

	public void ConsulterSite() {
		String req="SELECT *  from sites ";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String details=rs.getString("emplacement");
				System.out.println(details);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	//----------------------Fonction pour rmplir le combobox de sites------------------------------
	public  void remplirComboSite()
	{
		String sql = "SELECT * FROM sites";
	try {
		PreparedStatement	prepared=cnx.prepareStatement(sql);
		ResultSet result=prepared.executeQuery();
		while(result.next())
		{ 
			JComboBox cb_site = new JComboBox();
			String emp=result.getString("emplacement");
			 cb_site.addItem(emp);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
}
