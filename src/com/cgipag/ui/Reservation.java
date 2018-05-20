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

import com.mysql.jdbc.Util;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reservation extends JFrame {

	private JPanel contentPane;
	private int ni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
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
	public Reservation() {
		ProfileUtil p= new ProfileUtil ();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1337, 817);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(17, 3, 1286, 156);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Reservation.class.getResource("/com/cgipag/ui/img/logo.png")));
		label.setBounds(10, 0, 300, 156);
		panel.add(label);
		
		JLabel lblGestionDeReservations = new JLabel("Gestion de Reservations");
		lblGestionDeReservations.setFont(new Font("Times New Roman", Font.BOLD, 41));
		lblGestionDeReservations.setBounds(568, 11, 462, 53);
		panel.add(lblGestionDeReservations);
		
		JButton btnListerLes = new JButton("--- Lister les reservations ---");
		btnListerLes.setBounds(551, 111, 216, 34);
		panel.add(btnListerLes);
		
		JButton btnAjouterUne = new JButton("--- Ajouter une reservation ---");
		btnAjouterUne.setBounds(797, 111, 199, 34);
		panel.add(btnAjouterUne);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(-23, 159, 1338, 16);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(18, 183, 279, 534);
		contentPane.add(panel_2);
		
		JLabel label_2 = new JLabel("     " + Connexion.username);
		label_2.setFont(new Font("Vijaya", Font.BOLD, 17));
		label_2.setBounds(22, 11, 235, 26);
		panel_2.add(label_2);
		
		JButton vehicules = new JButton("VEHICULES");
		vehicules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Vehicule v= new Vehicule();
				v.setVisible(true);
			}
		});
		vehicules.setBounds(0, 78, 279, 47);
		panel_2.add(vehicules);
		
		JButton utilisateurs = new JButton("UTILISATEURS");
		vehicules.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Utilisateurs u = new Utilisateurs();
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
				Fournisseurs f = new Fournisseurs();
				f.setVisible(true);
				
			}
		});
		fournisseurs.setBounds(0, 194, 279, 47);
		panel_2.add(fournisseurs);
		
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
		panel_2.add(contrats);
		
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
		panel_2.add(sinistres);
		
		JButton reservation = new JButton("RESERVATION");
//		reservation.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				Reservation  r = new Reservation();
//				r.setVisible(true);
//			}
//		});
		
		
		reservation.setBounds(0, 369, 279, 47);
		panel_2.add(reservation);
		
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
		panel_3.setLayout(null);
		panel_3.setBounds(307, 181, 996, 541);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLUE);
		panel_4.setBounds(-9, -176, 22, 932);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLUE);
		panel_5.setBounds(-9, 725, 1493, 58);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLUE);
		panel_6.setBounds(1309, -99, 16, 882);
		contentPane.add(panel_6);
	}

}
