package com.cgipa.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cgipa.DAO.Singleton;
import com.cgipa.service.ITypecarburant;

public class TypecarburantServiceImpl implements ITypecarburant {
	Connection cnx= Singleton.ObtenirConnectionDB();

	public void ConsulterTypeCarburant() {
		String req="SELECT *  from typecarburant ";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String details=rs.getString("libelletypecarburant");
				System.out.println(details);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public int getIdTypecarburant() {
		ResultSet re = null;
		int rep = 0;
		String req=" SELECT max(idtypecarburant) as maxid from typecarburant";
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
//		System.out.println("-----------------Voici l'ID du type de carburant------------------------");
//		System.out.println(rep);
//		System.out.println("----------------------------------------------------------------------------------");
		return rep;
	}

	@Override
	public String toString() {
		return "TypecarburantServiceImpl [cnx=" + cnx + ", getIdTypecarburant()=" + getIdTypecarburant()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
