package com.api.mileniocloud.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ColegioRowMapper implements RowMapper<Colegio> {
	
	@Override
	public Colegio mapRow(ResultSet row, int rowNum) throws SQLException {
		Colegio colegio = new Colegio();
		colegio.setCodigo_id(row.getInt("codigo_id"));
		colegio.setNit(row.getInt("nit"));
		colegio.setNombre(row.getString("nombre"));
		colegio.setCodigo_colegio(row.getInt("codigo_colegio"));
		colegio.setCodigo_dane(row.getInt("codigo_dane"));
		colegio.setDireccion(row.getString("direccion"));
		colegio.setTelefono(row.getString("telefono"));
		colegio.setFini_fiscal(row.getString("fini_fiscal"));
		colegio.setFfin_fiscal(row.getString("ffin_fiscal"));
		colegio.setUbicacion_geo(row.getString("ubicacion_geo"));
		colegio.setFoto(row.getString("foto"));
		return colegio;
	}
	
}
