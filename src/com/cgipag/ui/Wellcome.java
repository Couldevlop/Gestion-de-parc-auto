package com.cgipag.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wellcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wellcome frame = new Wellcome();
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
	public Wellcome() {
		setResizable(false);
		setTitle("Wellcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panwel = new JPanel();
		panwel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panwel.setBounds(0, 0, 802, 538);
		panwel.setBackground(new Color(65, 105, 225));
		contentPane.add(panwel);
		panwel.setLayout(null);
		
		JButton btnwel = new JButton("Click here to enter  in the  application");
		btnwel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Connexion  cn= new Connexion();
				cn.setVisible(true);
				
			}
		});
		btnwel.setForeground(new Color(255, 69, 0));
		btnwel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 21));
		btnwel.setBounds(189, 177, 410, 67);
		panwel.add(btnwel);
		
		JLabel lblNewLabel = new JLabel("                         Wellcome to CGIPA application");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(86, 74, 602, 34);
		panwel.add(lblNewLabel);
		
		JLabel lbfoot = new JLabel("                                                                      Copyrith@ by Coulibaly Waopron Thomas: Ingeneer for computer sciences");
		lbfoot.setForeground(new Color(0, 0, 0));
		lbfoot.setBackground(new Color(0, 0, 0));
		lbfoot.setBounds(0, 538, 802, 25);
		contentPane.add(lbfoot);
	}
}
