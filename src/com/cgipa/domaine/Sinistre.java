package com.cgipa.domaine;

public class Sinistre {
	private int idsinistre;
	private String lieu;
	private String datesin;
	private String degatmat;
	private String degatcor;
	private int nbdeces;
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getDatesin() {
		return datesin;
	}
	public void setDatesin(String datesin) {
		this.datesin = datesin;
	}
	public String getDegatmat() {
		return degatmat;
	}
	public void setDegatmat(String degatmat) {
		this.degatmat = degatmat;
	}
	public String getDegatcor() {
		return degatcor;
	}
	public void setDegatcor(String degatcor) {
		this.degatcor = degatcor;
	}
	public int getNbdeces() {
		return nbdeces;
	}
	public void setNbdeces(int nbdeces) {
		this.nbdeces = nbdeces;
	}
	public int getIdsinistre() {
		return idsinistre;
	}
	public Sinistre(String lieu, String datesin, String degatmat, String degatcor, int deces) {
		super();
		this.lieu = lieu;
		this.datesin = datesin;
		this.degatmat = degatmat;
		this.degatcor = degatcor;
		this.nbdeces = deces;
	}
	
	

}
