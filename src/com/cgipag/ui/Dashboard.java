package com.cgipag.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.cgipa.DAO.Singleton;
import com.cgipa.service.Impl.UtilisateursServiceImpl;
import com.cgipa.service.Impl.VehiculeServiceImpl;
import com.toedter.calendar.JCalendar;
import javax.swing.JMenuItem;
import datechooser.beans.DateChooserCombo;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;

public class Dashboard extends JFrame {
	private JPanel contentPane;
//	private int niveau=Requete.RealiserRequete();
	private int ni;
	private JPanel car;
	private JPanel mercedes;
	private JPanel camion;
	private JPanel separation ;
	private JPanel panaffiche, annonce;
	private JTable table;
	private  String prenom;
	private String d1,d2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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

	public Dashboard() {
		SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-DD");
		StatGenerale stat = new StatGenerale();
		HistoriqueConnexion his = new HistoriqueConnexion();
		Administration admin=new Administration();
		UtilisateursServiceImpl util =new UtilisateursServiceImpl();
		ProfileUtil p= new ProfileUtil ();
//		niveau=Requete.RealiserRequet();
		setTitle("Dashboard");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/com/cgipag/ui/img/backg.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 876);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 1370, 57);
		contentPane.add(menuBar);
		
		JMenu mnFichier = new JMenu("            Fichier           ");
		mnFichier.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		menuBar.add(mnFichier);
		
		JMenuItem mntmFermer = new JMenuItem("         Fermer           ");
		mntmFermer.setPreferredSize(new Dimension(147, 21));
		mnFichier.add(mntmFermer);
		
		JMenu mnGestionCourante = new JMenu("            Gestion Courante                  ");
		mnGestionCourante.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		menuBar.add(mnGestionCourante);
		
		JMenu mnHistorique = new JMenu("                 Historique                     ");
		mnHistorique.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnHistorique);
		
		
		
		his.setBounds(332, 120, 988, 664);
		his.setLayout(null);
		contentPane.add(his);
		
//		admin.setBounds(332, 120, 988, 664);
//		admin.setLayout(null);
//		contentPane.add(admin);
		
		JLabel lblRechercheParPriode = new JLabel("Recherche par période:");
		lblRechercheParPriode.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechercheParPriode.setForeground(Color.RED);
		lblRechercheParPriode.setBounds(89, 176, 197, 20);
		his.add(lblRechercheParPriode);
		
		JLabel lblDateDbut = new JLabel("Date début:");
		lblDateDbut.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDbut.setBounds(10, 237, 88, 14);
		his.add(lblDateDbut);
		
		JLabel label = new JLabel("Date début:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(10, 347, 88, 14);
		his.add(label);
		
		DateChooserCombo date1= new DateChooserCombo();
		date1.setBounds(131, 237, 155, 20);
		his.add(date1);
		
		DateChooserCombo date2 = new DateChooserCombo();
		date2.setBounds(131, 341, 155, 20);
		his.add(date2);
		
		JLabel lblRechercheParUtilisateur = new JLabel("Recherche par utilisateur:");
		lblRechercheParUtilisateur.setForeground(Color.RED);
		lblRechercheParUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechercheParUtilisateur.setBounds(682, 176, 228, 20);
		his.add(lblRechercheParUtilisateur);
		
		JComboBox cbutilisateur = new JComboBox();
		util.RemplirComboxUtilisateurHistorique(cbutilisateur);
		cbutilisateur.setBounds(707, 261, 184, 32);
		his.add(cbutilisateur);
		
		JLabel lblSelectionDutilisateur = new JLabel("Selection d'utilisateur:");
		lblSelectionDutilisateur.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectionDutilisateur.setBounds(542, 269, 155, 14);
		his.add(lblSelectionDutilisateur);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 67, 1041, 16);
		his.add(panel);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//---------------------------RECUPEERATION DES DATES-------------------------
			 d1=format.format(date1.getSelectedDate().getTime());
			 d2=format.format(date2.getSelectedDate().getTime());
			 RemplirTableLogueDate();
			}
		});
		btnValider.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnValider.setBounds(151, 427, 149, 41);
		his.add(btnValider);
		
		JButton button = new JButton("Valider");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 prenom=cbutilisateur.getSelectedItem().toString();
				 RemplirTableLogue();
			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBounds(742, 427, 149, 41);
		his.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 501, 701, 152);
		his.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		his.setVisible(false);
		JMenuItem mHistoriqueConnexion = new JMenuItem("        Historique  des  connexion        ");
		mHistoriqueConnexion.setPreferredSize(new Dimension(270, 21));
		mHistoriqueConnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				camion.hide();
				mercedes.hide();
				car.hide();
				separation.hide();
				stat.hide();
				annonce.hide();
				his.setVisible(true);
				
			}
		});
		
		mnHistorique.add(mHistoriqueConnexion);
		
		JMenu mnArchivage = new JMenu("                  Archivage               ");
		mnArchivage.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		menuBar.add(mnArchivage);
		
		JMenuItem mntmDifferentRapportsDe = new JMenuItem("Different rapports de gestions ");
		mntmDifferentRapportsDe.setPreferredSize(new Dimension(207, 21));
		mntmDifferentRapportsDe.setMaximumSize(new Dimension(32788, 32767));
		mnArchivage.add(mntmDifferentRapportsDe);
		
		JMenu mnAutresActivits = new JMenu("                  Statistiques                     ");
		mnAutresActivits.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		menuBar.add(mnAutresActivits);
		

	//----------- donner une dimention au panneau de statistique---------	
		 panaffiche = new JPanel();
		stat.setLayout(null);
		stat.setBounds(350, 120, 970, 664);
          contentPane.add(stat);
          stat.setVisible(false);
          
		JMenuItem StatGnrale = new JMenuItem("                    Stat génrale                         ");
		StatGnrale.setPreferredSize(new Dimension(240, 21));
		StatGnrale.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//---masquer les panneaux de camion, car et mercedes
			camion.hide();
			mercedes.hide();
			car.hide();
			separation.hide();
			his.hide();
			annonce.hide();
				stat.setVisible(true);
			}
		});
		mnAutresActivits.add(StatGnrale);
		
		JMenu mnAutresActivits_1 = new JMenu("               Autres activités            ");
		mnAutresActivits_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		menuBar.add(mnAutresActivits_1);
		
		JPanel panmenugauche = new JPanel();
		panmenugauche.setBackground(Color.LIGHT_GRAY);
		panmenugauche.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panmenugauche.setBounds(20, 224, 279, 534);
		contentPane.add(panmenugauche);
		panmenugauche.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel( "     " + Connexion.username);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Vijaya", Font.BOLD, 35));
		lblNewLabel_1.setBounds(10, 41, 235, 26);
		panmenugauche.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("VEHICULES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 	dispose();
				Vehicule  v = new  Vehicule();
		      v.setVisible(true);
		 
			}
		});
		btnNewButton.setBounds(0, 78, 279, 47);
		panmenugauche.add(btnNewButton);
		
		JButton btnUtilisateurs = new JButton("UTILISATEURS");
		btnUtilisateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 dispose();
				Utilisateurs util = new Utilisateurs();
				util.setVisible(true);
			}
		});
		btnUtilisateurs.setBounds(0, 136, 279, 47);
		panmenugauche.add(btnUtilisateurs);
		
		JButton btnFournisseurs = new JButton("FOURNISSEURS");
		btnFournisseurs.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Fournisseurs four = new Fournisseurs();
				four.setVisible(true);
			}
		});
		btnFournisseurs.setBounds(0, 194, 279, 47);
		panmenugauche.add(btnFournisseurs);
		
		JButton btnContracts = new JButton("CONTRACTS");
		btnContracts.setBounds(0, 252, 279, 47);
		btnContracts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Contrats ct = new Contrats();
				ct.setVisible(true);
			}
		});
		panmenugauche.add(btnContracts);
		
		JButton btnSinistres = new JButton("SINISTRES");
		btnSinistres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sinistres sin = new Sinistres();
				sin.setVisible(true);
				
			}
		});
		btnSinistres.setBounds(0, 311, 279, 47);
		panmenugauche.add(btnSinistres);
		
		JButton btnReservation = new JButton("RESERVATION");
		btnReservation.setBounds(0, 369, 279, 47);
		panmenugauche.add(btnReservation);
		
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
			admin.setVisible(true);
				}
			});
			btnAdministration.setBounds(0, 427, 279, 47);
			panmenugauche.add(btnAdministration);
		}
		
			JButton btnProfile = new JButton("PROFILE");
			btnProfile.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					p.setVisible(true);
				}
			});
			btnProfile.setBounds(0, 427, 279, 47);
			panmenugauche.add(btnProfile);
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
		panmenugauche.add(deco);
		
		JLabel lblVousEtesConnect = new JLabel("Vous etes connecté en tant que:");
		lblVousEtesConnect.setForeground(Color.WHITE);
		lblVousEtesConnect.setFont(new Font("Verdana", Font.BOLD, 14));
		lblVousEtesConnect.setBounds(10, 4, 259, 26);
		panmenugauche.add(lblVousEtesConnect);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/com/cgipag/ui/img/logo.png")));
		lblNewLabel.setBounds(10, 79, 292, 146);
		contentPane.add(lblNewLabel);
		
//		JPanel panaffiche = new JPanel();
		panaffiche.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panaffiche.setBounds(329, 115, 998, 674);
		contentPane.add(panaffiche);
		panaffiche.setLayout(null);
		
		car = new JPanel();
		car.setBounds(10, 11, 300, 192);
		car.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panaffiche.add(car);
		car.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Dashboard.class.getResource("/com/cgipag/ui/img/buscar.jpg")));
		lblNewLabel_2.setBounds(10, 11, 280, 177);
		car.add(lblNewLabel_2);
		
		 mercedes = new JPanel();
		mercedes.setBounds(334, 11, 324, 192);
		mercedes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panaffiche.add(mercedes);
		mercedes.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Dashboard.class.getResource("/com/cgipag/ui/img/mercedes.jpg")));
		lblNewLabel_3.setBounds(10, 0, 282, 198);
		mercedes.add(lblNewLabel_3);
		
		camion = new JPanel();
		camion.setBounds(678, 11, 310, 192);
		camion.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panaffiche.add(camion);
		camion.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Dashboard.class.getResource("/com/cgipag/ui/img/camion.jpg")));
		lblNewLabel_4.setBounds(10, 11, 275, 177);
		camion.add(lblNewLabel_4);
		
		
		//------------------le slide---------------------------
		annonce = new JPanel();
		annonce.setBounds(170, 260, 700, 400);
		JLabel lblNewLabel_5= new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Dashboard.class.getResource("/com/cgipag/ui/img/g.gif")));
		annonce.add(lblNewLabel_5);
		panaffiche.add(annonce);
		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		calendar.setBounds(10, 11, 245, 178);

		
		 separation = new JPanel();
		separation.setBounds(10, 209, 978, 16);
		separation.setBackground(Color.BLUE);
		panaffiche.add(separation);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(0, 790, 1350, 35);
		contentPane.add(panel_2);
		
		JLabel lblCopyrithByCoulibaly = new JLabel("                                                                                                                                                                                                    Copyrith@ by Coulibaly Waopron Thomas: Ingeneer for computer sciences");
		lblCopyrithByCoulibaly.setToolTipText("                                                                                                                                            ");
		lblCopyrithByCoulibaly.setForeground(Color.BLACK);
		lblCopyrithByCoulibaly.setBackground(Color.BLACK);
		lblCopyrithByCoulibaly.setBounds(10, 836, 1340, 11);
		contentPane.add(lblCopyrithByCoulibaly);
		
		JPanel separateur_3 = new JPanel();
		separateur_3.setBackground(Color.BLUE);
		separateur_3.setBounds(309, 90, 1041, 16);
		contentPane.add(separateur_3);
		
		JPanel separateur_4 = new JPanel();
		separateur_4.setBackground(Color.BLUE);
		separateur_4.setForeground(Color.BLUE);
		separateur_4.setBounds(309, 90, 13, 680);
		contentPane.add(separateur_4);
		
		JPanel separateur_5 = new JPanel();
		separateur_5.setBackground(Color.BLUE);
		separateur_5.setBounds(1337, 102, 13, 688);
		contentPane.add(separateur_5);
		
		JPanel separateur_6 = new JPanel();
		separateur_6.setBackground(Color.BLUE);
		separateur_6.setBounds(309, 754, 1041, -14);
		contentPane.add(separateur_6);
		
		JPanel separateur_7 = new JPanel();
		separateur_7.setBackground(Color.BLUE);
		separateur_7.setBounds(0, 65, 13, 705);
		contentPane.add(separateur_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.BLUE);
		panel_8.setBounds(0, 760, 322, 43);
		contentPane.add(panel_8);
		
		JMenu mnComptabilit = new JMenu("             Comptabilité Générale              ");
		mnComptabilit.setBounds(150, 34, 281, 55);
		contentPane.add(mnComptabilit);
		mnComptabilit.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
	}
	
	
	public void RemplirTableLogue()
	{
		Connection cnx= Singleton.ObtenirConnectionDB();
		UtilisateursServiceImpl u = new UtilisateursServiceImpl();
		ResultSet re=null;
		re=u.RemplirTabstatHistoriqueConnexion(prenom);
		table.setModel(DbUtils.resultSetToTableModel(re));
	}
	
	public void RemplirTableLogueDate()
	{
		Connection cnx= Singleton.ObtenirConnectionDB();
		UtilisateursServiceImpl u = new UtilisateursServiceImpl();
		ResultSet rtt=null;
		rtt=u.RemplirTabstatHistoriqueConnexionDate(d1, d2);
		table.setModel(DbUtils.resultSetToTableModel(rtt));
	}
}
