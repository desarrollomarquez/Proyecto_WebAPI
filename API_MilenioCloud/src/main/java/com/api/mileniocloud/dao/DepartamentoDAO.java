package com.api.mileniocloud.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.mileniocloud.entity.Departamento;
import com.api.mileniocloud.entity.DepartamentoRowMapper;


@Transactional
@Repository
public class DepartamentoDAO implements IDepartamentoDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Departamento getDepartamentoById(String codigo_id) {
		String sql = "SELECT * FROM departamento WHERE codigo_id = ?";
		RowMapper<Departamento> rowMapper = new BeanPropertyRowMapper<Departamento>(Departamento.class);
		Departamento colegio = jdbcTemplate.queryForObject(sql, rowMapper, codigo_id);
		return colegio;
	}
	
	@Override
	public List<Departamento> getAllDepartamentos() {
		String sql = "SELECT * FROM departamento";
        //RowMapper<Departamento> rowMapper = new BeanPropertyRowMapper<Departamento>(Departamento.class);
		RowMapper<Departamento> rowMapper = new DepartamentoRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	
	@Override
	public void addDepartamento(Departamento departamento) {
		//Add article
		String sql = "INSERT INTO departamento (codigo_id, codigo, nombre, latitud, longitud) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, departamento.getCodigo_id(), departamento.getCodigo(), departamento.getNombre(), departamento.getLatitud(), departamento.getLongitud() );
		
		//Fetch article id
		sql = "SELECT codigo_id FROM departamento WHERE codigo =?";
		Integer codigo_id = jdbcTemplate.queryForObject(sql, Integer.class, departamento.getCodigo_id());
		
		//Set article id 
		departamento.setCodigo_id(Integer.toString(codigo_id));
	}
	
	@Override
	public void updateDepartamento(Departamento departamento) {
		String sql = "UPDATE departamento SET codigo=?, nombre=?, latitud=?, longitud=?  WHERE codigo_id=?";
		jdbcTemplate.update(sql, departamento.getCodigo(), departamento.getNombre(), departamento.getLatitud(), departamento.getLongitud(), departamento.getCodigo_id());
	}
	
	@Override
	public void deleteDepartamento(String codigo_id) {
		String sql = "DELETE FROM departamento WHERE codigo_id=?";
		jdbcTemplate.update(sql, codigo_id);
	}
	@Override
	public boolean departamentoExists(String codigo, String nombre, String latitud, String longitud) {
		String sql = "SELECT count(*) FROM departamento WHERE codigo =?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, codigo);
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}
}
