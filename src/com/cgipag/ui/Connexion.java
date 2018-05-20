package com.cgipag.ui;

import java.awt.BorderLayout;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.cgipa.DAO.Singleton;
import com.cgipa.service.Impl.UtilisateursServiceImpl;

import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Connexion extends JFrame implements Serializable {

	private JPanel contentPane;
	private JTextField txt_use;
	public static String user;
	public static String pwd;
	public static int niveau;
	public static String username;
	private String password;
	Connection cnx;
	private JPasswordField txt_pass;
	private int nb;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Connexion frame = new Connexion();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */

	public Connexion() {
		cnx = Singleton.ObtenirConnectionDB();
		UtilisateursServiceImpl util = new UtilisateursServiceImpl();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(0, 11, 887, 570);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(142, 117, 620, 375);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Connexion.class.getResource("/com/cgipag/ui/img/cle.png")));
		label.setBounds(10, 26, 242, 242);
		panel_1.add(label);

		JLabel label_1 = new JLabel("Password :");
		label_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		label_1.setBounds(295, 133, 108, 26);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("Username :");
		label_2.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		label_2.setBounds(295, 86, 108, 26);
		panel_1.add(label_2);

		txt_use = new JTextField();
		txt_use.setColumns(10);
		txt_use.setBounds(443, 87, 150, 26);
		panel_1.add(txt_use);

		// ---------------le bouton d'erreur------------------------

		JLabel lbError = new JLabel("");
		lbError.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbError.setForeground(Color.RED);
		lbError.setBounds(10, 290, 600, 74);
		panel_1.add(lbError);

		JButton btnlog = new JButton("Login");
		btnlog.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				// verification des données saisies par l'utilisateur
				user = txt_use.getText();
				pwd = txt_pass.getText();
				System.out.println(user);
				System.out.println(pwd);

				if (user.isEmpty() && pwd.isEmpty()) {
					lbError.setText(" Désolé !!! Le formulaire set vide, veuillez le remplir SVP");
					lbError.setVisible(true);

				} else {

					// -------------CRIPTAGE DU MOT DU PASSE--------------------
					MessageDigest md = null;
					try {
						md = MessageDigest.getInstance("MD5");
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					md.update(pwd.getBytes());
					byte[] md5 = md.digest();
					// --------------------------------------------------------------------------------

					if (cnx != null) {
						// ResultSet rs=null;
						try {
							String req = "select  *  FROM  login    where  username = ?  AND  password= ?";
							PreparedStatement ps = cnx.prepareStatement(req);
							ps.setString(1, user);
							ps.setString(2, pwd);
							ResultSet rs = ps.executeQuery();
							if (rs.next()) {
								username = rs.getString("username");
								password = rs.getString("password");
								niveau = rs.getInt("niveau");

								if (user.equals(username) && pwd.equals(password)) {
									if (niveau == 2) {
										util.Archivage();
										dispose();
										Dashboard d = new Dashboard();
										d.setVisible(true);
									} else if (niveau == 1) {
										util.Archivage();
										dispose();
										Dashboard d = new Dashboard();
										d.setVisible(true);
									}

								} else {
									lbError.setText(
											" Désolé !!!  Soit votre login ou votre mot de passe n'est pas correcte.");
								}

							} else
								lbError.setText(
										" Désolé !!!  Soit votre login ou votre mot de passe n'est pas correcte.");

						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, " Désolé mais la requette ne s'est pas exceuté");
							e.printStackTrace();
						}

					}

				}

			}
		});

		btnlog.setFont(new Font("Sylfaen", Font.BOLD, 18));
		btnlog.setForeground(new Color(0, 0, 0));
		btnlog.setBounds(279, 223, 150, 48);
		panel_1.add(btnlog);

		JButton btn_reset = new JButton("Reset");
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btn_reset.setForeground(Color.BLACK);
		btn_reset.setFont(new Font("Sylfaen", Font.BOLD, 18));
		btn_reset.setBounds(443, 223, 150, 48);
		panel_1.add(btn_reset);

		txt_pass = new JPasswordField();
		txt_pass.setBounds(445, 137, 148, 26);
		panel_1.add(txt_pass);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Connexion.class.getResource("/com/cgipag/ui/img/log.png")));
		lblNewLabel.setBounds(320, 28, 300, 63);
		panel.add(lblNewLabel);

		JLabel lblCOpyrithBy = new JLabel(
				"                                                                                          Copyrith@ by Coulibaly Waopron Thomas: Ingeneer for computer sciences");
		lblCOpyrithBy.setForeground(Color.BLACK);
		lblCOpyrithBy.setBackground(Color.BLACK);
		lblCOpyrithBy.setBounds(10, 584, 877, 25);
		contentPane.add(lblCOpyrithBy);
	}
}
