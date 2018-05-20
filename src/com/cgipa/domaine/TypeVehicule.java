package com.cgipa.domaine;

import java.util.Date;

import javax.swing.JLabel;

import datechooser.beans.DateChooserCombo;

public class TypeVehicule {
	private int idtypevehicule;
   public int getIdtypevehicule() {
		return idtypevehicule;
	}
	public void setIdtypevehicule(int idtypevehicule) {
		this.idtypevehicule = idtypevehicule;
	}
private String nomtype;
   public String getNomtype() {
	return nomtype;
}
public void setNomtype(String nomtype) {
	this.nomtype = nomtype;
}
public String getLibelee() {
	return libelee;
}
public void setLibelee(String libelee) {
	this.libelee = libelee;
}
private String libelee;
public TypeVehicule(int portiere, String puissance, String model, String marque, String cartegrise, String immat1, String foto, String dateAquisition, String datedebutassu, DateChooserCombo datefinassur, String debutrepar, String finrepar, double coutderepar) {
	super();
	// TODO Auto-generated constructor stub
}
public TypeVehicule(int portiere2, String puissance, String model2, String marque2, String cartegrise2, JLabel immat,
		String string, String string2, String string3, String string4, String string5, double d) {


}
public TypeVehicule(int portiere, String puissance, String model, String marque, String cartegrise, String immat,
		Date dateaquisition, Date debutassur, Date finassur, Date debutrepar, Date finrepar, float coutrepar) {
	
	
}



public TypeVehicule(int portiere, String puissance, String model, String marque, String cartegrise, String immat,
		Date dateaquisition, Date debutassur, Date finassur, Date debutrepar, Date finrepar, float coutrepar,
		String nomtype, String libelee) {

	this.nomtype = nomtype;
	this.libelee = libelee;
}
public TypeVehicule(int i, String string, String string2, String string3, String string4, String string5, int j, int k,
		int l, int m, int n, double d) {
	// TODO Auto-generated constructor stub
}
   
}
