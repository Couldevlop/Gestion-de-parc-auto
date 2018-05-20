package com.cgipag.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Sinistre;
import com.cgipa.service.Impl.SinistreServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import datechooser.beans.DateChooserCombo;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class Sinistres extends JFrame  implements Serializable{

	private JPanel contentPane;
	private JTable table;
	private JTextField txtli;
	private JTextField txtde;
	private int dece=0;
	private JComboBox cb_respo;
	private JComboBox cb_mat;
	private int ni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sinistres frame = new Sinistres();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sinistres() {
		Connection cnx=Singleton.ObtenirConnectionDB();
		AjouterVehicule aj= new AjouterVehicule();
		ProfileUtil p= new ProfileUtil ();
		SimpleDateFormat formater= new SimpleDateFormat("dd-mm-yyyy");
		SinistreServiceImpl si=new SinistreServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1341, 814);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(21, -4, 1279, 156);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Sinistres.class.getResource("/com/cgipag/ui/img/logo.png")));
		label.setBounds(10, 0, 300, 156);
		panel.add(label);
		
		JLabel lblGestionDesSinistres = new JLabel("Gestion des Sinistres");
		lblGestionDesSinistres.setFont(new Font("Times New Roman", Font.BOLD, 41));
		lblGestionDesSinistres.setBounds(653, 31, 418, 53);
		panel.add(lblGestionDesSinistres);
		
		JButton ListerFournisseur = new JButton("--- Lister des sinistres ---");
		ListerFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remplitableau();
			}
			
		});
		ListerFournisseur.setBounds(617, 111, 169, 34);
		panel.add(ListerFournisseur);
		
		JPanel panAjoutSinistre = new JPanel();
		panAjoutSinistre.setVisible(false);
		
		JButton ajoutSinistre = new JButton("--- Ajouter un sinistre ---");
		ajoutSinistre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panAjoutSinistre.setVisible(true);
			}
		});
		ajoutSinistre.setBounds(857, 111, 169, 34);
		panel.add(ajoutSinistre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(-24, -183, 22, 932);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(-38, 152, 1353, 16);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(310, 173, 990, 548);
		contentPane.add(panel_3);
		
		JButton button = new JButton("Exporter en PDF");
		button.setBounds(4, 211, 129, 39);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.setLayout(null);
		panel_3.add(button);
		
		JButton button_1 = new JButton("Exporter en Xls");
		button_1.setBounds(4, 138, 129, 42);
		panel_3.add(button_1);
		
		JButton button_2 = new JButton("Imprimer");
		button_2.setBounds(4, 67, 129, 42);
		panel_3.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(133, 67, 847, 183);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", "", "", "", "", ""},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Responsable", "Matricule du vehicule", "Lieu", "Date", "D\u00E9gats materiels", "D\u00E9gats corporels", "nombre de d\u00E9c\u00E8s", "Modification", "Suppression"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(72);
		table.getColumnModel().getColumn(0).setMinWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(113);
		table.getColumnModel().getColumn(1).setMinWidth(33);
		table.getColumnModel().getColumn(1).setMaxWidth(113);
		table.getColumnModel().getColumn(2).setPreferredWidth(63);
		table.getColumnModel().getColumn(3).setPreferredWidth(61);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		scrollPane.setViewportView(table);
		
		JLabel lblListeDesSinistres = new JLabel("Liste des sinistres");
		lblListeDesSinistres.setBounds(459, 30, 158, 22);
		lblListeDesSinistres.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_3.add(lblListeDesSinistres);
		
	
		panAjoutSinistre.setBounds(4, 278, 976, 281);
		panel_3.add(panAjoutSinistre);
		panAjoutSinistre.setLayout(null);
		panAjoutSinistre.setVisible(false);
		
		
		JLabel lblNewLabel = new JLabel("--Ajout d'un Sinistre--");
		lblNewLabel.setBounds(395, 5, 199, 22);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panAjoutSinistre.add(lblNewLabel);
		
		JLabel lblNomDuResponsable = new JLabel("Nom du Responsable :");
		lblNomDuResponsable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomDuResponsable.setBounds(81, 60, 147, 14);
		panAjoutSinistre.add(lblNomDuResponsable);
		
		JLabel lblMatriculeVhicule = new JLabel("Matricule Véhicule :");
		lblMatriculeVhicule.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatriculeVhicule.setBounds(81, 85, 147, 14);
		panAjoutSinistre.add(lblMatriculeVhicule);
		
		JLabel lblLieu = new JLabel("Lieu :");
		lblLieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLieu.setBounds(81, 110, 147, 14);
		panAjoutSinistre.add(lblLieu);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(81, 151, 147, 14);
		panAjoutSinistre.add(lblDate);
		
		cb_respo = new JComboBox();
		si.remplirComboRespoSinistre(cb_respo);
		cb_respo.setBounds(296, 59, 160, 20);
		panAjoutSinistre.add(cb_respo);
		
		 cb_mat = new JComboBox();
		si.remplirComboMatriculeVheiculeSinistre(cb_mat);
		cb_mat.setBounds(296, 91, 160, 20);
		panAjoutSinistre.add(cb_mat);
		
		txtli = new JTextField();
		txtli.setBounds(296, 116, 160, 20);
		panAjoutSinistre.add(txtli);
		txtli.setColumns(10);
		
		DateChooserCombo dateSin = new DateChooserCombo();
		dateSin.setBounds(301, 145, 155, 20);
		panAjoutSinistre.add(dateSin);
		
		JLabel lblDegatsMateriels = new JLabel("Degats Materiels :");
		lblDegatsMateriels.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDegatsMateriels.setBounds(507, 62, 147, 14);
		panAjoutSinistre.add(lblDegatsMateriels);
		
		JTextArea txtareadegatmat = new JTextArea();
		txtareadegatmat.setBounds(627, 44, 237, 81);
		panAjoutSinistre.add(txtareadegatmat);
		
		JLabel lblDegatsCorporels = new JLabel("Degats Corporels :");
		lblDegatsCorporels.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDegatsCorporels.setBounds(494, 139, 147, 14);
		panAjoutSinistre.add(lblDegatsCorporels);
		
		JTextArea txtareadegacor = new JTextArea();
		txtareadegacor.setBounds(627, 136, 243, 81);
		panAjoutSinistre.add(txtareadegacor);
		
		JButton btval = new JButton("Valider");
		btval.addActionListener(new ActionListener() {
			
			private int deces;

			public String RecupererSelection(String s)
			{
				String element = null;
				element=s;
				
				return element;
			}
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] data={dateSin.getText(), txtli.getText(), txtareadegatmat.getText(),txtareadegacor.getText()};
				if(aj.Not_empty(data) == true)
				{
				//  Recuperation de tous les elemnts du formulaire d'ajou
					
					String datesinistre= formater.format(dateSin.getSelectedDate().getTime());
					String lieu=txtli.getText();
					String degatmat=txtareadegatmat.getText();
					String degatcor=txtareadegacor.getText();
					int deces=Integer.parseInt(txtde.getText());
					si.AjouterSinistre(new Sinistre(lieu, datesinistre, degatmat, degatcor, deces));
					
					
					txtli.setText(" ");
					txtareadegatmat.setText(" ");
					txtareadegacor.setText(" ");
					txtde.setText(" ");
					
				}
			}
		});
		btval.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btval.setBounds(170, 236, 89, 34);
		panAjoutSinistre.add(btval);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAnnuler.setBounds(315, 236, 89, 34);
		panAjoutSinistre.add(btnAnnuler);
		
		JLabel lblNombreDeDcs = new JLabel("Nombre de décès :");
		lblNombreDeDcs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDeDcs.setBounds(81, 180, 147, 14);
		panAjoutSinistre.add(lblNombreDeDcs);
		
		txtde = new JTextField();
		txtde.setColumns(10);
		txtde.setBounds(296, 176, 60, 20);
		panAjoutSinistre.add(txtde);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.BLUE);
		panel_9.setForeground(Color.BLUE);
		panel_9.setBounds(-12, 267, 1060, 10);
		panel_3.add(panel_9);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLUE);
		panel_4.setBounds(1303, -106, 22, 882);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLUE);
		panel_5.setBounds(-24, 739, 1493, 37);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(21, 179, 279, 542);
		contentPane.add(panel_6);
		
		JLabel label_2 = new JLabel("     " + Connexion.username);
		label_2.setFont(new Font("Vijaya", Font.BOLD, 17));
		label_2.setBounds(22, 11, 235, 26);
		panel_6.add(label_2);
		
		JButton Vehicules = new JButton("VEHICULES");
		Vehicules.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vehicule v = new Vehicule();
				v.setVisible(true);
				
			}
		});
		Vehicules.setBounds(0, 78, 279, 47);
		panel_6.add(Vehicules);
		
		JButton Utilisateurs = new JButton("UTILISATEURS");
		Utilisateurs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Utilisateurs u = new Utilisateurs();
				u.setVisible(true);
				
			}
		});

		Utilisateurs.setBounds(0, 136, 279, 47);
		panel_6.add(Utilisateurs);
		
		JButton fournisseurs = new JButton("FOURNISSEURS");
		fournisseurs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Fournisseurs f = new Fournisseurs();
				f.setVisible(true);
				
			}
		});
		fournisseurs.setBounds(0, 194, 279, 47);
		panel_6.add(fournisseurs);
		
		JButton contrats = new JButton("CONTRATS");
		contrats.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Contrats c = new Contrats();
				c.setVisible(true);
				
			}
		});
		contrats.setBounds(0, 252, 279, 47);
		panel_6.add(contrats);
		
		JButton sinistres = new JButton("SINISTRES");
//		sinistres.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Sinistres s = new Sinistres();
//				s.setVisible(true);
//				
//			}
//		});
		sinistres.setBounds(0, 311, 279, 47);
		panel_6.add(sinistres);
		
		JButton reservations = new JButton("RESERVATION");
		reservations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reservation r = new Reservation();
				r.setVisible(true);
				
			}
		});
		reservations.setBounds(0, 369, 279, 47);
		panel_6.add(reservations);
		

		ni=Connexion.niveau;
		System.out.println(ni);
		if(ni == 2)
		{
			JButton btnAdministration = new JButton("ADMINISTRATION");
			btnAdministration.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
					Administration admin = new  Administration();
			       admin.setVisible(true);
				}
			
		});
			btnAdministration.setBounds(0, 427, 279, 47);
			panel_6.add(btnAdministration);
		}
		
		JButton btnProfile = new JButton("PROFILE");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				p.setVisible(true);
			}
		});
		btnProfile.setBounds(0, 427, 279, 47);
		panel_6.add(btnProfile);
		
		JButton deco = new JButton("DECONNEXION");
		deco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=JOptionPane.showConfirmDialog(null, "Vous etes sous le point de vous deconnecter, etes-vous sur de le faire?", "Message de Confirmation", JOptionPane.YES_NO_OPTION);
				if(i==0)
				{
					dispose();
					Connexion con = new Connexion();
					con.setVisible(true);
				}
				else if(i==1)
				{
//					Vehicule v = new Vehicule();
//					v.setVisible(true);
				}
				
			}
		});
		deco.setBounds(0, 485, 279, 47);
		panel_6.add(deco);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.BLUE);
		panel_7.setBounds(-14, -107, 30, 883);
		contentPane.add(panel_7);
	}
	
	public String RecupererComboboxcb_respo()
	{
		String recup = null;
		 String   responsable = cb_respo.getSelectedItem().toString();
	     recup=responsable;
		return recup;
	}
	
	
	public String RecupererComboboxcb_mat()
	{
		String recup1 = null;
		  String matricule=cb_mat.getSelectedItem().toString();
	     recup1=matricule;
		return recup1;
	}
	
	public void Remplitableau()
	{
		SinistreServiceImpl si=new SinistreServiceImpl();
		ResultSet rs=si.RemplirTableauSinistre();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
}
