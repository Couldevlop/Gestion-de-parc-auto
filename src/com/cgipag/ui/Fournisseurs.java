package com.cgipag.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cgipa.DAO.Singleton;
import com.cgipa.domaine.Fournisseur;
import com.cgipa.service.Impl.FournisseurServiceImpl;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Fournisseurs extends JFrame implements Serializable {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtnom;
	private JTextField txtrs;
	private JTextField txtpays;
	private JTextField txtvil;
	private JTextField txtfone;
	private String nom;
	private String rso;
	private String pays;
	private String ville;
	private String tel;
	ResultSet rs=null;
	Connection cnx;
	private int ni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fournisseurs frame = new Fournisseurs();
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
	public Fournisseurs() {
		setResizable(false);
		cnx=Singleton.ObtenirConnectionDB();
		FournisseurServiceImpl four = new FournisseurServiceImpl();
		ProfileUtil p= new ProfileUtil ();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1344, 818);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 0, 1286, 156);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Fournisseurs.class.getResource("/com/cgipag/ui/img/logo.png")));
		label.setBounds(10, 0, 300, 156);
		panel.add(label);
		
		JLabel lblGestionDeFournisseurs = new JLabel("Gestion de fournisseurs");
		lblGestionDeFournisseurs.setFont(new Font("Times New Roman", Font.BOLD, 41));
		lblGestionDeFournisseurs.setBounds(598, 30, 418, 53);
		panel.add(lblGestionDeFournisseurs);
		
		JButton btnListerLes = new JButton("--- Lister les fournisseurs ---");
		btnListerLes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RemplirTableForn();
			}
		});
		btnListerLes.setBounds(563, 111, 200, 34);
		panel.add(btnListerLes);
		
		JPanel panAjoutFour = new JPanel();
		panAjoutFour.setBounds(351, 432, 962, 304);
		contentPane.add(panAjoutFour);
		panAjoutFour.setLayout(null);
		panAjoutFour.setVisible(false);
		
		
		JLabel label_2 = new JLabel("Nom :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(140, 73, 46, 14);
		panAjoutFour.add(label_2);
		
		JLabel label_3 = new JLabel("Raison Sociale :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(140, 98, 106, 14);
		panAjoutFour.add(label_3);
		
		JLabel label_4 = new JLabel("Pays :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(140, 123, 46, 14);
		panAjoutFour.add(label_4);
		
		JLabel label_5 = new JLabel("Ville :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(140, 148, 46, 14);
		panAjoutFour.add(label_5);
		
		JLabel label_6 = new JLabel("Téléphone :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(140, 173, 95, 14);
		panAjoutFour.add(label_6);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(289, 64, 218, 20);
		panAjoutFour.add(txtnom);
		
		txtrs = new JTextField();
		txtrs.setColumns(10);
		txtrs.setBounds(289, 89, 218, 20);
		panAjoutFour.add(txtrs);
		
		txtpays = new JTextField();
		txtpays.setColumns(10);
		txtpays.setBounds(289, 114, 218, 20);
		panAjoutFour.add(txtpays);
		
		txtvil = new JTextField();
		txtvil.setColumns(10);
		txtvil.setBounds(289, 142, 218, 20);
		panAjoutFour.add(txtvil);
		
		txtfone = new JTextField();
		txtfone.setColumns(10);
		txtfone.setBounds(289, 167, 218, 20);
		panAjoutFour.add(txtfone);
		
		JButton button_3 = new JButton("Valider");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//--------Recuperation des elements du formulaire --------------------------
				
				 nom= txtnom.getText();
				 rso= txtrs.getText();
				 pays= txtpays.getText();
				ville = txtvil.getText();
				tel = txtfone.getText();
				
				if(nom.isEmpty() ||  rso.isEmpty() || pays.isEmpty()  ||  ville.isEmpty()  ||  tel.isEmpty())
				{
					int i=JOptionPane.showConfirmDialog(null, " Un ou plusieurs champs du formulaire est(sont) vide(s). Voulez-vous continuer", "NOTIFICATION", JOptionPane.YES_NO_OPTION);
					
									if(i==1)
									{
										dispose();
										Dashboard da = new Dashboard();
										da.setVisible(true);
									}
									else if(i==0)
									{
				//						// on reste sur la meme page et on initialise les champs du formulaire
									 txtnom.setText(" ");
									 txtrs.setText(" ");
									 txtpays.setText(" ");
									 txtvil.setText(" ");
									 txtfone.setText(" ");
									}
	
				}
				else
				{		
					verificationDoublon();
					

					//--------------------Création et Transmission des données d'un fournisseur----------------
					Fournisseur fou = new Fournisseur(nom, rso, pays, ville, tel);
					
					// initialisation des champs du formulaire
					four.AjouterFour(fou);
					 txtnom.setText(" ");
					 txtrs.setText(" ");
					 txtpays.setText(" ");
					 txtvil.setText(" ");
					 txtfone.setText(" ");
				}
				}
				
		});
		button_3.setFont(new Font("Tekton Pro", Font.BOLD, 17));
		button_3.setBounds(140, 228, 136, 38);
		panAjoutFour.add(button_3);
		
		JButton button_4 = new JButton("Annuler");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i=JOptionPane.showConfirmDialog(null, " Etes-vous sur de vouloir  annuler cette opération?", "Message de Confirmation", JOptionPane.YES_NO_OPTION);
				if(i==0)
				{
					dispose();
					Dashboard da = new Dashboard();
					da.setVisible(true);
				}
				else if(i==1)
				{
//					// on reste sur la meme page et on initialise les champs du formulaire
				 txtnom.setText(" ");
				 txtrs.setText(" ");
				 txtpays.setText(" ");
				 txtvil.setText(" ");
				 txtfone.setText(" ");
				}
				
			}
	
		});
		button_4.setFont(new Font("Tekton Pro", Font.BOLD, 17));
		button_4.setBounds(370, 228, 144, 38);
		panAjoutFour.add(button_4);
		
		JLabel label_7 = new JLabel("Ajout d'un fournisseur");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 30));
		label_7.setBounds(258, 11, 315, 23);
		panAjoutFour.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Fournisseurs.class.getResource("/com/cgipag/ui/img/SRENETY.jpg")));
		label_8.setBounds(713, 12, 200, 100);
		panAjoutFour.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Fournisseurs.class.getResource("/com/cgipag/ui/img/AXA.png")));
		label_9.setBounds(580, 11, 123, 120);
		panAjoutFour.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Fournisseurs.class.getResource("/com/cgipag/ui/img/NSIA.jpg")));
		label_10.setBounds(753, 123, 160, 120);
		panAjoutFour.add(label_10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Fournisseurs.class.getResource("/com/cgipag/ui/img/SUNU.png")));
		lblNewLabel.setBounds(590, 148, 153, 113);
		panAjoutFour.add(lblNewLabel);
		
		JButton AjoutFour = new JButton("--- Ajouter fournisseur ---");
		AjoutFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panAjoutFour.setVisible(true);
			}
		});
		AjoutFour.setBounds(773, 111, 200, 34);
		panel.add(AjoutFour);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		menuItem.setBounds(586, 123, 129, 22);
		panel.add(menuItem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-6, -179, 22, 932);
		panel_1.setBackground(Color.BLUE);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1312, -102, 26, 882);
		panel_2.setBackground(Color.BLUE);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(-20, 156, 1338, 16);
		panel_3.setBackground(Color.BLUE);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(21, 180, 279, 534);
		panel_4.setLayout(null);
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_4);
		
		JLabel label_1 = new JLabel("            Bonjour COULIBALY    ");
		label_1.setFont(new Font("Vijaya", Font.BOLD, 17));
		label_1.setBounds(22, 11, 235, 26);
		panel_4.add(label_1);
		
		JButton vehicule = new JButton("VEHICULES");
		vehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Vehicule v =new  Vehicule();
				v.setVisible(true);
			}
		});
		vehicule.setBounds(0, 78, 279, 47);
		panel_4.add(vehicule);
		
		JButton utilisateurs = new JButton("UTILISATEURS");
		utilisateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Utilisateurs u= new Utilisateurs();
						u.setVisible(true);
			}
		});
		
		utilisateurs.setBounds(0, 136, 279, 47);
		panel_4.add(utilisateurs);
		
		JButton fournisseurs = new JButton("FOURNISSEURS");

		fournisseurs.setBounds(0, 194, 279, 47);
		panel_4.add(fournisseurs);
		
		JButton contacts = new JButton("CONTRATS");
		contacts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			Contrats c = new Contrats();
			c.setVisible(true);
				
			}
		});
		contacts.setBounds(0, 252, 279, 47);
		panel_4.add(contacts);
		
		JButton sinistres = new JButton("SINISTRES");
		sinistres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
           Sinistres  sin = new Sinistres();
           sin.setVisible(true);
				
			}
		});
		sinistres.setBounds(0, 311, 279, 47);
		panel_4.add(sinistres);
		
		JButton reservation = new JButton("RESERVATION");
		reservation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reservation r = new Reservation();
				r.setVisible(true);
				
			}
		});
		reservation.setBounds(0, 369, 279, 47);
		panel_4.add(reservation);
		
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
		panel_4.add(btnAdministration);
		}
		
		JButton btnProfile = new JButton("PROFILE");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				p.setVisible(true);
			}
		});
		btnProfile.setBounds(0, 427, 279, 47);
		panel_4.add(btnProfile);
		
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
		panel_4.add(deco);
		
		JPanel panAffichFour = new JPanel();
		panAffichFour.setBounds(310, 178, 996, 243);
		contentPane.add(panAffichFour);
		panAffichFour.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 11, 847, 169);
		panAffichFour.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 four.modifiderTableauFourClick(table, txtnom, txtrs, txtpays,txtvil, txtfone);
				 
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
					"Nom", "Raison sociale", "  Pays  ", "  telephone  "
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(92);
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("Imprimer");
		button.setBounds(0, 4, 129, 42);
		panAffichFour.add(button);
		
		JButton button_1 = new JButton("Exporter en Xls");
		button_1.setBounds(0, 74, 129, 42);
		panAffichFour.add(button_1);
		
		JButton button_2 = new JButton("Exporter en PDF");
		button_2.setBounds(0, 143, 129, 37);
		panAffichFour.add(button_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(-6, 737, 1493, 43);
		panel_6.setBackground(Color.BLUE);
		contentPane.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(310, 420, 1018, 16);
		panel_7.setBackground(Color.BLUE);
		contentPane.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(310, 420, 46, 318);
		contentPane.add(panel_8);
		panel_8.setBackground(Color.BLUE);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.BLUE);
		panel_9.setBounds(1312, 432, 16, 321);
		contentPane.add(panel_9);
	}
	
		
	
	
	public void RemplirTableForn()
	{
		FournisseurServiceImpl f= new FournisseurServiceImpl();
		ResultSet rs=f.RemplirTableFournisseur();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	
	
	//----------pour empecher les doublons
	public void verificationDoublon()
	{
		FournisseurServiceImpl f= new FournisseurServiceImpl();
		ResultSet rs=null;
		String no = null;
		String pa = null;
		String r= null;
		String vil = null;
		String t=null;
		
		
		
		
		
		rs=f.eviterDoublonsFournisseurs(nom, rso, pays, ville, tel);
		try {
			
			while(rs.next())
			{
			 no = rs.getString("nomfournisseur") ; 
			 pa=rs.getString("paysfournisseur"); 
			 r=rs.getString("rsfournisseur");  
			 vil=rs.getString("villefournisseur"); 
			 t=rs.getString("telfournisseur") ;

			}
			System.out.println(no); System.out.println(r); System.out.println(pa); System.out.println(vil);System.out.println(t);
			if( nom.equals(no)) 
			{
				JOptionPane.showMessageDialog(null, " le fournisseur' " + nom + " ' que vous voulez enregistrer existe deja dans la base de donnée" , "AVERTISSEMENT", JOptionPane.YES_NO_OPTION);
			}
		
				
		} catch (HeadlessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

