package com.federicofrankenberger.tienda_api.service;

import com.federicofrankenberger.tienda_api.dto.VentaDTO;
import com.federicofrankenberger.tienda_api.model.EstadoVenta;
import java.util.List;

public interface VentaService {
    VentaDTO save(VentaDTO dto);
    VentaDTO findById(Long id);
    List<VentaDTO> findAll();
    VentaDTO cambiarEstado(Long id, EstadoVenta estado);
}
