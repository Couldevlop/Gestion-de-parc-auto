package com.cgipa.domaine;

public class Services {
	private int idservice;
	private String libelle;
	private String chefService;
	public int getIdservice() {
		return idservice;
	}
	public void setIdservice(int idservice) {
		this.idservice = idservice;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getChefService() {
		return chefService;
	}
	public void setChefService(String chefService) {
		this.chefService = chefService;
	}
	public Services() {
		super();
	}
	public Services(String libelle, String chefService) {
		super();
		this.libelle = libelle;
		this.chefService = chefService;
	}

}
