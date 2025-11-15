package com.federicofrankenberger.tienda_api.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="itemsPedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long codigoItem;
    @Column(nullable=false)
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "codigo_producto", nullable = false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "codigo_venta", nullable = false)
    private Venta venta;

    public Double getSubtotal(){
        return producto.getPrecio()*cantidad;
    }
}
