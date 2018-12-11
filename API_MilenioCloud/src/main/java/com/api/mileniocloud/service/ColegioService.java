package com.api.mileniocloud.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mileniocloud.dao.IColegioDAO;
import com.api.mileniocloud.entity.Colegio;

@Service
public class ColegioService implements IColegioService {
	
	@Autowired
	private IColegioDAO colegioDAO;
	
	@Override
	public Colegio getColegioById(int codigo_id) {
		Colegio obj = colegioDAO.getColegioById(codigo_id);
		return obj;
	}	
	
	@Override
	public List<Colegio> getAllColegios(){
		return colegioDAO.getAllColegios();
	}
	
	@Override
	public synchronized boolean addColegio(Colegio colegio){
       if (colegioDAO.colegioExists(colegio.getNit(), colegio.getNombre(), colegio.getCodigo_colegio(), colegio.getCodigo_dane(), colegio.getDireccion(), colegio.getTelefono(), colegio.getFini_fiscal(), colegio.getFfin_fiscal(), colegio.getUbicacion_geo(), colegio.getFoto())) {
    	   return false;
       } else {
    	   colegioDAO.addColegio(colegio);
    	   return true;
       }
	}
	
	@Override
	public void updateColegio(Colegio colegio) {
		colegioDAO.updateColegio(colegio);
	}
	
	@Override
	public void deleteColegio(int codigo_id) {
		colegioDAO.deleteColegio(codigo_id);
	}
}
