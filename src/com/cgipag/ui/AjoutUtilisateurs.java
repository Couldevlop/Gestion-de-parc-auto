package com.cgipag.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import com.cgipa.domaine.Utilisateurs;
import com.cgipa.service.Impl.UtilisateursServiceImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AjoutUtilisateurs extends JPanel {
	private JTextField txt_nom;
	private JTextField txt_prenom;
	private JTextField txt_tel;
	private JTextField txt_cni;
	private JComboBox cb_posi ;

	/**
	 * Create the panel.
	 */
	public AjoutUtilisateurs() {
		setLayout(null);
		
		JLabel lblAjoutDunUtilisateur = new JLabel("Ajout dun utilisateur");
		lblAjoutDunUtilisateur.setForeground(Color.RED);
		lblAjoutDunUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAjoutDunUtilisateur.setBounds(314, 11, 191, 14);
		add(lblAjoutDunUtilisateur);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(244, 92, 46, 14);
		add(lblNom);
		
		JLabel lblPrnom = new JLabel("Prénom :");
		lblPrnom.setBounds(244, 117, 46, 14);
		add(lblPrnom);
		
		JLabel lblTlphone = new JLabel("Téléphone :");
		lblTlphone.setBounds(244, 142, 78, 14);
		add(lblTlphone);
		
		JLabel lblCni = new JLabel("C.N.I :");
		lblCni.setBounds(244, 167, 46, 14);
		add(lblCni);
		
		JLabel lblPositionnement = new JLabel("Positionnement :");
		lblPositionnement.setBounds(244, 192, 98, 14);
		add(lblPositionnement);
		
		txt_nom = new JTextField();
		txt_nom.setBounds(361, 89, 156, 20);
		add(txt_nom);
		txt_nom.setColumns(10);
		
		txt_prenom = new JTextField();
		txt_prenom.setColumns(10);
		txt_prenom.setBounds(361, 114, 156, 20);
		add(txt_prenom);
		
		txt_tel = new JTextField();
		txt_tel.setColumns(10);
		txt_tel.setBounds(361, 139, 156, 20);
		add(txt_tel);
		
		txt_cni = new JTextField();
		txt_cni.setColumns(10);
		txt_cni.setBounds(361, 164, 156, 20);
		add(txt_cni);
		
		 cb_posi = new JComboBox();
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//--------------------------------recuperation des elements du formulares---------------------------
				String nom=txt_nom.getText();
				String prenom=txt_prenom.getText();
				String tel=txt_tel.getText();
				String cni=txt_cni.getText();
				String posi=cb_posi.getSelectedItem().toString();
				
				//------------------------------appel à la couche service------------------------------
				Utilisateurs uti =new Utilisateurs(nom, prenom, cni, tel,  posi);
				
				
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnValider.setBounds(251, 250, 89, 39);
		add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnnuler.setBounds(405, 250, 89, 39);
		add(btnAnnuler);
		
		 cb_posi = new JComboBox();
		cb_posi.setModel(new DefaultComboBoxModel(new String[] {"                   Interne", "                    Intervenant"}));
		cb_posi.setBounds(361, 195, 156, 20);
		add(cb_posi);

	}
}
