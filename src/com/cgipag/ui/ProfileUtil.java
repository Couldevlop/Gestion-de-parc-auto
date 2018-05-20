package com.cgipag.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileUtil extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileUtil frame = new ProfileUtil();
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
	public ProfileUtil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ProfileUtil.class.getResource("/com/cgipag/ui/img/profile.jpg")));
		lblNewLabel.setBounds(706, 0, 225, 168);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ProfileUtil.class.getResource("/com/cgipag/ui/img/logo.png")));
		lblNewLabel_1.setBounds(20, 11, 282, 130);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 172, 974, 22);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 15, 712);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(939, 0, 15, 712);
		contentPane.add(panel_2);
		
		JLabel lblLaTechnologieAu = new JLabel("La technologie au service de l'avenir");
		lblLaTechnologieAu.setForeground(Color.BLUE);
		lblLaTechnologieAu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLaTechnologieAu.setBounds(35, 141, 300, 14);
		contentPane.add(lblLaTechnologieAu);
		
		JLabel lblInformationsPersonnellesDe = new JLabel("Informations personnelles de l'utilisateur");
		lblInformationsPersonnellesDe.setForeground(Color.RED);
		lblInformationsPersonnellesDe.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 25));
		lblInformationsPersonnellesDe.setBounds(271, 225, 452, 45);
		contentPane.add(lblInformationsPersonnellesDe);
		
		JLabel lblNomUtilisateur = new JLabel("Nom utilisateur :");
		lblNomUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNomUtilisateur.setBounds(116, 340, 126, 14);
		contentPane.add(lblNomUtilisateur);
		
		JLabel lblPrnomUtilisateur = new JLabel("Prénom utilisateur :");
		lblPrnomUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPrnomUtilisateur.setBounds(116, 386, 149, 14);
		contentPane.add(lblPrnomUtilisateur);
		
		JLabel lblLoginUtilisateur = new JLabel("Login utilisateur :");
		lblLoginUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblLoginUtilisateur.setBounds(116, 428, 126, 14);
		contentPane.add(lblLoginUtilisateur);
		
		JLabel lblPasswordUtilisateur = new JLabel("Password utilisateur :");
		lblPasswordUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPasswordUtilisateur.setBounds(116, 470, 149, 14);
		contentPane.add(lblPasswordUtilisateur);
		
		JLabel lblContactUtilisateur = new JLabel("Contact 1 utilisateur :");
		lblContactUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblContactUtilisateur.setBounds(110, 512, 155, 14);
		contentPane.add(lblContactUtilisateur);
		
		JLabel lblContactUtilisateur_1 = new JLabel("Contact 2 utilisateur :");
		lblContactUtilisateur_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblContactUtilisateur_1.setBounds(110, 551, 155, 14);
		contentPane.add(lblContactUtilisateur_1);
		
		textField = new JTextField();
		textField.setBounds(292, 334, 203, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(294, 380, 203, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(294, 422, 203, 30);
		contentPane.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(294, 506, 203, 30);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(294, 545, 203, 30);
		contentPane.add(textField_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(294, 463, 201, 32);
		contentPane.add(passwordField);
		
		JLabel lblVilleUtilisateur = new JLabel("Ville utilisateur :");
		lblVilleUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblVilleUtilisateur.setBounds(544, 342, 126, 14);
		contentPane.add(lblVilleUtilisateur);
		
		JLabel lblQuartierUtilisateur = new JLabel("Quartier utilisateur :");
		lblQuartierUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblQuartierUtilisateur.setBounds(544, 388, 139, 14);
		contentPane.add(lblQuartierUtilisateur);
		
		JLabel lblAdresseUtilisateur = new JLabel("Adresse utilisateur :");
		lblAdresseUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAdresseUtilisateur.setBounds(544, 430, 139, 14);
		contentPane.add(lblAdresseUtilisateur);
		
		JLabel lblServiceUtilisateur = new JLabel("Service utilisateur :");
		lblServiceUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblServiceUtilisateur.setBounds(544, 472, 139, 14);
		contentPane.add(lblServiceUtilisateur);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(692, 339, 203, 30);
		contentPane.add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(692, 385, 203, 30);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(693, 427, 203, 30);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(693, 469, 203, 30);
		contentPane.add(textField_8);
		
		JLabel lblChefHierachique = new JLabel("Chef hierachique:");
		lblChefHierachique.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblChefHierachique.setBounds(544, 514, 139, 14);
		contentPane.add(lblChefHierachique);
		
		JLabel lblNationalitUtilisateur = new JLabel("Nationnalité :");
		lblNationalitUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNationalitUtilisateur.setBounds(558, 551, 99, 14);
		contentPane.add(lblNationalitUtilisateur);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(692, 511, 203, 30);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(692, 550, 203, 30);
		contentPane.add(textField_10);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dashboard d= new Dashboard();
				dispose();
				d.setVisible(true);
			}
		});
		btnDashboard.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDashboard.setBackground(Color.CYAN);
		btnDashboard.setBounds(830, 205, 101, 30);
		contentPane.add(btnDashboard);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(-20, 690, 974, 22);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLUE);
		panel_4.setBounds(277, 259, 446, 4);
		contentPane.add(panel_4);
	}
}
