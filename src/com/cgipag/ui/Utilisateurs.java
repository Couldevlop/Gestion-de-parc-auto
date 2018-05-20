package com.cgipag.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.cgipa.DAO.Singleton;
import com.cgipa.service.Impl.UtilisateursServiceImpl;

import net.proteanit.sql.DbUtils;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;

public class Utilisateurs extends JFrame implements Serializable {

	private JPanel contentPane;
	private JTable tableUtilisateur=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txt_fone;
	private JTextField txt_cni;
	private JTextField txt_nom;
	private JTextField txt_prenom;
	private JTextField txtmatricule;
	ResultSet rs = null;
	private JComboBox cb_posi ;
	private Connection cnx=null;
	private JTextField txtnom;
	private JTextField txtprenom;
	private  JComboBox cb_position;
	private Container panRecherche1;
	private int ni;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Utilisateurs frame = new Utilisateurs();
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
	public Utilisateurs() {
		cnx=Singleton.ObtenirConnectionDB();
	UtilisateursServiceImpl util= new UtilisateursServiceImpl();
	ProfileUtil p= new ProfileUtil ();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1343, 814);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(2147483647, 2147483647));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 0, 1285, 156);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Utilisateurs.class.getResource("/com/cgipag/ui/img/logo.png")));
		label.setBounds(0, 0, 300, 156);
		panel.add(label);
		
		JLabel lblGestionDutilisateurs = new JLabel("Gestion d'utilisateurs");
		lblGestionDutilisateurs.setFont(new Font("Times New Roman", Font.BOLD, 41));
		lblGestionDutilisateurs.setBounds(539, 49, 418, 53);
		panel.add(lblGestionDutilisateurs);
		
		JButton btnListerLes = new JButton("--- Lister les utilisateurs ---");
		btnListerLes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemplirTableUtilsateurs();
			}
		});
		btnListerLes.setBounds(380, 113, 180, 34);
		panel.add(btnListerLes);
		JPanel panAjouUt = new JPanel();
		JPanel panAff = new JPanel();
		JPanel panRecherche = new JPanel();
		
		
		JButton AjoutUtil = new JButton("--- Ajouter un utilisateur ---");
		AjoutUtil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  panRecherche.hide();
			  panAff.hide();
				panAjouUt.setVisible(true);
			}
		});
		AjoutUtil.setBounds(570, 113, 189, 34);
		panel.add(AjoutUtil);
		
		
		
		JButton btnRechercherUn = new JButton("--- Rechercher un utilisateur ---");
		btnRechercherUn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panAjouUt.hide();
				panAff.hide();
				panRecherche.setVisible(true);
			}
		});
		btnRechercherUn.setBounds(769, 113, 214, 34);
		panel.add(btnRechercherUn);
		
		JButton btnAffecterUn = new JButton("--- Affecter un Véhicule ---");
		btnAffecterUn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panAjouUt.hide();
				panRecherche.hide();
				panAff.setVisible(true);
			}
		});
		btnAffecterUn.setBounds(993, 113, 189, 34);
		panel.add(btnAffecterUn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(0, 156, 1338, 16);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(0, 0, 16, 786);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLUE);
		panel_4.setBounds(1311, 0, 16, 740);
		contentPane.add(panel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(20, 177, 279, 534);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("            Bonjour COULIBALY    ");
		label_1.setFont(new Font("Vijaya", Font.BOLD, 17));
		label_1.setBounds(22, 11, 235, 26);
		panel_1.add(label_1);
		
		JButton Vehicules = new JButton("VEHICULES");
		Vehicules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Vehicule v = new Vehicule();
				v.setVisible(true);
			}
		});
		Vehicules.setBounds(0, 78, 279, 47);
		panel_1.add(Vehicules);
		
		JButton Utilisateur = new JButton("UTILISATEURS");
//		Utilisateur.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				Utilisateurs u = new Utilisateurs();
//				u.setVisible(true);
//			}
//		});
		
		Utilisateur.setBounds(0, 136, 279, 47);
		panel_1.add(Utilisateur);
		
		JButton fournisseurs = new JButton("FOURNISSEURS");
		fournisseurs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Fournisseurs f= new Fournisseurs();
				f.setVisible(true);
				
			}
		});
		fournisseurs.setBounds(0, 194, 279, 47);
		panel_1.add(fournisseurs);
		
		JButton contrats = new JButton("CONTRATS");
		contrats.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Contrats c = new Contrats();
				c.setVisible(true);
				
			}
		});
		contrats.setBounds(0, 252, 279, 47);
		panel_1.add(contrats);
		
		JButton sinistres = new JButton("SINISTRES");
		sinistres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sinistres s = new Sinistres();
				s.setVisible(true);
				
			}
		});
		sinistres.setBounds(0, 311, 279, 47);
		panel_1.add(sinistres);
		
		JButton reservation = new JButton("RESERVATION");
		reservation.setBounds(0, 369, 279, 47);
		panel_1.add(reservation);
		
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
					ConnexionCourante admin = new  ConnexionCourante();
			       admin.setVisible(true);
				}
			
		});
			btnAdministration.setBounds(0, 427, 279, 47);
			panel_1.add(btnAdministration);
		}
		
		JButton btnProfile = new JButton("PROFILE");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				p.setVisible(true);
			}
		});
		btnProfile.setBounds(0, 427, 279, 47);
		panel_1.add(btnProfile);
		
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
		panel_1.add(deco);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLUE);
		panel_5.setBounds(0, 711, 1338, 65);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(309, 176, 1029, 205);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 21, 847, 184);
		panel_6.add(scrollPane);
		
		tableUtilisateur = new JTable();
		tableUtilisateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			UtilisateursServiceImpl u= new UtilisateursServiceImpl();
			u.modifiderTableauClick(tableUtilisateur, txt_nom, txt_prenom, txt_cni, txt_fone, cb_position);
			}
		});
		tableUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableUtilisateur.setModel(new DefaultTableModel(
			new Object[][] {
				{ null, null, null, null, null},
				{ null, null, null, null, null},
				{ null, null, null, null, null},
			},
			new String[] {
				"       Nom", "     Prenom", "    C.N.I", "  Telephone",  "    Vehicule"
			}
		));
		tableUtilisateur.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableUtilisateur.getColumnModel().getColumn(0).setMinWidth(20);
		scrollPane.setViewportView(tableUtilisateur);
		
		JButton btnimprim = new JButton("Imprimer");
		btnimprim.setBounds(10, 14, 129, 42);
		panel_6.add(btnimprim);
		
		JButton btnexportxls = new JButton("Exporter en Xls");
		btnexportxls.setBounds(10, 83, 129, 42);
		panel_6.add(btnexportxls);
		
		JButton btnexportpdf = new JButton("Exporter en PDF");
		btnexportpdf.setBounds(10, 160, 129, 37);
		panel_6.add(btnexportpdf);
	
//-----------------partie ajout d'un utilisateur-----------------------------------		
		panAjouUt.setBounds(309, 381, 996, 319);
		contentPane.add(panAjouUt);
		panAjouUt.setLayout(null);
		panAjouUt.setVisible(false);
		
//------------------partie recherche d'utilisateur-------------------------------------		
		panRecherche.setBounds(309, 381, 996, 319);
		contentPane.add(panRecherche);
		 panRecherche.setLayout(null);
		 panRecherche.setVisible(false);

//---------------Partie pour affecter un vehicule---------------------
		panAff.setBounds(309, 381, 996, 319);
		contentPane.add(panAff);
		panAff.setLayout(null);
		panAff.setVisible(false);

	
	//--------------formulaire d'enregistrement d'un utilisateur----------------------------------
         getContentPane().setLayout(null);
		JLabel lblAjoutDunUtilisateur = new JLabel("Ajout dun utilisateur");
		lblAjoutDunUtilisateur.setForeground(Color.RED);
		lblAjoutDunUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAjoutDunUtilisateur.setBounds(314, 11, 191, 14);
		 panAjouUt.add(lblAjoutDunUtilisateur);
		
		 JLabel  nom = new JLabel("Nom :");
		nom .setBounds(232, 92, 46, 14);
		 panAjouUt.add(nom );
		
		 JLabel  prenom= new JLabel("Prénom :");
		prenom.setBounds(232, 117, 78, 14);
		 panAjouUt.add(prenom);
		
		 JLabel   fone = new JLabel("Téléphone :");
		fone .setBounds(232, 142, 78, 14);
		 panAjouUt.add(fone );
		
		 JLabel cni = new JLabel("C.N.I :");
		cni.setBounds(232, 167, 46, 14);
		 panAjouUt.add(cni);
		 cb_position = new JComboBox();
	 		cb_position.setModel(new DefaultComboBoxModel(new String[] {"     Interne", "     Intervenant"}));
	 		cb_position.setBounds(349, 195, 156, 20);
	 		panAjouUt.add(cb_position);
	 		
	 		JLabel lblPositionnement = new JLabel("Positionnement:");
	 		lblPositionnement.setBounds(232, 198, 108, 14);
	 		panAjouUt.add(lblPositionnement);
		
	 		JLabel lblNewLabel = new JLabel("");
	 		lblNewLabel.setIcon(new ImageIcon(Utilisateurs.class.getResource("/com/cgipag/ui/img/travail.jpg")));
	 		lblNewLabel.setBounds(607, 22, 234, 232);
	 		panAjouUt.add(lblNewLabel);
		
		txt_nom = new JTextField();
		txt_nom.setBounds(349, 89, 156, 20);
		 panAjouUt.add(txt_nom);
		 txt_nom.setColumns(10);
		
		txt_prenom = new JTextField();
		txt_prenom.setColumns(10);
		txt_prenom.setBounds(349, 114, 156, 20);
		 panAjouUt.add(txt_prenom);
		
		txt_fone = new JTextField();
		txt_fone.setColumns(10);
		txt_fone.setBounds(349, 139, 156, 20);
		 panAjouUt.add(txt_fone);
		
		txt_cni= new JTextField();
		txt_cni.setColumns(10);
		txt_cni.setBounds(349, 164, 156, 20);
		 panAjouUt.add(txt_cni);
		 
			
	 		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nom=txt_nom.getText();
				String prenom=txt_prenom.getText();
				String tel=txt_fone.getText();
				String cni=txt_cni.getText();
				String positionnement= cb_position.getSelectedItem().toString();
				
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(tel);
				System.out.println(cni);
				System.out.println(positionnement);
				
	//------------------Transmission des données de l'utilisateur à la couche service-----------------------	
				com.cgipa.domaine.Utilisateurs ut= new com.cgipa.domaine.Utilisateurs(nom, prenom, cni,tel,  positionnement);
		        util.AjouterUtilisateurs(ut);
		
		
				
			}
		});
		btnValider.setBounds(251, 250, 89, 39);
		 panAjouUt.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(405, 250, 89, 39);
		 panAjouUt.add(btnAnnuler);
		 
		
		 
		 
		 //-------------Formulaire de Recherche d'utilisateur---------------------------
		 getContentPane().setLayout(null);
		 		JLabel lblRechercheDunUtilisateur = new JLabel("Recherche d'un utilisateur");
		 		lblRechercheDunUtilisateur.setBounds(391, 5, 214, 23);
		 		lblRechercheDunUtilisateur.setForeground(Color.RED);
		 		lblRechercheDunUtilisateur.setFont(new Font("Times New Roman", Font.BOLD, 19));
		 		panRecherche.add(lblRechercheDunUtilisateur);
		 		
		 		JLabel lblNonDeLutilisateur = new JLabel("Non de l'utilisateur");
		 		lblNonDeLutilisateur.setForeground(Color.RED);
		 		lblNonDeLutilisateur.setFont(new Font("Tahoma", Font.PLAIN, 17));
		 		lblNonDeLutilisateur.setBounds(97, 92, 149, 14);
		 		panRecherche.add(lblNonDeLutilisateur);
		 		
		 		JLabel lblNom_1 = new JLabel("Nom :");
		 		lblNom_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 		lblNom_1.setBounds(93, 144, 46, 14);
		 		panRecherche.add(lblNom_1);
		 		
		 		JLabel lblPrenom = new JLabel("Prenom :");
		 		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 		lblPrenom.setBounds(93, 180, 116, 14);
		 		panRecherche.add(lblPrenom);
		 		
		 		txtnom = new JTextField();
		 		txtnom.setBounds(178, 143, 180, 20);
		 		panRecherche.add(txtnom);
		 		txtnom.setColumns(10);
		 		
		 		txtprenom = new JTextField();
		 		txtprenom.setColumns(10);
		 		txtprenom.setBounds(178, 174, 180, 20);
		 		panRecherche.add(txtprenom);
		 		
		 		JLabel lblMatricule = new JLabel("Matricule");
		 		lblMatricule.setForeground(Color.RED);
		 		lblMatricule.setFont(new Font("Tahoma", Font.PLAIN, 17));
		 		lblMatricule.setBounds(745, 92, 149, 14);
		 		panRecherche.add(lblMatricule);
		 		
		 		JLabel lblEntrezLeMatricule = new JLabel("Entrez le matricule :");
		 		lblEntrezLeMatricule.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 		lblEntrezLeMatricule.setBounds(549, 146, 149, 14);
		 		panRecherche.add(lblEntrezLeMatricule);
		 		
		 		txtmatricule = new JTextField();
		 		txtmatricule.setBounds(709, 143, 149, 20);
		 		panRecherche.add(txtmatricule);
		 		txtmatricule.setColumns(10);
		 		
		 		JButton btnRechercher = new JButton("Rechercher");
		 		btnRechercher.setBounds(200, 250, 110, 40);
		 		panRecherche.add(btnRechercher);
		 		
		 		JButton btnRechercher1 = new JButton("Rechercher");
		 		btnRechercher1.setBounds(750, 250, 110, 40);
		 		panRecherche.add(btnRechercher1);
		 		
		 		
		 		

//-------------------------Formulaire  Affectation de vehicule----------------------------------------
	getContentPane().setLayout(null);
	
	JLabel lblAff= new JLabel("Affectation à un utilisateur");
	lblAff.setForeground(Color.RED);
	lblAff.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblAff.setBounds(314, 11, 217, 14);
	panAff.add(lblAff);
	
	JLabel lblNomu = new JLabel("Nom :");
	lblNomu.setBounds(288, 91, 46, 14);
	panAff.add(lblNomu);
	
	JButton btnAff = new JButton("Affecter");
	btnAff.setBounds(344, 222, 89, 39);
	panAff.add(btnAff);
	
	JComboBox cb_aff= new JComboBox();
	cb_aff.setBounds(415, 88, 128, 20);
	panAff.add(cb_aff);
	
	JLabel lblMatriculeDuVhicule = new JLabel("Matricule du véhicule :");
	lblMatriculeDuVhicule.setBounds(288, 159, 133, 14);
	panAff.add(lblMatriculeDuVhicule);
	
	JComboBox cb_mat = new JComboBox();
	cb_mat .setBounds(415, 156, 128, 20);
	panAff.add(cb_mat );
	
	
	
}
	
	public void RemplirTableUtilsateurs()
	{
          UtilisateursServiceImpl util= new UtilisateursServiceImpl();
			rs=util.AffichertousUtil();
			tableUtilisateur.setModel(DbUtils.resultSetToTableModel(rs));
		
	}
}
