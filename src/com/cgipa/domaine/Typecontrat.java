package com.cgipa.domaine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Typecontrat {
	int id;
	String libellee;
//	private private List <Contrat> listContrat = new ArrayList<Contrat>();
	public String getLibellee() {
		return libellee;
	}
	public void setLibellee(String libellee) {
		this.libellee = libellee;
	}
	public int getId() {
		return id;
	}
	public Typecontrat(String libellee) {
		super();
		this.libellee = libellee;
	}
	public Typecontrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Typecontrat(String datedebutcontrat, String datefincontrat, float montant, String libellee) {
		this.libellee = libellee;
	}
	
}
