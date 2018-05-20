package com.cgipa.service;

import com.cgipa.domaine.Categorie;
import com.cgipa.domaine.Site;

public interface ICategorie {
	public int getIdCategorie();
	public Categorie AjouterCategorie(Site s);
	public void ConsulterCategorie();
}
