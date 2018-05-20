package com.cgipa.domaine;

public class Typecarbrant {
private int idtypecar;
private String libellee;
public int getIdtypecar() {
	return idtypecar;
}
public void setIdtypecar(int idtypecar) {
	this.idtypecar = idtypecar;
}
public String getLibellee() {
	return libellee;
}
public void setLibellee(String libellee) {
	this.libellee = libellee;
}
public Typecarbrant() {
	super();
}
public Typecarbrant(String libellee) {
	super();
	this.libellee = libellee;
}

}
