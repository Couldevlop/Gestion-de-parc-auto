package com.cgipa.service;

import com.cgipa.domaine.Services;
import com.cgipa.domaine.Site;

public interface IServices {
	public int getIdServices();
	public Services AjouterServices(Site s);
	public void ConsulterService();
	public void SupprimerService();
}
