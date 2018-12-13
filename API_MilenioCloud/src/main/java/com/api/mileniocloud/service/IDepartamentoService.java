package com.api.mileniocloud.service;

import java.util.List;
import com.api.mileniocloud.entity.Departamento;

public interface IDepartamentoService {
     List<Departamento> getAllDepartamentos();
     Departamento getDepartamentoById(String codigo_id);
     boolean addDepartamento(Departamento departamento);
     void updateDepartamento(Departamento departamento);
     void deleteDepartamento(String codigo_id);
}
