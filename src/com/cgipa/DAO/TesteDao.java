package com.cgipa.DAO;

import com.cgipa.domaine.TypeVehicule;
import com.cgipa.domaine.Utilisateurs;
import com.cgipa.domaine.Vehicule;
import com.cgipa.service.CategorieServiceImpl;
import com.cgipa.service.Impl.FournisseurServiceImpl;
import com.cgipa.service.Impl.ServiceImpl;
import com.cgipa.service.Impl.SinistreServiceImpl;
import com.cgipa.service.Impl.SiteServiceImpl;
import com.cgipa.service.Impl.TypecarburantServiceImpl;
import com.cgipa.service.Impl.TypevehiculeServiceImpl;
import com.cgipa.service.Impl.UtilisateursServiceImpl;
import com.cgipa.service.Impl.VehiculeServiceImpl;

public class TesteDao {

	public static void main(String[] args) {
	
//		
//	Vehicule ve= new Vehicule(2, "300km", " 4X4", 4, "Renault", "A12Z3E4R", "123AZE", null, "2017-03-05", "2017-03-05", "2017-03-05", 10000,"2017-03-05", "2017-03-05", 10000);
//	System.out.println(ve);
//	VehiculeServiceImpl v=new VehiculeServiceImpl();

// System.out.println(v);
Utilisateurs u= new Utilisateurs(" Ouattara ", " pkandotchin ", " 09 32 06 54 ", " CI0098 56435 ", " interne ");
UtilisateursServiceImpl util= new UtilisateursServiceImpl();
util.AjouterUtilisateurs(u);
}
}
