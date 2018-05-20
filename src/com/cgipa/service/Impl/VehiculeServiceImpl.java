package com.cgipa.service.Impl;

import com.cgipa.domaine.Vehicule;
import com.cgipa.service.CategorieServiceImpl;
import com.cgipa.service.IVehiculeService;
import com.cgipag.ui.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cgipa.DAO.*;

public class VehiculeServiceImpl implements IVehiculeService {
	PreparedStatement ps=null;
	private int idtypevehicule,idfournisseur,idsite,idcategorie,idtypecarburant,idservice, nbrportevehicule,nbrplacevehicule;
	private String puissancevehicule, model, marque, cartegrisevehicule,immatriculationvehicule, pathphotovehicule;
	String dateaquisitionvehicule;
	String datedebutassurance;
	String datefinassurance;
	String datedebutreparation;
	private String  datefinreparation;
	private float coutassurance;
	private float coutreparation;
	private ResultSet rs=null;
	private int idutilisateur;
	Connection cnx=null;
	


	@Override
	public void AjouterVehicule(Vehicule v) {
		 cnx = Singleton.ObtenirConnectionDB();
		
		//----------------------Appel a la couche service pour recuperer les differents ID-------------------
		TypevehiculeServiceImpl tv=new TypevehiculeServiceImpl();
		FournisseurServiceImpl f=new FournisseurServiceImpl();
		SiteServiceImpl site = new SiteServiceImpl();
		CategorieServiceImpl cat=new CategorieServiceImpl();
		TypecarburantServiceImpl carb=new TypecarburantServiceImpl();
		ServiceImpl ser = new ServiceImpl();
		
	//-------------Recuperation de ID-------------------------------------------	
		 idtypevehicule=tv.getIdTypevehicule();
		 idfournisseur=f.getIdFournisseur();
		 idsite=site.getIdSite();
		 idcategorie=cat.getIdCategorie();
		 idtypecarburant=carb.getIdTypecarburant();
		 idservice=ser.getIdServices();
		 
      	int nb; 
		PreparedStatement req; 
		try {
			String sql=" insert into vehicule (IDTYPEVEHICULE, IDFOURNISSEUR, IDSITE, IDCATEGORIE, IDTYPECARBURANT, IDSERVICE, NBRPORTEVEHICULE, PUISSANCEVEHICULE, MODEL, MARQUE, NBRPLACEVEHICULE, CARTEGRISEVEHICULE, IMMATRICULATIONVEHICULE, PATHPHOTOVEHICULE, DATEAQUISITIONVEHICULE, DATEDEBUTASSURANCE, DATEFINASSURANCE, COUTASSURANCE, DATEDEBUTREPARATION, DATEFINREPARATION, COUTREPARATION)  "
			 		+ " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ? )" ;
			req = cnx.prepareStatement(sql);
			req.setInt(1, tv.getIdTypevehicule());
			req.setInt(2, f.getIdFournisseur());
			req.setInt(3, site.getIdSite());
			req.setInt(4, cat.getIdCategorie());
			req.setInt(5, carb.getIdTypecarburant());
			req.setInt(6, ser.getIdServices());
			req.setInt(7, v.getPortiere());
			req.setString(8, v.getPuissance());
			 req.setString(9, v.getModel());
			 req.setString(10, v.getMarque());
			 req.setInt(11, v.getPlaces());
			 req.setString(12, v.getCartegrise());
			 req.setString(13, v.getImmat());
			 req.setString(14, v.getFoto());
			 req.setString(15, v.getDateAquisition());
			 req.setString(16, v.getDebutassur());
			 req.setString(17, v.getFinassur());
			 req.setFloat(18, v.getCoutassurance());
			 req.setString(19, v.getDatedebutreparation());
			 req.setString(20, v.getDatefinreparation());
			 req.setFloat(21, v.getCoutreparation());
			 nb = req.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Requete executé avec succès");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Désolé la requet a échouée");
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "VehiculeServiceImpl [idtypevehicule=" + idtypevehicule + ", idfour=" + idfournisseur + ", idsite=" + idsite
				+ ", idcat=" + idcategorie + ", idtypecar=" + idtypecarburant + ", idservice=" + idservice + "]";
	}

	@Override
	public void AffecterVehicule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int GetVehiculeId() {;
	 Connection   cnx = Singleton.ObtenirConnectionDB();
		int rep = 0;
		String req="SELECT max(idvehicule) as maxid from vehicule";
		try {
		PreparedStatement ps=cnx.prepareStatement(req);
		rs=ps.executeQuery();
//			Statement st=cnx.createStatement();
//            rs=st.executeQuery(req);
			while(rs.next())
			{
				 rep = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println("-----------------Voici l'ID de la table vehicule------------------------");
		System.out.println(rep);
		return rep;

	}
	
	public ResultSet RemplirchampCamion()
	{
		Connection cnx =Singleton.ObtenirConnectionDB();
		ResultSet rs= null;
		int n=0;
		
//		String req="SELECT libelletypecarburant,cartegrisevehicule,model, libellecategorie,puissancevehicule,nbrportevehicule,dateaquisitionvehicule FROM typecarburant T, vehicule V, categorie C WHERE T.IDTYPECARBURANT= V.IDVEHICULE AND C.LIBELLECATEGORIE='camion'";
		String req="SELECT V.IDVEHICULE, V.cartegrisevehicule,V.model,V.puissancevehicule,V.nbrportevehicule,V.dateaquisitionvehicule, V.immatriculationvehicule,V.modeaquisition, V.montantaquisition, C.libellecategorie, E.LIBELLETYPECARBURANT, A.libelletypevehicule "
				+ "FROM VEHICULE V, categorie C, typevehicule A, typecarburant E "
				+ "WHERE V.IDVEHICULE = C.IDCATEGORIE  AND "
				+ " V.IDVEHICULE = A.IDTYPEVEHICULE  AND"
				+ " V.IDVEHICULE = E.IDTYPECARBURANT  AND  "
				+ "C.libellecategorie='camion'";
		try {
			ps=cnx.prepareStatement(req);
			rs=ps.executeQuery();
//			JOptionPane.showMessageDialog(null, "Requete executé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Désolé la requet a échouée");
			e.printStackTrace();
		}
		return rs;
	}
	
	
	//---------------------methode pour remplir le tableau de camion---------------------
	public ResultSet RemplirTableauCamion()
	{
	Connection cnx=Singleton.ObtenirConnectionDB();

		ResultSet re = null;
		String req=" SELECT nom, prenom, tel FROM  individus";
		try {
			PreparedStatement ps=cnx.prepareStatement(req);
			 re=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	
	}
	

	//-----------------Pour rempir combox de Matricule vehicule de la fenetre  ajout de contrat--------------
	public  void remplirComboMatriculeVehicule(JComboBox  cb)
	{
		Connection cnx=Singleton.ObtenirConnectionDB();
		String sql = "SELECT * FROM vehicule";
	try {
		
		PreparedStatement	prepared=cnx.prepareStatement(sql);
		ResultSet result=prepared.executeQuery();
		while(result.next())
		{ 
			String emp=result.getString("immatriculationvehicule");
			 cb.addItem(emp);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	
	//-----------------Pour rempir combox d'utilisateur--------------
		public  void remplirComboUtilisateur(JComboBox  cb)
		{
			Connection cnx=Singleton.ObtenirConnectionDB();
			String sql = "SELECT distinct prenom FROM individus";
		try {
			
			PreparedStatement	prepared=cnx.prepareStatement(sql);
			ResultSet result=prepared.executeQuery();
			while(result.next())
			{ 
				String emp=result.getString("prenom");
				 cb.addItem(emp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		//-----------------Pour rempir combox d'utilisateur--------------
				public  void remplirComboTypevehicule(JComboBox  cb)
				{
					Connection cnx=Singleton.ObtenirConnectionDB();
					String sql = "SELECT distinct libellecategorie FROM categorie";
				try {
					
					PreparedStatement	prepared=cnx.prepareStatement(sql);
					ResultSet result=prepared.executeQuery();
					while(result.next())
					{ 
						String emp=result.getString("libellecategorie");
						 cb.addItem(emp);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				

				//-----------------------Methode pour affecter un vehicule a un utilisateur------------
				public void affectationVehicule(String cb1, String cb2) throws SQLException
				{ 
					Connection cnx=Singleton.ObtenirConnectionDB();
					TypevehiculeServiceImpl tv=new TypevehiculeServiceImpl();
					UtilisateursServiceImpl util=new UtilisateursServiceImpl();
					ResultSet re=util.AffichertousUtil();
				String prenom=re.getString("prenom");
				System.out.println(prenom);
					VehiculeServiceImpl v= new VehiculeServiceImpl();
				
					
				//-------------Recuperation de ID-------------------------------------------	
					  idutilisateur = util.getIdUtilisateurs();
					 idtypevehicule=tv.getIdTypevehicule();
				int idvehicule=v.GetVehiculeId();
				
				int rs=0;
					String sql="insert into affectation(idindividus, idvehicule, prenom,typedevehicule, immatriculationvehicule) values( ?,?,?,?,?)";
					PreparedStatement ps = null;
					try {
						ps = cnx.prepareStatement(sql);
						ps.setInt(1, idutilisateur);
						ps.setInt(2, idvehicule);
						ps.setString(3, prenom);
						ps.setString(4, cb1);
						ps.setString(5, cb2);
						rs=ps.executeUpdate();
					JOptionPane.showInternalConfirmDialog(null, " Affection effectuée avec succès", " NOTIFICATION" , JOptionPane.CLOSED_OPTION);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showConfirmDialog(null,"Affectation échouée");
						e.printStackTrace();
					}
					
				}

				
				//----------Remplir tableau de statistique
				
				public ResultSet RemplirTabstatVeh()
				{
					Connection cnx=Singleton.ObtenirConnectionDB();
					ResultSet re=null;
					String req="SELECT model, marque, nbrportevehicule, puissancevehicule, nbrplacevehicule, cartegrisevehicule, immatriculationvehicule FROM vehicule";
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
