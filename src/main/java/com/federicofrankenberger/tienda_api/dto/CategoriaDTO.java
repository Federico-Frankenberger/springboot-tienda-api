package com.federicofrankenberger.tienda_api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CategoriaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}
