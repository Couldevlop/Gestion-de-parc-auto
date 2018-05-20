package com.cgipa.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Contrat;
import com.cgipa.domaine.Fournisseur;
import com.cgipa.domaine.Typecontrat;
import com.cgipa.service.IContrat;

public class ContratServiceImpl implements IContrat {
	ResultSet rs=null;
	PreparedStatement ps=null;
	Connection cnx=Singleton.ObtenirConnectionDB();
	
	
	

	@Override
	public int getIdContrat() {
		return 0;
		
	}

	@Override
	public void Ajoutercontrat(Contrat c) {
		FournisseurServiceImpl f= new FournisseurServiceImpl();
		ContratServiceImpl s= new ContratServiceImpl();
	TypecontratServiceImplmt tc = new TypecontratServiceImplmt();
	Typecontrat tp=new Typecontrat();

		VehiculeServiceImpl v= new VehiculeServiceImpl();
		
			int nb; 
			PreparedStatement req=null; 
			int re = 0;

			try {
				String sql=" insert into contrat ( idfournisseur , idtypecontrat , idvehicule,  datedebcontrat, datefincontrat, montantcontrat)  "
						+ "values (?,?,?,? ,?, ?)";
				req = cnx.prepareStatement(sql);
				req.setInt(1, f.getIdFournisseur());
				req.setInt(2, tc.getIdTypecontrat());
				req.setInt(3, v.GetVehiculeId());
     			req.setString(4, c.getDatedebut());
				 req.setString(5, c.getDatefin());
				 req.setFloat(6, c.getCoutcontrat());
	
			 nb = req.executeUpdate();
				JOptionPane.showMessageDialog(null, "Requete d'insertion du fournisseur'" + tp.getLibellee()   +" ' a été effectuée  avec succès");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Désolé la requet a échouée");
				e.printStackTrace();
			}
			
	
	}

	@Override
	public ResultSet ListerContrat() {
		String Sql=" SELECT DISTINCT nomfournisseur as Nom_fournisseur, rsfournisseur as  Raison_sociale,libelletypecontrat as Type_contrat,"
				+ "immatriculationvehicule as Matricule_vehicule,"
				+ "datedebcontrat as date_debut_contrat,datefincontrat as date_fin_contrat,montantcontrat as montant_du_contrat from fournisseurs,typecontrat,contrat, vehicule";
		try {
			ps=cnx.prepareStatement(Sql);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	//----------------Pour remplir combobox de type de contrt--------------------
	public  void remplirComboTypecontrat(JComboBox  cb)
	{
		String sql = "SELECT * FROM typecontrat";
	try {
		PreparedStatement	prepared=cnx.prepareStatement(sql);
		ResultSet result=prepared.executeQuery();
		while(result.next())
		{ 
		
			String emp=result.getString("libelletypecontrat");
			 cb.addItem(emp);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
