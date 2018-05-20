package com.cgipag.ui;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.InternalFrameAdapter;

import com.cgipa.service.Impl.UtilisateursServiceImpl;
import com.cgipa.service.Impl.VehiculeServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.border.TitledBorder;
import datechooser.beans.DateChooserCombo;


public class Vehicule extends JFrame {
	
	

	private static JPanel contentPane;
	protected Container panaffichage;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JComboBox cb_utilisateur;
	private JComboBox cb_matricule;
	private JComboBox cb_typevehicule;
	private int ni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Vehicule frame = new Vehicule();
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
	public Vehicule() {
		VehiculeServiceImpl vh= new VehiculeServiceImpl();
		ProfileUtil p= new ProfileUtil ();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326, 895);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panhaut = new JPanel();
		panhaut.setBounds(20, 0, 1284, 156);
		contentPane.add(panhaut);
		panhaut.setLayout(null);
		
		JLabel lblogo = new JLabel("");
		lblogo.setBounds(0, 0, 300, 156);
		panhaut.add(lblogo);
		lblogo.setIcon(new ImageIcon(Vehicule.class.getResource("/com/cgipag/ui/img/logo.png")));
		
		JLabel lblGestionDesVehicules = new JLabel("Gestion des vehicules");
		lblGestionDesVehicules.setBounds(546, 11, 418, 53);
		lblGestionDesVehicules.setFont(new Font("Times New Roman", Font.BOLD, 41));
		panhaut.add(lblGestionDesVehicules);
		
		JPanel panmenu = new JPanel();
		panmenu.setBounds(357, 73, 774, 55);
		panhaut.add(panmenu);
		panmenu.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(40, 0, 769, 54);
		panmenu.add(menuBar);
		
		JMenu mnListeDes = new JMenu("               -- Liste des vehicules --                     ");
		menuBar.add(mnListeDes);
		
		AfficheCamion afc= new AfficheCamion();
		 afc.setLayout(null);
		 afc.setBounds(375, 197, 894, 648);
           contentPane.add( afc);
           afc.setVisible(false);
           
		JMenuItem mntmCamions = new JMenuItem("Camions");
		mntmCamions.setPreferredSize(new Dimension(232, 22));
		mntmCamions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AjouterVehicule ajouv=new AjouterVehicule();
				JPanel panAffec = new JPanel();
				panAffec.hide();
				ajouv.hide();
				afc.setVisible(true);
			}
		});
		mnListeDes.add(mntmCamions);
		
		JMenuItem mntmFourgonnettes = new JMenuItem("Fourgonnettes");
		mnListeDes.add(mntmFourgonnettes);
		
		JMenuItem mntmMinibus = new JMenuItem("Minibus");
		mnListeDes.add(mntmMinibus);
		
		JMenuItem mntmVoitures = new JMenuItem("Voitures");
		mnListeDes.add(mntmVoitures);
		JMenu mnAjouterUn = new JMenu("                      -- Ajouter un véhicule --                         ");
							
							// creation du formulaire de saisie d'ajout d'un vehicule	
							AjouterVehicule ajouv=new AjouterVehicule();
					    ajouv.setLayout(null);
					    ajouv.setBounds(375, 197, 894, 632);
		                contentPane.add(ajouv);
		                ajouv.setVisible(false);
		                
		                		// creation du formulaire de saisie de l'affection du vehicule a un  utilisateur
		                					JPanel panAffec = new JPanel();
		                					panAffec.setLayout(null);
		                					panAffec.setBounds(375, 197, 894, 632);
//		                					ajouv.add(panAffec);
		                					contentPane.add(panAffec);
		                					panAffec.setVisible(false);
		                					
	
		                					JPanel pan = new JPanel();
		                					pan.setBackground(Color.BLUE);
		                					pan.setBounds(712, 337, 166, 252);
		                					panAffec.add(pan);
		                					//		panAjout.add(label_23);
		                							
		                							JLabel Aff = new JLabel("      ------    Affecter un vehicule à un utilisateur  --------");
		                							Aff.setFont(new Font("Times New Roman", Font.BOLD, 22));
		                							Aff.setBounds(139, 11, 537, 35);
		                							//		panAjout.add(label_23).disable();
		                									panAffec.add(Aff);
		                									
		                									JPanel panel_22 = new JPanel();
		                									panel_22.setBackground(Color.BLUE);
		                									panel_22.setBounds(876, 0, 30, 590);
		                									panAffec.add(panel_22);
		                									
		                									JPanel panel_23 = new JPanel();
		                									panel_23.setBackground(Color.BLUE);
		                									panel_23.setBounds(-19, 572, 925, 68);
		                									panAffec.add(panel_23);
		                									
		                									JPanel panel_25 = new JPanel();
		                									panel_25.setBackground(Color.BLUE);
		                									panel_25.setBounds(0, 337, 737, 252);
		                									panAffec.add(panel_25);
		                									
		                									JButton btnAffected = new JButton("Affected");
		                									btnAffected.setFont(new Font("Tahoma", Font.BOLD, 25));
		                									btnAffected.addActionListener(new ActionListener() {
																
																@Override
																public void actionPerformed(ActionEvent e) {
																	UtilisateursServiceImpl util= new UtilisateursServiceImpl();
																	String mat=cb_matricule.getSelectedItem().toString();
																	String typevehicule =  cb_typevehicule.getSelectedItem().toString();
																	String utilisateur= cb_utilisateur.getSelectedItem().toString();
																	VehiculeServiceImpl veh= new VehiculeServiceImpl();
																	try {
																		veh.affectationVehicule(typevehicule, utilisateur);
																	} catch (SQLException e1) {
																		// TODO Auto-generated catch block
																		e1.printStackTrace();
																	}
																}
															});
		                									btnAffected.setBounds(334, 283, 182, 43);
		                									panAffec.add(btnAffected);
		                									
		                									JPanel panel_27 = new JPanel();
		                									panel_27.setBackground(Color.BLUE);
		                									panel_27.setBounds(0, 44, 878, 18);
		                									panAffec.add(panel_27);
		                									
		                									JLabel lblUtilisateur = new JLabel("Utilisateur :");
		                									lblUtilisateur.setFont(new Font("Times New Roman", Font.BOLD, 17));
		                									lblUtilisateur.setBounds(256, 124, 109, 27);
		                									panAffec.add(lblUtilisateur);
		                									
		                									JLabel lblMatriculeDuVhicule = new JLabel("Matricule du véhicule :");
		                									lblMatriculeDuVhicule.setFont(new Font("Times New Roman", Font.BOLD, 17));
		                									lblMatriculeDuVhicule.setBounds(256, 212, 182, 27);
		                									panAffec.add(lblMatriculeDuVhicule);
		                									
		                								  cb_utilisateur = new JComboBox();
		                									cb_utilisateur.setBounds(478, 126, 152, 25);
		                									panAffec.add(cb_utilisateur);
		                									vh.remplirComboUtilisateur(cb_utilisateur);
		                									
		                									
//	                									JComboBox cb_typevehicule = new JComboBox();
//		                									cb_typevehicule.setBounds(478, 215, 152, 25);
//	                									panAffec.add(cb_typevehicule);
//		                									
//
		                									 cb_matricule = new JComboBox();
		                									cb_matricule.setBounds(478, 215, 152, 25);
		                									panAffec.add(cb_matricule);
		                									vh.remplirComboMatriculeVehicule(cb_matricule);
		                									
		                									cb_typevehicule = new JComboBox();
		                									cb_typevehicule.setBounds(478, 168, 152, 25);
		                									panAffec.add(cb_typevehicule);
		                									vh.remplirComboTypevehicule(cb_typevehicule  );
		                									
		                									JLabel lblTypeDeVhicule = new JLabel("Type de Véhicule :");
		                									lblTypeDeVhicule.setFont(new Font("Times New Roman", Font.BOLD, 17));
		                									lblTypeDeVhicule.setBounds(256, 162, 166, 27);
		                									panAffec.add(lblTypeDeVhicule);
						ajouv.setVisible(false);	
		
		menuBar.add(mnAjouterUn);
		JMenuItem mntmAjouter = new JMenuItem("Ajouter");
		mntmAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				AjouterVehicule ajouv=new AjouterVehicule();
//				JPanel panAffec = new JPanel();
				panAffec.hide();
				afc.hide();
				ajouv.setVisible(true);
			}
		});
		mntmAjouter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmAjouter.setPreferredSize(new Dimension(275, 22));
		mnAjouterUn.add(mntmAjouter);

			
		
		JMenu mnAffecter = new JMenu("              -- Affecter à un utilisateur ---             ");
		menuBar.add(mnAffecter);
		JMenuItem mntmAffect = new JMenuItem("            Affecté");
		mntmAffect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afc.hide();
				ajouv.hide();
				panAffec.setVisible(true);
			}
		});
		mntmAffect.setPreferredSize(new Dimension(209, 22));
		mnAffecter.add(mntmAffect);
		JPanel separateur_2 = new JPanel();
		separateur_2.setBounds(0, 160, 1318, 37);
		separateur_2.setBackground(Color.BLUE);
		contentPane.add(separateur_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 17, 845);
		panel_2.setBackground(Color.BLUE);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1253, 164, 65, 731);
		panel_3.setBackground(Color.BLUE);
		contentPane.add(panel_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 181, 279, 556);
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		
		JLabel label = new JLabel("     " + Connexion.username);
		label.setFont(new Font("Vijaya", Font.BOLD, 17));
		label.setBounds(22, 11, 235, 26);
		panel.add(label);
		
		JButton button = new JButton("VEHICULES");
		
		button.setBounds(0, 104, 279, 47);
		panel.add(button);
		
		JButton utilisateurs = new JButton("UTILISATEURS");
		utilisateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Utilisateurs u = new Utilisateurs();
				u.setVisible(true);
			}
		});
		utilisateurs.setBounds(0, 162, 279, 47);
		panel.add(utilisateurs);
		
		JButton fournisseurs = new JButton("FOURNISSEURS");
		 fournisseurs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Fournisseurs f = new Fournisseurs();
				f.setVisible(true);
			}
		});
		
		fournisseurs.setBounds(0, 220, 279, 47);
		panel.add(fournisseurs);
		
		JButton contrats = new JButton("CONTRATS");
		contrats.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Contrats c = new Contrats();
				c.setVisible(true);
				
			}
		});
		contrats.setBounds(0, 278, 279, 47);
		panel.add(contrats);
		
		JButton sinistres = new JButton("SINISTRES");
		sinistres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sinistres s = new Sinistres();
				s.setVisible(true);
				
			}
		});
		sinistres.setBounds(0, 337, 279, 47);
		panel.add(sinistres);
		
		JButton reservations = new JButton("RESERVATION");
		reservations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reservation r = new Reservation();
				r.setVisible(true);
				
			}
		});
		reservations.setBounds(0, 395, 279, 47);
		panel.add(reservations);
		
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
			panel.add(btnAdministration);
		}
		
		JButton btnProfile = new JButton("PROFILE");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				p.setVisible(true);
			}
		});
		btnProfile.setBounds(0, 453, 279, 47);
		panel.add(btnProfile);
		
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
		deco.setBounds(0, 509, 279, 47);
		panel.add(deco);
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations G\u00E9n\u00E9rales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setBounds(0, 57, 537, 244);
//		panAjout.add(panel_7);
		
		JLabel label_1 = new JLabel("Matricule :");
		label_1.setBounds(10, 32, 50, 14);
		panel_7.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(16);
		textField.setBounds(92, 29, 156, 20);
		panel_7.add(textField);
		
		JLabel label_2 = new JLabel("Nombre de portières :");
		label_2.setBounds(268, 29, 110, 14);
		panel_7.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(433, 29, 59, 20);
		panel_7.add(textField_1);
		
		JLabel label_3 = new JLabel("Puissance : ");
		label_3.setBounds(10, 63, 68, 14);
		panel_7.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(92, 60, 156, 20);
		panel_7.add(textField_2);
		
		JLabel label_4 = new JLabel("Nombre de places :");
		label_4.setBounds(268, 65, 110, 14);
		panel_7.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(433, 60, 59, 20);
		panel_7.add(textField_3);
		
		JLabel label_5 = new JLabel("N* Carte grise :");
		label_5.setBounds(10, 91, 82, 14);
		panel_7.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(92, 88, 156, 20);
		panel_7.add(textField_4);
		
		JLabel label_6 = new JLabel("Path photo :");
		label_6.setBounds(268, 90, 82, 14);
		panel_7.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(406, 91, 86, 20);
		panel_7.add(textField_5);
		
		JLabel label_7 = new JLabel("Date d'acquisition :");
		label_7.setBounds(10, 116, 110, 14);
		panel_7.add(label_7);
		
		JLabel label_8 = new JLabel("Service :");
		label_8.setBounds(10, 149, 46, 14);
		panel_7.add(label_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ressources Humaines", "Juridique", "Financier", "Comptable"}));
		comboBox.setBounds(92, 151, 156, 20);
		panel_7.add(comboBox);
		
		JLabel label_9 = new JLabel("Modèle :");
		label_9.setBounds(10, 185, 46, 14);
		panel_7.add(label_9);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(92, 182, 156, 20);
		panel_7.add(textField_6);
		
		JLabel label_10 = new JLabel("Catégorie :");
		label_10.setBounds(281, 149, 59, 14);
		panel_7.add(label_10);
		
		JLabel label_11 = new JLabel("Statut :");
		label_11.setBounds(281, 185, 46, 14);
		panel_7.add(label_11);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"En service", "Vendu", "En commande"}));
		comboBox_1.setBounds(376, 182, 140, 20);
		panel_7.add(comboBox_1);
		
		JLabel label_12 = new JLabel("Type Carburan :");
		label_12.setBounds(268, 217, 86, 14);
		panel_7.add(label_12);
		
		JLabel label_13 = new JLabel("Site géographique :");
		label_13.setBounds(10, 216, 94, 14);
		panel_7.add(label_13);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(114, 213, 134, 20);
		panel_7.add(comboBox_2);
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo();
		dateChooserCombo.setBounds(113, 118, 155, 20);
		panel_7.add(dateChooserCombo);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"MiniBus", "Fourgonnette", "Camion", "Voiture"}));
		comboBox_3.setBounds(376, 146, 140, 20);
		panel_7.add(comboBox_3);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Super", "Gazoil", "Diesel"}));
		comboBox_6.setBounds(376, 213, 140, 20);
		panel_7.add(comboBox_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations Sur l'assurance", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_8.setBounds(547, 57, 331, 244);
//		panAjout.add(panel_8);
		
		JLabel label_14 = new JLabel("Date debut d'assurance :");
		label_14.setBounds(12, 50, 164, 14);
		panel_8.add(label_14);
		
		JLabel label_15 = new JLabel("Date de fin d'assurance : ");
		label_15.setBounds(10, 98, 134, 14);
		panel_8.add(label_15);
		
		JLabel label_16 = new JLabel("Cout d'assurance :");
		label_16.setBounds(10, 139, 119, 14);
		panel_8.add(label_16);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(143, 136, 148, 20);
		panel_8.add(textField_8);
		
		JLabel label_17 = new JLabel("Assureur :");
		label_17.setBounds(10, 195, 63, 14);
		panel_8.add(label_17);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"NSIA", "SUMU Assurance", "ATLANTIC Assurance", "AXA assurance", "SERENITY"}));
		comboBox_4.setBounds(111, 189, 180, 20);
		panel_8.add(comboBox_4);
		
		JLabel label_18 = new JLabel("Site géographique :");
		label_18.setBounds(10, 297, 94, 14);
		panel_8.add(label_18);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(114, 294, 134, 20);
		panel_8.add(comboBox_5);
		
		DateChooserCombo dateChooserCombo_1 = new DateChooserCombo();
		dateChooserCombo_1.setBounds(136, 50, 155, 20);
		panel_8.add(dateChooserCombo_1);
		
		DateChooserCombo dateChooserCombo_2 = new DateChooserCombo();
		dateChooserCombo_2.setBounds(134, 92, 155, 20);
		panel_8.add(dateChooserCombo_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations Sur le contrat de r\u00E9paration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_9.setBounds(176, 313, 527, 194);
//		panAjout.add(panel_9);
		
		JLabel label_19 = new JLabel("Date deu début du contrat :");
		label_19.setBounds(10, 60, 140, 14);
		panel_9.add(label_19);
		
		JLabel label_20 = new JLabel("Date de fin de contrat : ");
		label_20.setBounds(10, 96, 140, 14);
		panel_9.add(label_20);
		
		JLabel label_21 = new JLabel("Cout du contrat :");
		label_21.setBounds(10, 124, 125, 14);
		panel_9.add(label_21);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(193, 119, 75, 20);
		panel_9.add(textField_9);
		
		JLabel label_22 = new JLabel("Atelier de réparation :");
		label_22.setBounds(10, 152, 110, 14);
		panel_9.add(label_22);
		
		DateChooserCombo dateChooserCombo_3 = new DateChooserCombo();
		dateChooserCombo_3.setBounds(193, 57, 155, 20);
		panel_9.add(dateChooserCombo_3);
		
		DateChooserCombo dateChooserCombo_4 = new DateChooserCombo();
		dateChooserCombo_4.setBounds(193, 88, 155, 20);
		panel_9.add(dateChooserCombo_4);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(192, 150, 156, 20);
		panel_9.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(193, 150, 156, 20);
		panel_9.add(textField_11);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.BLUE);
		panel_10.setBounds(0, 295, 921, 18);
//		panAjout.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.BLUE);
		panel_11.setBounds(876, -16, 73, 645);
//		panAjout.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.BLUE);
		panel_12.setBounds(-70, 572, 963, 57);
//		panAjout.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.BLUE);
		panel_13.setBounds(536, 57, 10, 244);
//		panAjout.add(panel_13);
	
		// le titre du formulaire pour ajouter un vehicule
		JLabel label_23 = new JLabel("      --- Ajouter un vehicule ---");
		label_23.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label_23.setBounds(315, 0, 289, 35);
		
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.BLUE);
		panel_14.setBounds(0, 312, 166, 277);
//		panAjout.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.BLUE);
		panel_15.setBounds(712, 312, 166, 277);
//		panAjout.add(panel_15);
		
		JButton button_8 = new JButton("Save ");
		button_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_8.setBounds(198, 518, 182, 43);
//		panAjout.add(button_8);
		
		JButton button_9 = new JButton("Cancel");
		button_9.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_9.setBounds(496, 518, 182, 43);
//		panAjout.add(button_9);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.BLUE);
		panel_16.setBounds(0, 44, 878, 18);
//		panAjout.add(panel_16);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(303, 167, 17, 678);
		panel_5.setBackground(Color.BLUE);
		contentPane.add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 831, 1318, 37);
		panel_4.setBackground(Color.BLUE);
		contentPane.add(panel_4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(330, 819, 974, -611);
		contentPane.add(tabbedPane);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.BLUE);
		panel_17.setBounds(317, 181, 65, 664);
		contentPane.add(panel_17);
	}
}
