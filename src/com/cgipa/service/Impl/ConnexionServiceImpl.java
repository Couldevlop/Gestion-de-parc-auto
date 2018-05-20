package com.cgipa.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Connexion;
import com.cgipa.service.IconnexionService;

public class ConnexionServiceImpl implements IconnexionService{
	

//	@Override
//	public void EnregistrerUtilisateurs() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void EnregistrerUtilisateurs(Connexion c) {
		// TODO Auto-generated method stub
		
		Connection cnx=Singleton.ObtenirConnectionDB();
		ResultSet r= null;
		String sql="INSERT INTO login(Nom, Prenom, username,password,niveau, Contact1, Contact2, dateEnreg,  Ville, Quartier,Adresse, Service, chef_hierachique, nationalite) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		try {
			PreparedStatement ps=cnx.prepareStatement(sql);
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3,c.getUsername() );
			ps.setString(4, c.getPassword());
			ps.setInt(5, c.getLevel());
			ps.setString(6, c.getContact1());
			ps.setString(7, c.getContact2());
			ps.setString(8, c.getDateEnreg());
			ps.setString(9, c.getVille());
			ps.setString(10, c.getQuartier());
			ps.setString(11, c.getAdresse());
			ps.setString(12, c.getService());
			ps.setString(13, c.getChef_hierachique());
			ps.setString(14, c.getNationalite());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Insertion reussie");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Désolé la requet a échouée");
			e.printStackTrace();
		}
	}

	

	
}
