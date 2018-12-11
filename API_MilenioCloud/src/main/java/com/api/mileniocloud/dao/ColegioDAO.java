package com.api.mileniocloud.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.mileniocloud.entity.Colegio;
import com.api.mileniocloud.entity.ColegioRowMapper;


@Transactional
@Repository
public class ColegioDAO implements IColegioDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Colegio getColegioById(int codigo_id) {
		String sql = "SELECT * FROM COLEGIO WHERE codigo_id = ?";
		RowMapper<Colegio> rowMapper = new BeanPropertyRowMapper<Colegio>(Colegio.class);
		Colegio colegio = jdbcTemplate.queryForObject(sql, rowMapper, codigo_id);
		return colegio;
	}
	
	@Override
	public List<Colegio> getAllColegios() {
		String sql = "SELECT * FROM COLEGIO";
        //RowMapper<Colegio> rowMapper = new BeanPropertyRowMapper<Colegio>(Colegio.class);
		RowMapper<Colegio> rowMapper = new ColegioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	
	@Override
	public void addColegio(Colegio colegio) {
		//Add article
		String sql = "INSERT INTO COLEGIO (codigo_id, nit, nombre, codigo_colegio, codigo_dane, direccion, telefono, fini_fiscal, ffin_fiscal, ubicacion_geo, foto) values (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, colegio.getCodigo_id(), colegio.getNit(), colegio.getNombre(), colegio.getCodigo_colegio(), colegio.getCodigo_dane(), colegio.getDireccion(), colegio.getTelefono(), colegio.getFini_fiscal(), colegio.getFfin_fiscal(), colegio.getUbicacion_geo(), colegio.getFoto() );
		
		//Fetch article id
		sql = "SELECT codigo_id FROM COLEGIO WHERE nit = ? and codigo_colegio =?";
		int codigo_id = jdbcTemplate.queryForObject(sql, Integer.class, colegio.getNit(), colegio.getCodigo_colegio());
		
		//Set article id 
		colegio.setCodigo_id(codigo_id);
	}
	
	@Override
	public void updateColegio(Colegio colegio) {
		String sql = "UPDATE COLEGIO SET nit=?, nombre=?, codigo_colegio=?, codigo_dane=?, direccion=?, telefono=?, fini_fiscal=?, ffin_fiscal=?, ubicacion_geo=?, foto=? WHERE codigo_id=?";
		jdbcTemplate.update(sql, colegio.getNit(), colegio.getNombre(), colegio.getCodigo_colegio(), colegio.getCodigo_dane(), colegio.getDireccion(), colegio.getTelefono(), colegio.getFini_fiscal(), colegio.getFfin_fiscal(), colegio.getUbicacion_geo(), colegio.getFoto(), colegio.getCodigo_id());
	}
	
	@Override
	public void deleteColegio(int codigo_id) {
		String sql = "DELETE FROM COLEGIO WHERE codigo_id=?";
		jdbcTemplate.update(sql, codigo_id);
	}
	@Override
	public boolean colegioExists(int nit, String nombre, int codigo_colegio, int codigo_dane, String direccion, String telefono, String fini_fiscal, String ffin_fiscal, String ubicacion_geo, String foto) {
		String sql = "SELECT count(*) FROM COLEGIO WHERE nit = ? and codigo_colegio =?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, nit, codigo_colegio);
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}
}
