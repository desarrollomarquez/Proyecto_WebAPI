package com.api.mileniocloud.dao;
import java.util.List;
import com.api.mileniocloud.entity.Departamento;

public interface IDepartamentoDAO {
    List<Departamento> getAllDepartamentos();
    Departamento getDepartamentoById(String codigo_id);
    void addDepartamento(Departamento departamento);
    void updateDepartamento(Departamento departamento);
    void deleteDepartamento(String codigo_id);
    boolean departamentoExists(
    					  String codigo,
    					  String nombre,
    					  String latitud,
    					  String longitud
    					  );
}
 