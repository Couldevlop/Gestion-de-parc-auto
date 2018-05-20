package com.cgipa.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cgipa.DAO.Singleton;
import com.cgipa.service.ITypecontrat;

public class TypecontratServiceImplmt implements ITypecontrat {
	Connection cnx=Singleton.ObtenirConnectionDB();

	@Override
	public int getIdTypecontrat() {
		// TODO Auto-generated method stub
				ResultSet re = null;
				int rep = 0;
				String req=" SELECT max(idcontrat) as maxid from contrat";
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
//				System.out.println("-------------------------Voici l'ID de la table fournisseur----------------");
//				System.out.println(rep);
				return rep;
	}

}
