package com.cgipa.domaine;

import java.io.Serializable;

import javax.swing.JTextField;

public class Connexion implements Serializable{
	private String contact1;
	private String contact2;
	private String dateEnreg;
	private String ville;
	private String quartier;
	private String adresse;
	private String service;
	private String chef_hierachique;
	private String nationalite;
private String nom;
private String prenom;
private String username;
private String password;
private int level;
public Connexion(String nom, String prenom, String username, String password, int level2, String contact1,
		String contact2, String dateEnreg, String ville, String quartier, String adresse, String service,
		String chef_hierachique, String nationalite) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.username = username;
	this.password = password;
	this.level = level2;
	this.contact1 = contact1;
	this.contact2 = contact2;
	this.dateEnreg = dateEnreg;
	this.ville = ville;
	this.quartier = quartier;
	this.adresse = adresse;
	this.service = service;
	this.chef_hierachique = chef_hierachique;
	this.nationalite = nationalite;
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
public String getContact1() {
	return contact1;
}
public void setContact1(String contact1) {
	this.contact1 = contact1;
}
public String getContact2() {
	return contact2;
}
public void setContact2(String contact2) {
	this.contact2 = contact2;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public String getQuartier() {
	return quartier;
}
public void setQuartier(String quartier) {
	this.quartier = quartier;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getService() {
	return service;
}
public void setService(String service) {
	this.service = service;
}
public String getChef_hierachique() {
	return chef_hierachique;
}
public void setChef_hierachique(String chef_hierachique) {
	this.chef_hierachique = chef_hierachique;
}
public String getNationalite() {
	return nationalite;
}
public void setNationalité(String nationalite) {
	this.nationalite = nationalite;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public String getDateEnreg() {
	return dateEnreg;
}
public void setDateEnreg(String dateEnreg) {
	this.dateEnreg = dateEnreg;
}
public Connexion(String username, String password, int level, String dateEnreg) {
	super();
	this.username = username;
	this.password = password;
	this.level = level;
	this.dateEnreg = dateEnreg;
}

}
