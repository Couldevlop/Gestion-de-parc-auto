package com.cgipa.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Fournisseur;
import com.cgipa.service.IFournisseurService;
import com.cgipag.ui.Connexion;

public  class FournisseurServiceImpl implements IFournisseurService{
	Connection cnx =Singleton.ObtenirConnectionDB();;
	ResultSet rs= null;
	
	
	@Override
	public void AjouterFour(Fournisseur f) {
		int nb; 
		PreparedStatement req=null; 
		int re = 0;

		try {
			String sql=" insert into fournisseurs ( NOMFOURNISSEUR , RSFOURNISSEUR , paysfournisseur,  villefournisseur,telfournisseur)  "
					+ "values (?,?,?,? ,?)";
			req = cnx.prepareStatement(sql);
			req.setString(1, f.getNom());
			 req.setString(2, f.getRaisonSociale());
			 req.setString(3, f.getPays());
			 req.setString(4, f.getVille());
			 req.setString(5, f.getTel());
			 nb = req.executeUpdate();
			JOptionPane.showMessageDialog(null, "Requete d'insertion du fournisseur'" +   f.getNom()   +" ' a été effectuée  avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Désolé la requet a échouée");
			e.printStackTrace();
		}
		
	}
	@Override
	public void ConsulterFournisseurs() {
	 
		
	}
	@Override
	public void RechercherFournisseur() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getIdFournisseur() {
		// TODO Auto-generated method stub
		ResultSet re = null;
		int rep = 0;
		String req=" SELECT max(idfournisseur) as maxid from fournisseurs";
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
//		System.out.println("-------------------------Voici l'ID de la table fournisseur----------------");
//		System.out.println(rep);
		return rep;
	}
	

	//-----------------------------------Fonction pour rmplir le combobox  assureur----------------------
		public  void remplirComboAssureur(JComboBox  cb)
		{
			String sql = "SELECT * FROM fournisseurs";
		try {
			PreparedStatement	prepared=cnx.prepareStatement(sql);
			ResultSet result=prepared.executeQuery();
			while(result.next())
			{ 
			
				String emp=result.getString("nomfournisseur");
				 cb.addItem(emp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		
		//---------------------Methode pour remplir le tableau des fournisseurs-------------------------------
		public ResultSet RemplirTableFournisseur()
		{
			cnx=Singleton.ObtenirConnectionDB();
			String sql="SELECT idfournisseur as ID_fournisseur, nomfournisseur as Nom_fournisseur, rsfournisseur as Raison_sociale , paysfournisseur as Pays_du_fournisseur, telfournisseur as telephonne  FROM fournisseurs ";
			try {
				PreparedStatement ps=cnx.prepareStatement(sql);
				rs=ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		
	//--------------------------------Pour afficher les elements au click dans le tableau-----------------------------------	
		public  void modifiderTableauFourClick(JTable T, JTextField t1, JTextField t2,  JTextField t3, JTextField t4, JTextField t5)
		{
			Connection cnx=Singleton.ObtenirConnectionDB();
			
			int row=T.getSelectedRow();
			
			String stable_click=(T.getModel().getValueAt(row, 0).toString());
			String sql=" SELECT * FROM fournisseurs  where idfournisseur=' " + stable_click  +"'  ";
			
			try{
			
				PreparedStatement ps= cnx.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next())
				{			
					
					String add1=rs.getString("nomfournisseur");
					t1.setText(add1);		
					
					String add2=rs.getString("rsfournisseur");
					t2.setText(add2);
					
					String add3=rs.getString("paysfournisseur");
					t3.setText(add3);
					
					String add4=rs.getString("villefournisseur");
					t4.setText(add4);
					
					String add5=rs.getString("telfournisseur");
					t5.setText(add5);
				}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
		
	}
		
		
		//----------------fonction pour eviter les doublons dans la base de donner
		
		public ResultSet eviterDoublonsFournisseurs(String S1, String S2, String S3, String S4, String S5)
		{
			 ResultSet rs=null;
			 int nb=0;
			 String sql=" Select * from fournisseurs";
			 try {
				PreparedStatement ps= cnx.prepareStatement(sql);
				rs=ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
		}
		
		//----------Remplir tableau de statistique
		
		public ResultSet RemplirTabstatFour()
		{
			Connection cnx=Singleton.ObtenirConnectionDB();
			ResultSet re=null;
			String req="SELECT nomfournisseur as NOM, rsfournisseur as RS, paysfournisseur as PAYS, villefournisseur as VILLE, telfournisseur as TELEPHONE FROM  fournisseurs";
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
