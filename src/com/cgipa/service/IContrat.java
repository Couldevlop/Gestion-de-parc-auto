package com.cgipa.service;

import java.sql.ResultSet;

import com.cgipa.domaine.Contrat;

public interface IContrat {

	public int getIdContrat();
	public void Ajoutercontrat(Contrat c);
	public ResultSet ListerContrat();
}
