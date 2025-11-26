package com.federicofrankenberger.tienda_api.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String marca;
    private String nombreCategoria;
    private BigDecimal precio;
    private Integer stock;
}
