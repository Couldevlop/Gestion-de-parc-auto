package com.cgipag.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import datechooser.beans.DateChooserCombo;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.cgipa.domaine.Connexion;
import com.cgipa.service.Impl.ConnexionServiceImpl;

import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import datechooser.beans.DateChooserPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.data.category.DefaultCategoryDataset;

public class Administration extends JFrame {

	private JPanel contentPane;
	private JPanel panUtic;
	private JPanel panInscription;
	private JTextField user;
	private JTextField pass;
	private JTextField level;
	private Component conex;
	private JTable table;
	private JTextField nomu;
	private JTextField prenomu;
	private JTextField contact1u;
	private JTextField contact2u;
	private JTextField quartieru;
	private JTextField villeu;
	private JTextField adresseu;
	private JTextField serviceu;
	private JTextField nationaliteu;
	private JTextField chef_hierachiqueu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administration frame = new Administration();
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
	public Administration() {
		JPanel conteneur = new JPanel();
	ConnexionServiceImpl cn= new ConnexionServiceImpl();
	SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 273, 955, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
getContentPane().setLayout(null);
contentPane.setLayout(null);
JLabel lblNewLabel = new JLabel("New label");
lblNewLabel.setIcon(new ImageIcon(Administration.class.getResource("/com/cgipag/ui/img/administration.jpg")));
lblNewLabel.setBounds(329, 84, 470, 109);
contentPane.add(lblNewLabel);
JButton btnNewButton = new JButton("Ajouter utilisateurs");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		panUtic.hide();
		panInscription.setVisible(true);
	}
});
btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
btnNewButton.setForeground(Color.RED);
btnNewButton.setBackground(Color.CYAN);
btnNewButton.setBounds(10, 22, 309, 37);
contentPane.add(btnNewButton);
JButton btnConnexionCouante = new JButton("Connexion Courante");
btnConnexionCouante.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		panInscription.hide();
		panUtic.setVisible(true);
	}
});
btnConnexionCouante.setForeground(Color.RED);
btnConnexionCouante.setFont(new Font("Times New Roman", Font.BOLD, 18));
btnConnexionCouante.setBackground(Color.CYAN);
btnConnexionCouante.setBounds(329, 22, 324, 37);
contentPane.add(btnConnexionCouante);
JButton btnModifierSupprimer = new JButton("Modifier & Supprimer");
btnModifierSupprimer.setFont(new Font("Times New Roman", Font.BOLD, 18));
btnModifierSupprimer.setForeground(Color.RED);
btnModifierSupprimer.setBackground(Color.CYAN);
btnModifierSupprimer.setBounds(663, 22, 270, 37);
contentPane.add(btnModifierSupprimer);
JPanel panel = new JPanel();
panel.setBackground(Color.BLUE);
panel.setForeground(Color.BLUE);
panel.setBounds(10, 0, 923, 21);
contentPane.add(panel);
JLabel lblNewLabel_2 = new JLabel("New label");
lblNewLabel_2.setIcon(new ImageIcon(Administration.class.getResource("/com/cgipag/ui/img/logo.png")));
lblNewLabel_2.setBounds(10, 76, 285, 124);
contentPane.add(lblNewLabel_2);



conteneur.setBounds(10, 211, 923, 513);
contentPane.add(conteneur);
conteneur.setLayout(null);

 panInscription = new JPanel();
 panInscription.setBounds(0, 63, 913, 439);
 conteneur.add(panInscription);
 panInscription.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
 panInscription.setVisible(false);
 panInscription.setLayout(null);
 JLabel lblEnregistrementDutilisateurs = new JLabel("Enregistrement d'utilisateurs");
 lblEnregistrementDutilisateurs.setForeground(Color.RED);
 lblEnregistrementDutilisateurs.setFont(new Font("Times New Roman", Font.BOLD, 18));
 lblEnregistrementDutilisateurs.setBounds(361, 11, 235, 22);
 panInscription.add(lblEnregistrementDutilisateurs);
 JLabel lblUsername = new JLabel("Username :");
 lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblUsername.setBounds(325, 100, 89, 14);
 panInscription.add(lblUsername);
 JLabel lblPassword = new JLabel("Password :");
 lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblPassword.setBounds(325, 132, 89, 14);
 panInscription.add(lblPassword);
 user = new JTextField();
 user.setBounds(436, 93, 160, 20);
 panInscription.add(user);
 user.setColumns(10);
 pass = new JTextField();
 pass.setColumns(10);
 pass.setBounds(436, 119, 160, 20);
 panInscription.add(pass);
 JLabel lblLevel = new JLabel("level :");
 lblLevel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblLevel.setBounds(325, 160, 89, 14);
 panInscription.add(lblLevel);
 level = new JTextField();
 level.setColumns(10);
 level.setBounds(436, 151, 160, 20);
 panInscription.add(level);
 JLabel lblDateInscriptionl = new JLabel("Date inscrit :");
 lblDateInscriptionl.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblDateInscriptionl.setBounds(325, 188, 89, 14);
 panInscription.add(lblDateInscriptionl);
 DateChooserCombo datee= new DateChooserCombo();
 datee.setBounds(441, 182, 155, 20);
 panInscription.add(datee);
 JButton btnNewButton_1 = new JButton("Enregistrer");
 btnNewButton_1.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
        String nom  = nomu.getText();
        String prenom= prenomu.getText();
 		String username=user.getText();
 		String password=pass.getText();
 		int niveau=Integer.parseInt(level.getText());
 		String contact1= contact1u.getText();
 		String contact2= contact2u.getText();
 		String dateEnreg= format.format(datee.getSelectedDate().getTime());
 		String ville=villeu.getText();
 		String quartier=quartieru.getText();
		String service= serviceu.getText();
		String adresse=adresseu.getText();
		String nationalite=nationaliteu.getText();
		String chef_hierachique=chef_hierachiqueu.getText();
 		System.out.println(dateEnreg);
 		
 			
 		Connexion conn= new Connexion(nom, prenom, username, password, niveau, contact1, contact2, dateEnreg, ville, quartier, adresse, service, chef_hierachique, nationalite);
 		
// 		Connexion conn= new Connexion(username, password, niveau, dateEnreg);
// 		cn.EnregistrerUtilisateurs(conn);
 		user.setText(" ");
 		pass.setText(" ");
 		level.setText(" ");
 		contact1u.setText(" ");
 		contact2u.setText(" ");
 		villeu.setText(" ");
 		quartieru.setText(" ");
 		serviceu.setText(" ");
 		adresseu.setText(" ");
 		nationaliteu.setText(" ");
 		chef_hierachiqueu.setText(" ");
 		nomu.setText(" ");
 		prenomu.setText(" ");
 	     }
 		
 });
 btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
 btnNewButton_1.setBounds(342, 371, 130, 36);
 panInscription.add(btnNewButton_1);
 JButton button = new JButton("Annuler");
 button.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		    dispose();
		    Dashboard d = new Dashboard();
		    d.setVisible(true);
		    
	}
});
 button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
 button.setBounds(636, 371, 130, 36);
 panInscription.add(button);
 JLabel lblNewLabel_1 = new JLabel("New label");
 lblNewLabel_1.setIcon(new ImageIcon(Administration.class.getResource("/com/cgipag/ui/img/membre.jpg")));
 lblNewLabel_1.setBounds(26, 23, 235, 249);
 panInscription.add(lblNewLabel_1);
 
 JLabel lblNom = new JLabel("Nom :");
 lblNom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblNom.setBounds(642, 96, 89, 14);
 panInscription.add(lblNom);
 
 JLabel lblPrenom = new JLabel("Prenom :");
 lblPrenom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblPrenom.setBounds(642, 122, 89, 14);
 panInscription.add(lblPrenom);
 
 JLabel lblContact = new JLabel("Contact 1 :");
 lblContact.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblContact.setBounds(642, 154, 89, 14);
 panInscription.add(lblContact);
 
 JLabel lblContact_1 = new JLabel("Contact 2 :");
 lblContact_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblContact_1.setBounds(642, 190, 89, 14);
 panInscription.add(lblContact_1);
 
 nomu = new JTextField();
 nomu.setColumns(10);
 nomu.setBounds(712, 93, 160, 20);
 panInscription.add(nomu);
 
 prenomu = new JTextField();
 prenomu.setColumns(10);
 prenomu.setBounds(712, 119, 160, 20);
 panInscription.add(prenomu);
 
 contact1u = new JTextField();
 contact1u.setColumns(10);
 contact1u.setBounds(712, 151, 160, 20);
 panInscription.add(contact1u);
 
 contact2u = new JTextField();
 contact2u.setColumns(10);
 contact2u.setBounds(712, 187, 160, 20);
 panInscription.add(contact2u);
 
 JLabel lblVille = new JLabel("Ville :");
 lblVille.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblVille.setBounds(325, 221, 89, 14);
 panInscription.add(lblVille);
 
 JLabel lblQuartier = new JLabel("Quartier :");
 lblQuartier.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblQuartier.setBounds(642, 223, 66, 14);
 panInscription.add(lblQuartier);
 
 quartieru = new JTextField();
 quartieru.setColumns(10);
 quartieru.setBounds(712, 215, 160, 20);
 panInscription.add(quartieru);
 
 villeu = new JTextField();
 villeu.setColumns(10);
 villeu.setBounds(436, 220, 160, 20);
 panInscription.add(villeu);
 
 JLabel lblAdresse = new JLabel("Adresse :");
 lblAdresse.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblAdresse.setBounds(325, 253, 89, 14);
 panInscription.add(lblAdresse);
 
 adresseu = new JTextField();
 adresseu.setColumns(10);
 adresseu.setBounds(436, 252, 160, 20);
 panInscription.add(adresseu);
 
 JLabel lblService = new JLabel("Service :");
 lblService.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblService.setBounds(642, 248, 66, 14);
 panInscription.add(lblService);
 
 serviceu = new JTextField();
 serviceu.setColumns(10);
 serviceu.setBounds(712, 248, 160, 20);
 panInscription.add(serviceu);
 
 JLabel lblNationalit = new JLabel("Nationalité :");
 lblNationalit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblNationalit.setBounds(325, 286, 89, 14);
 panInscription.add(lblNationalit);
 
 nationaliteu = new JTextField();
 nationaliteu.setColumns(10);
 nationaliteu.setBounds(436, 285, 160, 20);
 panInscription.add(nationaliteu);
 
 JLabel lblChefHierachique = new JLabel("Chef hierachique :");
 lblChefHierachique.setFont(new Font("Times New Roman", Font.PLAIN, 16));
 lblChefHierachique.setBounds(613, 286, 89, 14);
 panInscription.add(lblChefHierachique);
 
 chef_hierachiqueu = new JTextField();
 chef_hierachiqueu.setColumns(10);
 chef_hierachiqueu.setBounds(712, 280, 160, 20);
 panInscription.add(chef_hierachiqueu);
 
 panUtic = new JPanel();
 panUtic.setBounds(0, 21, 913, 311);
 conteneur.add(panUtic);
 panUtic.setVisible(false);
 panUtic.setLayout(null);
 JLabel conex_1 = new JLabel("Connexion Actuelle");
 conex_1.setBounds(361, 11, 172, 22);
 conex_1.setForeground(Color.RED);
 conex_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
 panUtic.add(conex_1);
 JScrollPane scrollPane = new JScrollPane();
 scrollPane.setBounds(126, 59, 684, 99);
 panUtic.add(scrollPane);
 table = new JTable();
 table.setModel(new DefaultTableModel(
 	new Object[][] {
 		{null, null, null},
 		{null, null, null},
 		{null, null, null},
 	},
 	new String[] {
 		"Nom", "Prenom", "Niveau"
 	}
 ));
 scrollPane.setViewportView(table);
 
 JButton btnDashboard = new JButton("Dashboard");
 btnDashboard.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent arg0) {
 		Dashboard d= new Dashboard();
 		dispose();
 		d.setVisible(true);
 	}
 });
 btnDashboard.setBackground(Color.GREEN);
 btnDashboard.setFont(new Font("Tahoma", Font.BOLD, 12));
 btnDashboard.setForeground(Color.BLACK);
 btnDashboard.setBounds(822, 98, 101, 23);
 contentPane.add(btnDashboard);
	}
}
