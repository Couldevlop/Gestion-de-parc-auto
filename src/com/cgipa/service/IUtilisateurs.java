package com.cgipa.service;

import java.sql.ResultSet;

import com.cgipa.domaine.Utilisateurs;

public interface IUtilisateurs {
public Utilisateurs consulterUtilisateurs();
public void AjouterUtilisateurs(Utilisateurs u);
public int getIdUtilisateurs();
public void rechercherUtilisateurs();

}
