package com.cgipa.service;

import java.util.Collection;
import java.util.List;
import com.cgipa.domaine.*;


public interface ISinistreService {
	public Sinistre ConsulterSinistre();
	public void AjouterSinistre(Sinistre s);
	public int GetSinistreId();

}
