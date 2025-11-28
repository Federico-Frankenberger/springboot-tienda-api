package com.federicofrankenberger.tienda_api.repository;

import com.federicofrankenberger.tienda_api.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal,Long> {
    boolean existsByNombre(String nombre);
    boolean existsByNombreAndIdNot(String nombre, Long id);
}
