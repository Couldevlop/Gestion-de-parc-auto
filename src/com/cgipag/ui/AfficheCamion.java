package com.cgipag.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cgipa.DAO.Singleton;
import com.cgipa.service.Impl.VehiculeServiceImpl;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import datechooser.beans.DateChooserCombo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;

public class AfficheCamion extends JPanel {
	private JTextField txtcarburant;
	private JTextField txtcartegrise;
	private JTextField txtmodele;
	private JTextField txtpuissance;
	private JTextField txtportieres;
	private JTextField txtstatut;
	private JTextField txtmodaqui;
	private JTextField txtmontanaqui;
	private JTable table;
	Connection cnx=null;
	ResultSet rs=null;
	JLabel Dateacquisition;
	private JTextField txtdate;

	/**
	 * Create the panel.
	 */
	public AfficheCamion() {
		cnx=Singleton.ObtenirConnectionDB();
		VehiculeServiceImpl v= new VehiculeServiceImpl();
//		remplirTableau();
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("- Caracteristique du materiel -");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(339, 11, 226, 25);
		add(lblNewLabel);
		
		JLabel lblCarburant = new JLabel("Carburant :");
		lblCarburant.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCarburant.setBounds(203, 63, 76, 14);
		add(lblCarburant);
		
		JLabel lblCarteGrise = new JLabel("Carte grise :");
		lblCarteGrise.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCarteGrise.setBounds(203, 88, 76, 14);
		add(lblCarteGrise);
		
		JLabel lblModele = new JLabel("Modele :");
		lblModele.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblModele.setBounds(203, 113, 76, 14);
		add(lblModele);
		
		txtcarburant = new JTextField();
		txtcarburant.setBounds(289, 61, 131, 20);
		add(txtcarburant);
		txtcarburant.setColumns(10);
		
		txtcartegrise = new JTextField();
		txtcartegrise.setColumns(10);
		txtcartegrise.setBounds(289, 86, 131, 20);
		add(txtcartegrise);
		
		txtmodele = new JTextField();
		txtmodele.setColumns(10);
		txtmodele.setBounds(289, 111, 131, 20);
		add(txtmodele);
		
		JLabel lblPuissance = new JLabel("Puissance :");
		lblPuissance.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPuissance.setBounds(543, 64, 76, 14);
		add(lblPuissance);
		
		JLabel lblPortires = new JLabel("Portières :");
		lblPortires.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPortires.setBounds(543, 89, 76, 14);
		add(lblPortires);
		
		JLabel lblStatut = new JLabel("Statut :");
		lblStatut.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStatut.setBounds(543, 114, 76, 14);
		add(lblStatut);
		
		txtpuissance = new JTextField();
		txtpuissance.setColumns(10);
		txtpuissance.setBounds(623, 61, 131, 20);
		add(txtpuissance);
		
		txtportieres = new JTextField();
		txtportieres.setColumns(10);
		txtportieres.setBounds(623, 86, 131, 20);
		add(txtportieres);
		
		txtstatut = new JTextField();
		txtstatut.setColumns(10);
		txtstatut.setBounds(623, 111, 131, 20);
		add(txtstatut);
		
		JLabel lblPhotoDuVehicule = new JLabel("Photo du vehicule :");
		lblPhotoDuVehicule.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPhotoDuVehicule.setBounds(390, 159, 131, 14);
		add(lblPhotoDuVehicule);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfficheCamion.class.getResource("/com/cgipag/ui/img/mercedes.jpg")));
		label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label.setBounds(328, 184, 275, 141);
		add(label);
		
		JLabel lblInformationSur = new JLabel("- Information sur le mode d'acquisition -");
		lblInformationSur.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblInformationSur.setBounds(297, 362, 333, 25);
		add(lblInformationSur);
		
	     Dateacquisition = new JLabel("Date d'acquisition :");
	     Dateacquisition.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	     Dateacquisition.setBounds(326, 415, 118, 14);
		add(Dateacquisition);
		
		JLabel lblModeDacquisition = new JLabel("Mode d'acquisition :");
		lblModeDacquisition.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblModeDacquisition.setBounds(326, 441, 118, 14);
		add(lblModeDacquisition);
		
		JLabel lblMontantDacquisition = new JLabel("Montant d'acquisition :");
		lblMontantDacquisition.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMontantDacquisition.setBounds(326, 466, 131, 14);
		add(lblMontantDacquisition);
		
		txtmodaqui = new JTextField();
		txtmodaqui.setColumns(10);
		txtmodaqui.setBounds(472, 439, 131, 20);
		add(txtmodaqui);
		
		txtmontanaqui = new JTextField();
		txtmontanaqui.setColumns(10);
		txtmontanaqui.setBounds(470, 464, 131, 20);
		add(txtmontanaqui);
		
		JLabel lblLes = new JLabel("- Les utilsateurs du materiel -");
		lblLes.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblLes.setBounds(364, 514, 239, 25);
		add(lblLes);
		
		JScrollPane  tablecamion = new JScrollPane();
		tablecamion.setBounds(143, 550, 611, 89);
		add(tablecamion);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"                           Nom utilisateur", "    Prenom", "Telephone"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		tablecamion.setViewportView(table);
		
		txtdate = new JTextField();
		txtdate.setColumns(10);
		txtdate.setBounds(472, 413, 131, 20);
		add(txtdate);
		
		JButton btnactu = new JButton("Actualiser");
		btnactu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remplirTableau();
			}
		});
		btnactu.setBounds(98, 486, 111, 23);
		add(btnactu);
		
		JLabel lblMotifDeRecherche = new JLabel("Motif de recherche :");
		lblMotifDeRecherche.setForeground(Color.RED);
		lblMotifDeRecherche.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMotifDeRecherche.setBounds(10, 19, 153, 14);
		add(lblMotifDeRecherche);
		
		JList list = new JList();
		list.setBounds(47, 63, 1, 1);
		add(list);
		
		JComboBox cbrecherche = new JComboBox();
		cbrecherche.setBounds(20, 44, 124, 20);
		add(cbrecherche);
		rechercheComboMatriculeVehicule(cbrecherche);
//		v.remplirComboMatriculeVehicule(cbrecherche);
		//--------------Appel a la couche service--------------------
		
		reecrirlesInfosdeCamion();
		

}
	
	public void remplirTableau()
	{
		
VehiculeServiceImpl ve= new VehiculeServiceImpl();
	rs=ve.RemplirTableauCamion();
	table.setModel(DbUtils.resultSetToTableModel(rs));
		
	}
	
	
	
	public void reecrirlesInfosdeCamion()
	{
		VehiculeServiceImpl veh= new VehiculeServiceImpl();
		ResultSet rs= veh.RemplirchampCamion();
		try {
			if(rs.next())
			{
				String carburant=rs.getString("LIBELLETYPECARBURANT");
				txtcarburant.setText(carburant);
				
				String  cartegrise =rs.getString("cartegrisevehicule");
				txtcartegrise.setText(cartegrise);
				
				String modele=rs.getString("MODEL");
			  txtmodele.setText(modele);
			
				String  puissance=rs.getString("puissancevehicule");
		    	txtpuissance.setText(puissance);
			
				String portieeres=rs.getString("nbrportevehicule");
			txtportieres.setText(portieeres);
			
			String statut=rs.getString("libelletypevehicule");
			txtstatut.setText(statut); 
			
					String dateaqui=rs.getString("dateaquisitionvehicule");
				txtdate.setText(dateaqui);
				
				String modaqi=rs.getString("modeaquisition");
				txtmodaqui.setText(modaqi);
				
				
				String montantaqui=rs.getString("montantaquisition");
				txtmontanaqui.setText(montantaqui);
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//-----------------Methode de motif de recherche
	
	
		public  void rechercheComboMatriculeVehicule(JComboBox  cb)
		{
			Connection cnx=Singleton.ObtenirConnectionDB();
			       VehiculeServiceImpl vh= new VehiculeServiceImpl();
			       
		try {

			ResultSet result=vh.RemplirchampCamion();;
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
}
