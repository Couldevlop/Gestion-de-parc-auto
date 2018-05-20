package com.cgipag.ui;

import javax.swing.JPanel;
import com.cgipa.DAO.*;
import com.cgipa.domaine.TypeVehicule;
import com.cgipa.domaine.Vehicule;
import com.cgipa.service.Impl.FournisseurServiceImpl;
import com.cgipa.service.Impl.SiteServiceImpl;
import com.cgipa.service.Impl.VehiculeServiceImpl;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import datechooser.beans.DateChooserDialog;
import datechooser.beans.DateChooserCombo;
import nu.zoom.swing.desktop.component.filechooser.impl.RegExpFileFilter;
import java.util.List;
import nu.zoom.swing.desktop.component.stringmenu.StringMenuItem;
import java.awt.Choice;

public class AjouterVehicule extends JPanel {
	private JTextField coutassur;
	private JTextField txt_mat;
	private JTextField porte;
	private JTextField txt_puissance;
	private JTextField place;
	private JTextField txt_cgrise;
	private JTextField txt_mod;
	private JTextField txt_carb;
	private JTextField txt_coutcontra;
	private JTextField txt_repar;
	JComboBox cb_cat;
	JComboBox cb_service;
	JComboBox cb_statut;
	JComboBox cb_assureur;
	Connection db;
	ResultSet rs;
	JComboBox cb_site;
	Connection cnx;
	TypeVehicule tv;
private int portiers;
private JTextField txtmarque;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JLabel lblMarque;
private JLabel immat;

	public AjouterVehicule() {
		cnx=Singleton.ObtenirConnectionDB();
		
		VehiculeServiceImpl vs=new VehiculeServiceImpl();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		setBackground(Color.BLUE);
		setVisible(true);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("      --- Ajouter un vehicule ---");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(281, 0, 289, 35);
		add(lblNewLabel);
		
		JPanel infogenero = new JPanel();
		infogenero.setBounds(12, 46, 509, 303);
		add(infogenero);
		infogenero.setLayout(null);
		infogenero.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations G\u00E9n\u00E9rales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		
		JLabel label = new JLabel("Matricule :");
		label.setBounds(10, 60, 59, 14);
		infogenero.add(label);
		
		txt_mat = new JTextField();
		txt_mat.setColumns(16);
		txt_mat.setBounds(128, 57, 120, 20);
		infogenero.add(txt_mat);
		
		JLabel label_1 = new JLabel("Nombre de portières :");
		label_1.setBounds(268, 57, 130, 14);
		infogenero.add(label_1);
		
		porte = new JTextField();
		porte.setColumns(10);
		porte.setBounds(437, 57, 59, 20);
		infogenero.add(porte);
		
		JLabel label_2 = new JLabel("Puissance : ");
		label_2.setBounds(10, 96, 82, 14);
		infogenero.add(label_2);
		
		txt_puissance = new JTextField();
		txt_puissance.setColumns(10);
		txt_puissance.setBounds(128, 93, 120, 20);
		infogenero.add(txt_puissance);
		
		JLabel label_3 = new JLabel("Nombre de places :");
		label_3.setBounds(268, 82, 130, 14);
		infogenero.add(label_3);
		
		place = new JTextField();
		place.setColumns(10);
		place.setBounds(437, 88, 59, 20);
		infogenero.add(place);
		
		JLabel label_4 = new JLabel("N* Carte grise :");
		label_4.setBounds(10, 124, 94, 14);
		infogenero.add(label_4);
		
		txt_cgrise = new JTextField();
		txt_cgrise.setColumns(10);
		txt_cgrise.setBounds(128, 121, 120, 20);
		infogenero.add(txt_cgrise);
		
		JLabel label_5 = new JLabel("Path photo :");
		label_5.setBounds(268, 124, 82, 14);
		infogenero.add(label_5);
		
		JLabel label_6 = new JLabel("Date d'acquisition :");
		label_6.setBounds(10, 152, 108, 14);
		infogenero.add(label_6);
		
		JLabel label_7 = new JLabel("Service :");
		label_7.setBounds(10, 177, 68, 14);
		infogenero.add(label_7);
		
		 cb_service = new JComboBox();
		cb_service.setModel(new DefaultComboBoxModel(new String[] {"RH", "Comptabilité", "Financier", "Moyens généraux"}));
		cb_service.setBounds(128, 179, 120, 20);
		infogenero.add(cb_service);
		
		JLabel label_8 = new JLabel("Modèle :");
		label_8.setBounds(10, 213, 59, 14);
		infogenero.add(label_8);
		
		txt_mod = new JTextField();
		txt_mod.setColumns(10);
		txt_mod.setBounds(128, 210, 120, 20);
		infogenero.add(txt_mod);
		
		JLabel label_9 = new JLabel("Catégorie :");
		label_9.setBounds(268, 152, 76, 14);
		infogenero.add(label_9);
		
		JLabel label_10 = new JLabel("Statut :");
		label_10.setBounds(268, 177, 59, 14);
		infogenero.add(label_10);
		
		cb_statut = new JComboBox();
		cb_statut.setModel(new DefaultComboBoxModel(new String[] {"Service", "Fonction", "Vendu", "En commande"}));
		cb_statut.setBounds(386, 174, 110, 20);
		infogenero.add(cb_statut);
		
		JLabel label_11 = new JLabel("Type Carburan :");
		label_11.setBounds(268, 210, 94, 14);
		infogenero.add(label_11);
		
		txt_carb = new JTextField();
		txt_carb.setColumns(10);
		txt_carb.setBounds(392, 207, 110, 20);
		infogenero.add(txt_carb);
		
		JLabel label_12 = new JLabel("Site géographique :");
		label_12.setBounds(268, 245, 110, 14);
		infogenero.add(label_12);
		
		 cb_site = new JComboBox();
		cb_site.setModel(new DefaultComboBoxModel(new String[] {"Siège", "Services généraux"}));
		cb_site.setBounds(392, 242, 110, 20);
		infogenero.add(cb_site);
		SiteServiceImpl st =new SiteServiceImpl();
        st.remplirComboSite();
		
		DateChooserCombo dateAcqui = new DateChooserCombo();
		dateAcqui .setBounds(128, 152, 120, 20);
		infogenero.add(dateAcqui );
		
		cb_cat = new JComboBox();
		cb_cat.setModel(new DefaultComboBoxModel(new String[] {"Minibus", "Camion", "Personnelle"}));
		cb_cat.setBounds(386, 146, 110, 20);
		infogenero.add(cb_cat);
		
		txtmarque = new JTextField();
		txtmarque.setColumns(10);
		txtmarque.setBounds(128, 242, 120, 20);
		infogenero.add(txtmarque);
		
		JPanel infoassur = new JPanel();
		infoassur.setBounds(531, 46, 341, 303);
		add(infoassur);
		infoassur.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations Sur l'assurance", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		infoassur.setLayout(null);
		
		JLabel lblMatricule = new JLabel("Date debut d'assurance :");
		lblMatricule.setBounds(10, 60, 156, 14);
		infoassur.add(lblMatricule);
		
		JLabel lblNewLabel_1 = new JLabel("Date de fin d'assurance : ");
		lblNewLabel_1.setBounds(10, 130, 156, 14);
		infoassur.add(lblNewLabel_1);
		
		JLabel lblNCarteGrise = new JLabel("Cout d'assurance :");
		lblNCarteGrise.setBounds(10, 193, 119, 14);
		infoassur.add(lblNCarteGrise);
		
		coutassur = new JTextField();
		coutassur.setBounds(194, 190, 134, 20);
		infoassur.add(coutassur);
		coutassur.setColumns(10);
		
		JLabel lblService = new JLabel("Assureur :");
		lblService.setBounds(10, 248, 63, 14);
		infoassur.add(lblService);
		
		 cb_assureur = new JComboBox();
		cb_assureur.setModel(new DefaultComboBoxModel(new String[] {""}));
		cb_assureur.setBounds(192, 245, 136, 20);
		infoassur.add(cb_assureur);
		FournisseurServiceImpl f=new FournisseurServiceImpl();
		f.remplirComboAssureur(cb_assureur);
		
		DateChooserCombo datedebutassur = new DateChooserCombo();
		datedebutassur.setBounds(209, 60, 119, 20);
		infoassur.add(datedebutassur);
		
		DateChooserCombo datefinassur = new DateChooserCombo();
		datefinassur .setBounds(209, 124, 119, 20);
		infoassur.add(datefinassur );
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(200, 360, 527, 188);
		add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations Sur le contrat de r\u00E9paration", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		
		JLabel lblDateDeuDbut = new JLabel("Date deu début du contrat :");
		lblDateDeuDbut.setBounds(35, 54, 171, 14);
		panel_2.add(lblDateDeuDbut);
		
		JLabel lblDateDeFin = new JLabel("Date de fin de contrat : ");
		lblDateDeFin.setBounds(35, 96, 140, 14);
		panel_2.add(lblDateDeFin);
		
		JLabel lblCoutDuContrat = new JLabel("Cout du contrat :");
		lblCoutDuContrat.setBounds(35, 124, 125, 14);
		panel_2.add(lblCoutDuContrat);
		
		txt_coutcontra = new JTextField();
		txt_coutcontra.setColumns(10);
		txt_coutcontra.setBounds(308, 121, 75, 20);
		panel_2.add(txt_coutcontra);
		
		JLabel lblAtelierDeRparation = new JLabel("Atelier de réparation :");
		lblAtelierDeRparation.setBounds(35, 155, 140, 14);
		panel_2.add(lblAtelierDeRparation);
		
		DateChooserCombo dateDebutContra = new DateChooserCombo();
		dateDebutContra.setBounds(308, 54, 155, 20);
		panel_2.add(dateDebutContra);
		
		DateChooserCombo dateFinContra = new DateChooserCombo();
		dateFinContra.setBounds(308, 96, 155, 20);
		panel_2.add(dateFinContra);
		
		txt_repar = new JTextField();
		txt_repar.setColumns(10);
		txt_repar.setBounds(307, 152, 156, 20);
		panel_2.add(txt_repar);
		
		
		lblMarque = new JLabel("Marque :");
		lblMarque.setBounds(14, 245, 64, 14);
		infogenero.add(lblMarque);
		
		 immat = new JLabel("Immatriculation :");
		immat.setBounds(10, 277, 102, 14);
		infogenero.add(immat);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(128, 274, 120, 20);
		infogenero.add(textField);
		
		Choice choice = new Choice();
		choice.setBounds(417, 118, 82, 20);
		infogenero.add(choice);
		
		JButton btnSave = new JButton("Save ");
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String[]data={txt_mat.getText(),txt_puissance.getText(),txt_cgrise.getText(),txt_mod.getText(),txt_repar.getText()};
			if(Not_empty(data)==true)
			{
				//--------------------------RECUPERATION DES ELEMENTS DU FORMULAIRE---------------------------------
				String immat=txt_mat.getText();
				String puissance=txt_puissance.getText();
				String cartegrise=txt_cgrise.getText();
			    String service=cb_service.getSelectedItem().toString();
			    String dateAquisition = formatter.format(dateAcqui.getSelectedDate().getTime()); 
				String model=txt_mod.getText();
			   String site=cb_site.getSelectedItem().toString();
		       int portiere =Integer.parseInt(porte.getText());
				int places=Integer.parseInt(place.getText());
				String categorie=cb_cat.getSelectedItem().toString();
				String satut=cb_statut.getSelectedItem().toString();
				String datedebutreparation=formatter.format(dateDebutContra.getSelectedDate().getTime());
				String datefinreparation=formatter.format(dateFinContra.getSelectedDate().getTime());
			   float coutassurance=Float.parseFloat(coutassur.getText());
				float coutderepar = Float.parseFloat(txt_coutcontra.getText());
				String atelierderep = txt_repar.getText();
				String marque=txtmarque.getText();
				String foto=choice.getSelectedItem();
				String finassur =formatter.format(datefinassur.getSelectedDate().getTime());
				String debutassur =formatter.format(datedebutassur.getSelectedDate().getTime());
		
			
		//--------------------------------AFFICHAGE DES ELEMENTS DU FORMULAIRES-----------------------------		
//				System.out.println("------------------------------essaie d'affichage----------------------------");
//				System.out.println(immat);
//				System.out.println(puissance);
//				System.out.println(service);
//				System.out.println( dateAquisition);
//				System.out.println(marque);
//				System.out.println(model);
//				System.out.println(site);
//				System.out.println();
//				System.out.println(portiere);
//				System.out.println(places);
//				System.out.println(categorie);
//				System.out.println();
//				System.out.println(satut);
//				System.out.println(datedebutreparation);
//				System.out.println(datefinreparation);
//				System.out.println(coutassurance);
//				System.out.println(coutderepar);
//				System.out.println(foto);
//				System.out.println(debutassur);
//				System.out.println(finassur );
//				System.out.println("---------------------fin d'affichage---------------------------------");
//				
				//----------------------Creation  d'un vehicule------------------------
				Vehicule Ve = new Vehicule(portiere, puissance, model, places, marque, cartegrise, immat, foto, dateAquisition, debutassur, finassur, coutassurance, datedebutreparation, datefinreparation, coutderepar);
			    vs.AjouterVehicule(Ve);
			    
			    
	//-------------------------initialisation des champs---------------------------------------		    
			    txt_mat.setText(" ");
			    txt_puissance.setText(" ");
			    txt_cgrise.setText(" ");
			    cb_service.setDropTarget(null);
			    dateAcqui.setText("" );
			    txt_mod.setText(" ");
			    cb_site.setDropTarget(null);
			    cb_statut.setDropTarget(null);
			    dateDebutContra.setText(" ");
			    dateFinContra.setText(" ");
			    coutassur.setText(" ");
			    txt_coutcontra.setText(" ");
			    txt_repar.setText(" ");
			    txtmarque.setText(" ");
		
			}

			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSave.setBounds(244, 575, 136, 35);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				disable();
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCancel.setBounds(562, 575, 136, 35);
		add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 622, 913, 17);
		add(panel);
		
	
	}
	public boolean Not_empty(String[]data)
	{
		boolean rep=false;
		if(data.length !=0)
		{
			for(String field : data)
			{
				if(field.isEmpty())
				{
                   JOptionPane.showMessageDialog(null,"Desolé tous les champs du formulaire ne sont pas renseignés", "validation", JOptionPane.YES_NO_OPTION);
					rep= false;
				}
				
			}
			rep=true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Le formulaire set vide");
			rep= false;
		}
		return rep;
	}
}
