package com.cgipa.domaine;

import java.util.Date;

import datechooser.beans.DateChooserCombo;
import java.text.SimpleDateFormat;

public  class  Vehicule {
	int idvehicule;
	int portiere;
	String puissance;
	String model;
	int places;
	String marque;
	String cartegrise;
	String immat;
	String foto;
	String dateAquisition;
	String debutassur;
	String finassur;
	float coutassurance;
	String datedebutreparation;
	String datefinreparation;
	float coutderepar;
	public int getIdvehicule() {
		return idvehicule;
	}
	public void setIdvehicule(int idvehicule) {
		this.idvehicule = idvehicule;
	}
	public int getPortiere() {
		return portiere;
	}
	public void setPortiere(int portiere) {
		this.portiere = portiere;
	}
	public String getPuissance() {
		return puissance;
	}
	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPlaces() {
		return places;
	}
	public void setPlaces(int places) {
		this.places = places;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getCartegrise() {
		return cartegrise;
	}
	public void setCartegrise(String cartegrise) {
		this.cartegrise = cartegrise;
	}
	public String getImmat() {
		return immat;
	}
	public void setImmat(String immat) {
		this.immat = immat;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getDateAquisition() {
		return dateAquisition;
	}
	public void setDateAquisition(String dateAquisition) {
		this.dateAquisition = dateAquisition;
	}
	public String getDebutassur() {
		return debutassur;
	}
	public void setDebutassur(String debutassur) {
		this.debutassur = debutassur;
	}
	public String getFinassur() {
		return finassur;
	}
	public void setFinassur(String finassur) {
		this.finassur = finassur;
	}
	public float getCoutassurance() {
		return coutassurance;
	}
	public void setCoutassurance(float coutassurance) {
		this.coutassurance = coutassurance;
	}
	public String getDatedebutreparation() {
		return datedebutreparation;
	}
	public void setDatedebutreparation(String datedebutreparation) {
		this.datedebutreparation = datedebutreparation;
	}
	public String getDatefinreparation() {
		return datefinreparation;
	}
	public void setDatefinreparation(String datefinreparation) {
		this.datefinreparation = datefinreparation;
	}
	public float getCoutreparation() {
		return coutderepar;
	}
	public void setCoutreparation(float coutreparation) {
		this.coutderepar = coutreparation;
	}
	
	public Vehicule(int portiere, String puissance, String model, int places, String marque, String cartegrise,
			String immat, String foto, String dateAquisition2, String debutassur2, String finassur2, float coutassurance,
			String datedebutreparation2, String datefinreparation2, float coutderepar) {
		super();
		this.portiere = portiere;
		this.puissance = puissance;
		this.model = model;
		this.places = places;
		this.marque = marque;
		this.cartegrise = cartegrise;
		this.immat = immat;
		this.foto = foto;
		this.dateAquisition = dateAquisition2;
		this.debutassur = debutassur2;
		this.finassur = finassur2;
		this.coutassurance = coutassurance;
		this.datedebutreparation = datedebutreparation2;
		this.datefinreparation = datefinreparation2;
		this.coutderepar = coutderepar;
	}
	
	

}
