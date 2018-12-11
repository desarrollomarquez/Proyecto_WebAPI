package com.api.mileniocloud.dao;
import java.util.List;
import com.api.mileniocloud.entity.Colegio;

public interface IColegioDAO {
    List<Colegio> getAllColegios();
    Colegio getColegioById(int codigo_id);
    void addColegio(Colegio colegio);
    void updateColegio(Colegio colegio);
    void deleteColegio(int codigo_id);
    boolean colegioExists(int nit,
    					  String nombre,
    					  int codigo_colegio,
    					  int codigo_dane,
    					  String direccion,
    					  String telefono,
    					  String fini_fiscal,
    					  String ffin_fiscal,
    					  String ubicacion_geo,
    					  String foto );
}
 