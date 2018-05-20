package com.cgipa.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Sinistre;
import com.cgipa.service.ISinistreService;
import com.cgipag.ui.Sinistres;

public class SinistreServiceImpl implements ISinistreService{
Connection cnx=Singleton.ObtenirConnectionDB();
//Sinistres s= new Sinistres();
UtilisateursServiceImpl util =  new UtilisateursServiceImpl();
	
	@Override
	public Sinistre ConsulterSinistre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AjouterSinistre(Sinistre s) {

    //------------------Recuperation des id------------------------
    int id_individus=util.recupererIDindividu();
    System.out.println(id_individus);
   int idvehicule=util.recupererIDvehicule();
		int i=0;
		String req="Insert into sinistre(idvehicule, idindividu,lieusinistre, datesinistre, degatmatsinistre, degatcorsinistre,nbrdecessinistre) "
				+ "values(?, ?, ? , ?, ?, ?, ?)";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
		ps.setInt(1,idvehicule);
		ps.setInt(2, id_individus);
		ps.setString(3, s.getLieu());
		ps.setString(4, s.getDatesin());
		ps.setString(5, s.getDegatmat());
		ps.setString(6, s.getDegatcor());
		ps.setInt(7, s.getNbdeces());
			i=ps.executeUpdate();
JOptionPane.showMessageDialog(null, "Insertion effectuée avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null," Désolé la requete à echoué");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int GetSinistreId() {
		ResultSet re = null;
		int rep = 0;
		String req=" SELECT max(idsinistre) as maxid from sinistre";
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
//		System.out.println("-----------------Voici l'ID de la table sinistre------------------------");
//		System.out.println(rep);
//		System.out.println(rep);
		return rep;
	}
 
	
	
	//---------------------methode pour remplir le tableau de sinistre---------------------
	public ResultSet RemplirTableauSinistre()
	{
	Connection cnx=Singleton.ObtenirConnectionDB();

		ResultSet re = null;
		String req="SELECT idsinistre, nom as Responsable,immatriculationvehicule as Matricule_Vehicule, lieusinistre as Lieu,datesinistre as Date, degatmatsinistre Degats_Materiels,degatcorsinistre as Degats_Corporels "
				+ "From sinistre S, vehicule V, individus I where idsinistre =id_vehicule and id_individus=id_vehicule";
//		String req="SELECT * From sinistre ";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
			 re=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
}
	
	
	//-----------------Pour rempir combox  nom responsable de sinistre--------------
	public  void remplirComboRespoSinistre(JComboBox  cb)
	{
		Connection cnx=Singleton.ObtenirConnectionDB();
		String sql = "SELECT nom as Responsable,immatriculationvehicule as Matricule_Vehicule, lieusinistre as lieu "
				+ "From sinistre S, vehicule V, individus I where idsinistre =id_vehicule and id_individus=id_vehicule";
	try {
		
		PreparedStatement	prepared=cnx.prepareStatement(sql);
		ResultSet result=prepared.executeQuery();
		while(result.next())
		{ 
			String emp=result.getString("Responsable");
			 cb.addItem(emp);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	//-----------------Pour rempir combox  nom responsable de sinistre--------------
		public  void remplirComboMatriculeVheiculeSinistre(JComboBox  cb)
		{
			Connection cnx=Singleton.ObtenirConnectionDB();
			String sql = "SELECT distinct nom as Responsable,immatriculationvehicule as Matricule_Vehicule, lieusinistre as lieu "
					+ "From sinistre S, vehicule V, individus I where idsinistre =id_vehicule and id_individus=id_vehicule";
		try {
			
			PreparedStatement	prepared=cnx.prepareStatement(sql);
			ResultSet result=prepared.executeQuery();
			while(result.next())
			{ 
				String emp=result.getString("Matricule_Vehicule");
				 cb.addItem(emp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		public String RecupererSelection(String s)
		{
			String element = null;
			element=s;
			
			return element;
		}
		
		//----------Remplir tableau de statistique
		
		public ResultSet RemplirTabstatSin()
		{
			Connection cnx=Singleton.ObtenirConnectionDB();
			ResultSet re=null;
			String req="SELECT lieusinistre, datesinistre, degatmatsinistre, degatcorsinistre, nbrdecessinistre  FROM sinistre";
			try {
				PreparedStatement ps=cnx.prepareStatement(req);
				re=ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return re;
		}
}