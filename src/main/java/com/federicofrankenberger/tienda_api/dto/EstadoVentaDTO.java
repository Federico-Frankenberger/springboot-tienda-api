package com.federicofrankenberger.tienda_api.dto;

import com.federicofrankenberger.tienda_api.model.EstadoVenta;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EstadoVentaDTO {
    private EstadoVenta estado;
}
