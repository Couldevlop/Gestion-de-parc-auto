package com.cgipa.domaine;

public class Fournisseur {
	int idfournisseur;
	String nom;
	String raisonSociale;
	String pays;
	String ville;
	String tel;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getIdfournisseur() {
		return idfournisseur;
	}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(String nom, String raisonSociale, String pays, String ville, String tel) {
		super();
		this.nom = nom;
		this.raisonSociale = raisonSociale;
		this.pays = pays;
		this.ville = ville;
		this.tel = tel;
	}

}
