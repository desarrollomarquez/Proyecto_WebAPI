package com.api.mileniocloud.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DepartamentoRowMapper implements RowMapper<Departamento> {
	
	@Override
	public Departamento mapRow(ResultSet row, int rowNum) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setCodigo_id(row.getString("codigo_id"));
		departamento.setCodigo(row.getString("codigo"));
		departamento.setNombre(row.getString("nombre"));
		departamento.setLatitud(row.getString("latitud"));
		departamento.setLongitud(row.getString("longitud"));
		return departamento;
	}
	
}
