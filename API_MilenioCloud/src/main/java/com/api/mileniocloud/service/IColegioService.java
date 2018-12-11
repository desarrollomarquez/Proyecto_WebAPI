package com.api.mileniocloud.service;

import java.util.List;
import com.api.mileniocloud.entity.Colegio;

public interface IColegioService {
     List<Colegio> getAllColegios();
     Colegio getColegioById(int codigo_id);
     boolean addColegio(Colegio colegio);
     void updateColegio(Colegio colegio);
     void deleteColegio(int codigo_id);
}
