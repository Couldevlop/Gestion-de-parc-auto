package com.cgipa.domaine;

public class Utilisateurs {
	int id;
	String nom;
	String prenom;
	String tel;
	String cni;
	String positionnement;
	public String getPosisitionnement() {
		return positionnement;
	}

	public void setPosi(String positionnement) {
		this.positionnement = positionnement;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCni() {
		return cni;
	}
	public void setCni(String cni) {
		this.cni = cni;
	}

	public Utilisateurs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateurs(String nom, String prenom,String cni, String tel,  String positionnement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cni = cni;
		this.tel = tel;
		this.positionnement = positionnement;
	}

	public Utilisateurs(String prenom) {
		super();
		this.prenom = prenom;
	}

	
}
