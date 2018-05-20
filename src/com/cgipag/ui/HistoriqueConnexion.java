package com.cgipag.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class HistoriqueConnexion extends JPanel {

	/**
	 * Create the panel.
	 */
	public HistoriqueConnexion() {
		setBounds(350, 120, 970, 664);
		setLayout(null);
		
		JLabel lblHistoriqueDesConnexions = new JLabel("HISTORIQUE DES CONNEXIONS");
		lblHistoriqueDesConnexions.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblHistoriqueDesConnexions.setBounds(372, 11, 321, 23);
		add(lblHistoriqueDesConnexions);

	}
}
