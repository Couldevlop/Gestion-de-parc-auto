package com.cgipag.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.cgipa.service.Impl.FournisseurServiceImpl;
import com.cgipa.service.Impl.SinistreServiceImpl;
import com.cgipa.service.Impl.UtilisateursServiceImpl;
import com.cgipa.service.Impl.VehiculeServiceImpl;
import com.orsoncharts.plot.CategoryPlot3D;

import net.proteanit.sql.DbUtils;

import java.awt.ScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class StatGenerale extends JPanel {
	private JTable vehicules;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable utilisateur;
	private JTable table_3;
	private JTable fournisseur;

	/**
	 * Create the panel.
	 */
	public StatGenerale() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Statistique d'ordre générale");
		lblNewLabel.setFont(new Font("Vladimir Script", Font.BOLD, 38));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(279, 22, 437, 47);
		add(lblNewLabel);
		
		JLabel lblVehicules = new JLabel("VEHICULES");
		lblVehicules.setForeground(Color.BLUE);
		lblVehicules.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVehicules.setBounds(10, 76, 83, 14);
		add(lblVehicules);
		
		JLabel lblUtilisateurs = new JLabel("UTILISATEURS");
		lblUtilisateurs.setForeground(Color.BLUE);
		lblUtilisateurs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUtilisateurs.setBounds(10, 434, 118, 14);
		add(lblUtilisateurs);
		
		JLabel lblFournisseurs = new JLabel("FOURNISSEURS");
		lblFournisseurs.setForeground(Color.BLUE);
		lblFournisseurs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFournisseurs.setBounds(502, 434, 118, 14);
		add(lblFournisseurs);
		
		JLabel lblSinistres = new JLabel("SINISTRES");
		lblSinistres.setForeground(Color.BLUE);
		lblSinistres.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSinistres.setBounds(10, 253, 118, 14);
		add(lblSinistres);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setForeground(Color.BLUE);
		panel.setBounds(260, 80, 443, 10);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setForeground(Color.BLUE);
		panel_1.setBounds(260, 11, 10, 79);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(260, 11, 443, 10);
		add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(697, 11, 10, 79);
		add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLUE);
		panel_4.setBounds(10, 232, 949, 10);
		add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLUE);
		panel_5.setBounds(10, 413, 949, 10);
		add(panel_5);
		
		JScrollPane sinistre = new JScrollPane();
		sinistre.setBounds(10, 273, 808, 129);
		add(sinistre);
		
		table = new JTable();
		RemplirTabeauStatSinistre();
		sinistre.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 802, 120);
		add(scrollPane);
		
		table_1 = new JTable();
		RemplirStatVehicule();
		scrollPane.setViewportView(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 459, 447, 106);
		add(scrollPane_1);
		
		utilisateur = new JTable();
		RemplirStatUtil();
		scrollPane_1.setViewportView(utilisateur);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(510, 459, 449, 106);
		add(scrollPane_2);
		
		fournisseur = new JTable();
		RemplirStatfournisseur();
		scrollPane_2.setViewportView(fournisseur);
		
		JButton btnGraphique = new JButton("Graphique");
		btnGraphique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultCategoryDataset   dataset= new DefaultCategoryDataset();
				ResultSet result = null;
				VehiculeServiceImpl v = new VehiculeServiceImpl();
				result=v.RemplirTabstatVeh();
				dataset.setValue(250, "Vehicule", "PEUGEOT");
				dataset.setValue(320, "Vehicule", "HONDA");
				dataset.setValue(280, "Vehicule", "YOUDAI");
				dataset.setValue(270, "Vehicule", "MAZDA");
				dataset.setValue(180, "Vehicule", "BMW");
				JFreeChart  chart = ChartFactory.createBarChart3D("Statistique des vehicules", "Marque", "Killometrage", dataset, PlotOrientation.VERTICAL, false, false, false);
				CategoryPlot p= chart.getCategoryPlot();
				p.setRangeGridlinePaint(Color.BLACK);
				ChartFrame frame = new ChartFrame("Graphique de Statistique des vehicules", chart);
	            frame.setVisible(true);
	            frame.setSize(550, 550);
			}
			
		});
		btnGraphique.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnGraphique.setBounds(841, 130, 111, 29);
		add(btnGraphique);
		
		JButton button = new JButton("Graphique");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DefaultCategoryDataset   dataset= new DefaultCategoryDataset();
				ResultSet result = null;
				VehiculeServiceImpl v = new VehiculeServiceImpl();
				result=v.RemplirTabstatVeh();
				dataset.setValue(20, "Sinistre", "BRAS FRACTURE");
				dataset.setValue(30, "Sinistre", "DECES");
				dataset.setValue(16, "Sinistre", "RAS");
				dataset.setValue(15, "Sinistre", "PIED FRACTURE");
				dataset.setValue(10, "Sinistre", "RAS");
				JFreeChart  chart = ChartFactory.createBarChart3D("Statistique des Sinitres", "cas de sinistre", "Nombre de sinistre", dataset, PlotOrientation.VERTICAL, false, false, false);
				CategoryPlot p= chart.getCategoryPlot();
				chart.getTitle().setPaint(Color.RED);
				p.setRangeGridlinePaint(Color.GREEN);
				chart.setBackgroundPaint(Color.YELLOW);
				ChartFrame frame = new ChartFrame("Graphique de Statistique des sinistres", chart);
	            frame.setVisible(true);
	            frame.setSize(550, 550);
			}
		});
		button.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		button.setBounds(848, 315, 111, 29);
		add(button);
		
		
	}

	//------------STAT DE SINISTRE-------------------------
	public void RemplirTabeauStatSinistre()
	{
		ResultSet r=null;
	SinistreServiceImpl s =new SinistreServiceImpl();
	r=s.RemplirTabstatSin();
	table.setModel(DbUtils.resultSetToTableModel(r));
	}	
	
	
//----------------STAT DE VEHICULE-------------------------	
	public void RemplirStatVehicule()
	{
		ResultSet result = null;
		VehiculeServiceImpl v = new VehiculeServiceImpl();
		result=v.RemplirTabstatVeh();
		table_1.setModel(DbUtils.resultSetToTableModel(result));
	}
	
	
	//-----------------STAT D'UTILISATEUR--------------------
	public void RemplirStatUtil()
	{
		ResultSet rt= null;
		UtilisateursServiceImpl u = new UtilisateursServiceImpl();
		rt=u.RemplirTabstatUtilisateur();
		utilisateur.setModel(DbUtils.resultSetToTableModel(rt));
	}
	
	
	//------------------STAT DE FOURNISSEURS-----------------
	
	public void RemplirStatfournisseur()
	{
		ResultSet rst= null;
		FournisseurServiceImpl f= new FournisseurServiceImpl();
		rst=f.RemplirTabstatFour();
		fournisseur.setModel(DbUtils.resultSetToTableModel(rst));
	}
}

