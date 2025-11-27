package com.federicofrankenberger.tienda_api.repository;

import com.federicofrankenberger.tienda_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
