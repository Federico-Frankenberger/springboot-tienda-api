package com.federicofrankenberger.tienda_api.repository;

import com.federicofrankenberger.tienda_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
    boolean existsByTelefono(String telefono);
    boolean existsByDniAndIdNot(String dni, Long id);
    boolean existsByEmailAndIdNot(String email, Long id);
    boolean existsByTelefonoAndIdNot(String telefono, Long id);
}
