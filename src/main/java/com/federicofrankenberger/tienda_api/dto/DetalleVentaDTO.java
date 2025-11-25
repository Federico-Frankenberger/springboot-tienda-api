package com.federicofrankenberger.tienda_api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleVentaDTO {
    private Long id;
    private String nombreProd;
    private Double precioProd;
    private Integer cantProd;
    private Double subtotal;
}
