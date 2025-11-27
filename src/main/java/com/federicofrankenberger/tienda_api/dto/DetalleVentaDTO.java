package com.federicofrankenberger.tienda_api.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DetalleVentaDTO {
    private Long id;
    private Long idProducto;
    private String nombreProd;
    private BigDecimal precioProd;
    private Integer cantProd;
    private BigDecimal subtotal;
}
