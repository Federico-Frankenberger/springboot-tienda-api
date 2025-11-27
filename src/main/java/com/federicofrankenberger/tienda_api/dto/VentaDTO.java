package com.federicofrankenberger.tienda_api.dto;

import com.federicofrankenberger.tienda_api.model.DetalleVenta;
import com.federicofrankenberger.tienda_api.model.EstadoVenta;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class VentaDTO {

    //detalles venta
    private Long id;
    private LocalDate fecha;
    private EstadoVenta estado;

    //datos cliente
    private Long idCliente;
    private String nombreCliente;
    private String apellidoCliente;

    //datos sucursal
    private Long idSucursal;

    //lista de detalles
    private List<DetalleVentaDTO> detalles;

    //total de la venta
    private BigDecimal total;

}
