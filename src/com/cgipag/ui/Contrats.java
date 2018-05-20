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
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cgipa.domaine.Contrat;
import com.cgipa.domaine.Typecontrat;
import com.cgipa.service.Impl.ContratServiceImpl;
import com.cgipa.service.Impl.FournisseurServiceImpl;
import com.cgipa.service.Impl.VehiculeServiceImpl;

import net.proteanit.sql.DbUtils;
import javax.swing.JComboBox;
import datechooser.beans.DateChooserDialog;
import datechooser.beans.DateChooserCombo;
import javax.swing.JTextField;

public class Contrats extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtmontant;
	private JPanel AjoutContra;
	private int ni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contrats frame = new Contrats();
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
	public Contrats() {
		ContratServiceImpl ct=new ContratServiceImpl();
		VehiculeServiceImpl v= new VehiculeServiceImpl();
		ProfileUtil p= new ProfileUtil ();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1335, 904);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(11, 0, 1286, 156);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Contrats.class.getResource("/com/cgipag/ui/img/logo.png")));
		label.setBounds(10, 0, 300, 156);
		panel.add(label);
		
		JLabel lblGestionDeContacts = new JLabel("Gestion de Contrats");
		lblGestionDeContacts.setFont(new Font("Times New Roman", Font.BOLD, 41));
		lblGestionDeContacts.setBounds(565, 22, 418, 53);
		panel.add(lblGestionDeContacts);
		
		JButton btnListerDes = new JButton("--- Lister des contrats ---");
		btnListerDes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				remplirTableContrat();
				
			}
		});
		btnListerDes.setBounds(565, 111, 169, 34);
		panel.add(btnListerDes);
		
		JButton btnAjouterUn = new JButton("--- Ajouter un contrat ---");
		btnAjouterUn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 AjoutContra.setVisible(true);
			}
		});
		btnAjouterUn.setBounds(768, 111, 169, 34);
		panel.add(btnAjouterUn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(-29, 156, 1338, 16);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(12, 180, 279, 534);
		contentPane.add(panel_2);
		
		JLabel label_2 = new JLabel("     " + Connexion.username);
		label_2.setFont(new Font("Vijaya", Font.BOLD, 17));
		label_2.setBounds(22, 11, 235, 26);
		panel_2.add(label_2);
		
		JButton vehicules = new JButton("VEHICULES");
		vehicules .addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vehicule  v = new Vehicule();
				v.setVisible(true);
				
			}
		});
		vehicules.setBounds(0, 78, 279, 47);
		panel_2.add(vehicules);
		
		JButton utilisateurs= new JButton("UTILISATEURS");
		utilisateurs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Utilisateurs  u = new Utilisateurs();
				u.setVisible(true);
				
			}
		});
		utilisateurs.setBounds(0, 136, 279, 47);
		panel_2.add(utilisateurs);
		
		JButton fournisseurs = new JButton("FOURNISSEURS");
		fournisseurs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Fournisseurs  f = new Fournisseurs();
				f.setVisible(true);
				
			}
		});
		fournisseurs.setBounds(0, 194, 279, 47);
		panel_2.add(fournisseurs);
		
		JButton contrats= new JButton("CONTRATS");
		
		contrats.setBounds(0, 252, 279, 47);
		panel_2.add(contrats);
		
		JButton Sinistres = new JButton("SINISTRES");
		Sinistres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sinistres  s = new Sinistres();
				s.setVisible(true);
				
			}
		});
		Sinistres.setBounds(0, 311, 279, 47);
		panel_2.add(Sinistres);
		
		JButton Reservation = new JButton("RESERVATION");
		Reservation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reservation  r = new Reservation();
				r.setVisible(true);
				
			}
		});
		Reservation.setBounds(0, 369, 279, 47);
		panel_2.add(Reservation);
		
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
			panel_2.add(btnAdministration);
		}
		
		JButton btnProfile = new JButton("PROFILE");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			
				p.setVisible(true);
			}
		});
		btnProfile.setBounds(0, 427, 279, 47);
		panel_2.add(btnProfile);
		
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
		panel_2.add(deco);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(301, 178, 996, 628);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 44, 847, 183);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
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
				"Nom foirnisseur", "Raison sociale", "Tpes contrats", "Matricule v\u00E9hicule", "D\u00E9but contrat", "Fin contrat", "Cout contrat", "Modification", "Suppression"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton button_12 = new JButton("Imprimer");
		button_12.setBounds(0, 44, 129, 42);
		panel_3.add(button_12);
		
		JButton button_13 = new JButton("Exporter en Xls");
		button_13.setBounds(0, 113, 129, 42);
		panel_3.add(button_13);
		
		JButton button_14 = new JButton("Exporter en PDF");
		button_14.setBounds(0, 190, 129, 37);
		panel_3.add(button_14);
		
		JLabel lblListeDesContrats = new JLabel("Liste des contrats");
		lblListeDesContrats.setBounds(409, 11, 158, 22);
		lblListeDesContrats.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_3.add(lblListeDesContrats);
		
		AjoutContra = new JPanel();
		AjoutContra.setBounds(0, 238, 996, 390);
		panel_3.add(AjoutContra);
		AjoutContra.setLayout(null);
		AjoutContra.setVisible(false);
		
		JLabel lblAjoutDe = new JLabel("- Ajout de nouveau contrat -");
		lblAjoutDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAjoutDe.setBounds(396, 11, 287, 22);
		AjoutContra.add(lblAjoutDe);
		
		JLabel lblNewLabel = new JLabel("Nom du Fournisseur :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(266, 62, 174, 14);
		AjoutContra.add(lblNewLabel);
		
		JLabel lblTypeDeContrat = new JLabel("Type de contrat :");
		lblTypeDeContrat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTypeDeContrat.setBounds(299, 100, 174, 14);
		AjoutContra.add(lblTypeDeContrat);
		
		JLabel lblMatriculeDuVehicule = new JLabel("Matricule du vehicule :");
		lblMatriculeDuVehicule.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMatriculeDuVehicule.setBounds(266, 145, 174, 14);
		AjoutContra.add(lblMatriculeDuVehicule);
		
		JLabel lblDateDeDebut = new JLabel("Date de debut du contrat :");
		lblDateDeDebut.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDateDeDebut.setBounds(243, 186, 188, 14);
		AjoutContra.add(lblDateDeDebut);
		
		JLabel lblDateDeFin = new JLabel("Date de fin du contrat :");
		lblDateDeFin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDateDeFin.setBounds(255, 227, 174, 14);
		AjoutContra.add(lblDateDeFin);
		
		JLabel lblMontantDuContrat = new JLabel("Montant du contrat :");
		lblMontantDuContrat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMontantDuContrat.setBounds(277, 263, 153, 14);
		AjoutContra.add(lblMontantDuContrat);
		
		JComboBox cb_nomfour = new JComboBox();
		cb_nomfour.setBounds(493, 56, 188, 22);
		FournisseurServiceImpl f= new FournisseurServiceImpl();
		f.remplirComboAssureur(cb_nomfour);
		AjoutContra.add(cb_nomfour);
		
		JComboBox cb_typecontrat = new JComboBox();
		cb_typecontrat.setBounds(493, 98, 188, 22);
		ct.remplirComboTypecontrat(cb_typecontrat);
		AjoutContra.add(cb_typecontrat);
		
		JComboBox cb_matricule = new JComboBox();
		cb_matricule.setBounds(493, 144, 188, 22);
		v.remplirComboMatriculeVehicule(cb_matricule);
		AjoutContra.add(cb_matricule);
		
		DateChooserCombo datedebutcontra = new DateChooserCombo();
		datedebutcontra.setBounds(493, 186, 190, 20);
		AjoutContra.add(datedebutcontra);
		
		DateChooserCombo datefincontra = new DateChooserCombo();
		datefincontra .setBounds(491, 227, 190, 20);
		AjoutContra.add(datefincontra );
		
		txtmontant = new JTextField();
		txtmontant.setBounds(493, 262, 188, 20);
		AjoutContra.add(txtmontant);
		txtmontant.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//---------Recuperation des elemnts du formulaire
				
				String libellee=cb_nomfour.getSelectedItem().toString();
				String typecontrat=cb_typecontrat.getSelectedItem().toString();
				String matricule=cb_matricule.getSelectedItem().toString();
				String datedebutcontrat= formatter.format(datedebutcontra.getSelectedDate().getTime());
		       String datefincontrat=formatter.format(datefincontra.getSelectedDate().getTime());
		       float montant= Float.parseFloat(txtmontant.getText());
		       
		       
		       if(libellee.isEmpty() || typecontrat.isEmpty() ||  matricule.isEmpty() ||  datedebutcontrat.isEmpty()  || datefincontrat.isEmpty())
		       {
		    	   JOptionPane.showConfirmDialog(null, "L'un des champs ou le formulaire est vide veuillez le renseigner entierement", "NOTIFICATION", JOptionPane.CLOSED_OPTION);
		       }
		       
		       else
		       {
		    	 //-----------------appel à la couche service----------------------------
		   		
			       System.out.println(datedebutcontrat);
			       System.out.println(datefincontrat);
			       System.out.println(montant);
			      
		  Typecontrat tc= new  Typecontrat(datedebutcontrat, datefincontrat, montant, libellee);
		  Contrat cont = new Contrat(datedebutcontrat, datefincontrat, montant);
			       ContratServiceImpl cs= new ContratServiceImpl();
			       Typecontrat p=new Typecontrat(libellee);
			       cs.Ajoutercontrat(cont);
		       }
		       

			}
		});
		btnNewButton.setBounds(299, 333, 89, 46);
		AjoutContra.add(btnNewButton);
		
		JButton btnAnnueler = new JButton("Annueler");
		btnAnnueler.setBounds(594, 333, 89, 46);
		AjoutContra.add(btnAnnueler);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLUE);
		panel_4.setBounds(-15, -179, 29, 1050);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLUE);
		panel_5.setBounds(10, 816, 1493, 55);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLUE);
		panel_6.setBounds(1303, -102, 16, 932);
		contentPane.add(panel_6);
	}
	
	
	public void remplirTableContrat()
	{
		ContratServiceImpl c = new ContratServiceImpl();
		
		ResultSet rs=null;
		rs=c.ListerContrat();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
	}
}
