package com.api.mileniocloud.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DepartamentoRowMapper implements RowMapper<Departamento> {
	
	@Override
	public Departamento mapRow(ResultSet row, int rowNum) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setUuid(row.getString("uuid"));
		departamento.setCodigo_id(row.getString("codigo_id"));
		departamento.setNombre(row.getString("nombre"));
		departamento.setLatitud(row.getString("latitud"));
		departamento.setLongitud(row.getString("longitud"));
		return departamento;
	}
	
}
