package com.cgipa.domaine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;



public  class Contrat {
	String datedebut;
	String datefin;
	float coutcontrat;
	private List <Fournisseur> listFournisseur = new ArrayList<Fournisseur>();
	
	public List<Fournisseur> getListFournisseur() {
		return listFournisseur;
	}
	public void setListFournisseur(List<Fournisseur> listFournisseur) {
		this.listFournisseur = listFournisseur;
	}
	public String getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}
	public String getDatefin() {
		return datefin;
	}
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	public float getCoutcontrat() {
		return coutcontrat;
	}
	public void setCoutcontrat(float coutcontrat) {
		this.coutcontrat = coutcontrat;
	}
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contrat(String datedebut2, String datefin2, float montant) {
		super();
		this.datedebut = datedebut2;
		this.datefin = datefin2;
		this.coutcontrat = montant;
	}

}
