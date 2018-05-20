package com.cgipa.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Utilisateurs;
import com.cgipa.service.IUtilisateurs;
import com.cgipag.ui.Connexion;
import com.cgipag.ui.Dashboard;
import com.cgipag.ui.Sinistres;


public class UtilisateursServiceImpl implements IUtilisateurs{
	Connection cnx=Singleton.ObtenirConnectionDB();
	ResultSet rs;
	

	@Override
	public Utilisateurs consulterUtilisateurs() {
		return null;
	}

	
	@Override
	public void AjouterUtilisateurs(Utilisateurs u) {
		int nb; 
		PreparedStatement req=null; 
		VehiculeServiceImpl v= new VehiculeServiceImpl();
		int re = 0;

		try {
			String sql=" insert into individus (ID_vehicule, nom , prenom , cni, tel,  positionnement)  values (?,?,?,?,?,?)";
			req = cnx.prepareStatement(sql);
			req.setInt(1, v.GetVehiculeId());
			 req.setString(2, u.getNom());
			 req.setString(3, u.getPrenom());
			 req.setString(4, u.getCni());
			 req.setString(5, u.getTel());
			 req.setString(6, u.getPosisitionnement());
			 nb = req.executeUpdate();
			JOptionPane.showMessageDialog(null, "Requeted'ajout de l'utilisateur '" +   u.getNom()    +"' s'est effectuée  executé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Désolé la requet a échouée");
			e.printStackTrace();
		}
	}

	@Override
	public int getIdUtilisateurs() {
		ResultSet re = null;
		int rep = 0;
		String req=" SELECT max(id_individus) as maxid from individus";
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
//		System.out.println("-----------------Voici l'ID de la table individus------------------------");
//		System.out.println(rep);
//		System.out.println("---------------------------------------------------------------------------------");
		return rep;
	}

	@Override
	public void rechercherUtilisateurs() {
		// TODO Auto-generated method stub
		
	}

	public ResultSet AffichertousUtil()
	{
		Connection cnx=Singleton.ObtenirConnectionDB();
		ResultSet re = null;
		String req=" SELECT DISTINCT id_individus, nom, prenom, tel, cni, immatriculationvehicule as vehicule From Vehicule V, individus I";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
			 rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	
	//---------------------------------Methode pour modifier les elements au clic----------------
	public  void modifiderTableauClick(JTable T, JTextField t1, JTextField t2,  JTextField t3, JTextField t4, JComboBox  cb)
	{
		Connection cnx=Singleton.ObtenirConnectionDB();
		
		int row=T.getSelectedRow();
		String stable_click=(T.getModel().getValueAt(row, 0).toString());
		String sql=" SELECT * FROM individus where id_individus=' " + stable_click  +"'  ";
		try{
		
			PreparedStatement ps= cnx.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())
			{
				String add1=rs.getString("positionnement");
				cb.setToolTipText(add1);
				
				String add2=rs.getString("prenom");
				t2.setText(add2);
				
				String add3=rs.getString("cni");
				t3.setText(add3);
				
				String add4=rs.getString("tel");
				t4.setText(add4);
				
				String add5=rs.getString("nom");
				t1.setText(add5);			
				
			}
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	
}
	
	public int recupererIDindividu()
	{
		Connection cnx=Singleton.ObtenirConnectionDB();
		Sinistres si= new Sinistres();
		String prenom=si.RecupererComboboxcb_respo();
//		System.out.println(prenom);
		int rep=0;
		 String re="select id_individus from INDIVIDUS where  prenom=?";
		    PreparedStatement pst=null;
		    ResultSet rst=null;
			try {
				pst = cnx.prepareStatement(re);
				pst.setString(1, prenom);
				  rst=pst.executeQuery();
				 int id_individus=0;
				 while(rst.next())
				 {
					 id_individus =rst.getInt("id_individus");
					 System.out.println("------------affichage de ididividus-------");
					 System.out.println(id_individus);
				 }
				 rep=id_individus;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return rep;
		
	}
	
	
	public int recupererIDvehicule()
	{
		 int id_vehicule = 0;
		Sinistres si= new Sinistres();
		String mat=si.RecupererComboboxcb_mat();
//		System.out.println(mat);
		int rep=0;
		ResultSet rsult=null;
		 String re="SELECT idvehicule from VEHICULE where immatriculationvehicule=?";
		    PreparedStatement pst;
			try {
				pst = cnx.prepareStatement(re);
				pst.setString(1, mat);
				rsult =pst.executeQuery();
				while(rsult.next())
				{
					 id_vehicule=rsult.getInt("idvehicule");
				}
				 rep=id_vehicule;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return rep;
		
	}
	
	public void Archivage()
	{
		Connection cnx=Singleton.ObtenirConnectionDB();
		Connexion con = new Connexion();
		ResultSet re=null;
		String sql="INSERT INTO  logue (username, password,date_logue )  VALUES (?, ?, ?) ";
		try {
			
			java.sql.Date d= new java.sql.Date(System.currentTimeMillis());
			PreparedStatement ps= cnx.prepareStatement(sql);
			ps.setString(1, Connexion.user);
			ps.setString(2, Connexion.pwd);
//			long da=System.currentTimeMillis(); 
			System.out.println(d);
			ps.setDate(3, d);
			ps.executeUpdate();
//			JOptionPane.showMessageDialog(null, "requet excuté avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	//----------Remplir tableau de statistique
	
	public ResultSet RemplirTabstatUtilisateur()
	{
		Connection cnx=Singleton.ObtenirConnectionDB();
		ResultSet re=null;
		String req="SELECT nom, prenom, cni, tel, positionnement as statut FROM individus";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
			re=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return re;
	}
	
	public void RemplirComboxUtilisateurHistorique( JComboBox b)
	{
		Connection cnx=Singleton.ObtenirConnectionDB();
		ResultSet rt=null;
		String sql="SELECT username FROM logue ";
		try {
			PreparedStatement p = cnx.prepareStatement(sql);
			rt=p.executeQuery();
			String tempon;
			while(rt.next())
			{
				tempon=rt.getString("username");
				b.addItem(tempon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
	

	//----------Remplir tableau de Historique de connexion
	
		public ResultSet RemplirTabstatHistoriqueConnexion(String c)
		{
			Connection cnx=Singleton.ObtenirConnectionDB();

			ResultSet re=null;
			String req="SELECT * FROM logue where username=?";
			try {
				PreparedStatement ps=cnx.prepareStatement(req);
//			 String pre=Dashboard.prenom;
				ps.setString(1, c);
				re=ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return re;
		}




		//----------Remplir tableau de Historique de connexion
		
			public ResultSet RemplirTabstatHistoriqueConnexionDate(String c1, String c2)
			{
				Connection cnx=Singleton.ObtenirConnectionDB();

				ResultSet re=null;
				String req="SELECT username, password, date_logue FROM logue where date_logue BETWEEN   ?   AND  ?";
				try {
					PreparedStatement ps=cnx.prepareStatement(req);
//				 String pre=Dashboard.prenom;
					ps.setString(1, c1);
					ps.setString(2, c2);
					re=ps.executeQuery();
					if(re.equals(" "))
					{
						JOptionPane.showInternalMessageDialog(null, "Désolé rien n'a ete chargé");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return re;
			}
	
}


