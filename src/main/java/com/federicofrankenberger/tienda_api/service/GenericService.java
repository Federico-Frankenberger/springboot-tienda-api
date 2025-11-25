package com.federicofrankenberger.tienda_api.service;

import java.util.List;
import java.util.Optional;

public interface GenericService <T,ID>{
        T save(T dto);
        T update(ID id ,T dto);
        void delete(ID id);
        Optional<T> findById(ID id);
        List<T> findAll();
}
