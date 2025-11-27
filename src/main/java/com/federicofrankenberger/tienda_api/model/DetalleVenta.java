package com.federicofrankenberger.tienda_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="itemsPedido")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private Integer cantidad;

    @Column(nullable=false)
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta;

    public BigDecimal getSubtotal(){
        return precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }
}
