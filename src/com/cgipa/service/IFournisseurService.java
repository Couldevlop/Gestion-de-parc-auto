package com.cgipa.service;

import java.sql.ResultSet;

import com.cgipa.domaine.Fournisseur;

public interface IFournisseurService {
	public void ConsulterFournisseurs();
	public void AjouterFour(Fournisseur f);
	public void  RechercherFournisseur();
	public int getIdFournisseur();

	

}
