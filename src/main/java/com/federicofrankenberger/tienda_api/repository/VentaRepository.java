package com.federicofrankenberger.tienda_api.repository;

import com.federicofrankenberger.tienda_api.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
}
