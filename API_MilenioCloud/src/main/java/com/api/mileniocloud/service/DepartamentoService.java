package com.api.mileniocloud.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mileniocloud.dao.IDepartamentoDAO;
import com.api.mileniocloud.entity.Departamento;

@Service
public class DepartamentoService implements IDepartamentoService {
	
	@Autowired
	private IDepartamentoDAO departamentoDAO;
	
	@Override
	public Departamento getDepartamentoById(String codigo_id) {
		Departamento obj = departamentoDAO.getDepartamentoById(codigo_id);
		return obj;
	}	
	
	@Override
	public List<Departamento> getAllDepartamentos(){
		return departamentoDAO.getAllDepartamentos();
	}
	
	@Override
	public synchronized boolean addDepartamento(Departamento departamento){
       if (departamentoDAO.departamentoExists(departamento.getCodigo(), departamento.getNombre(), departamento.getLatitud(), departamento.getLongitud())) {
    	   return false;
       } else {
    	   departamentoDAO.addDepartamento(departamento);
    	   return true;
       }
	}
	
	@Override
	public void updateDepartamento(Departamento departamento) {
		departamentoDAO.updateDepartamento(departamento);
	}
	
	@Override
	public void deleteDepartamento(String codigo_id) {
		departamentoDAO.deleteDepartamento(codigo_id);
	}
}
