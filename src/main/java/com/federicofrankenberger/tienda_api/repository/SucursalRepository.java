package com.federicofrankenberger.tienda_api.repository;

import com.federicofrankenberger.tienda_api.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal,Integer> {
}
