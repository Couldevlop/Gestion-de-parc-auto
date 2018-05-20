package com.cgipa.service;

import com.cgipa.domaine.Services;
import com.cgipa.domaine.Site;
import com.cgipa.domaine.TypeVehicule;

public interface ITypevehicule {
	public int getIdTypevehicule();
	public TypeVehicule AjouterTypevehicule( TypeVehicule t);
	public void ConsulterTypevehicule();
	public void SupprimerTypevehicule();
}
