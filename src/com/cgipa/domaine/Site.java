package com.cgipa.domaine;

public class Site {
	private int idsite;
private String emplacement;
public int getIdsite() {
	return idsite;
}
public void setIdsite(int idsite) {
	this.idsite = idsite;
}
public String getEmplacement() {
	return emplacement;
}
public void setEmplacement(String emplacement) {
	this.emplacement = emplacement;
}
public Site() {
	super();
}
public Site(String emplacement) {
	super();
	this.emplacement = emplacement;
}

}
