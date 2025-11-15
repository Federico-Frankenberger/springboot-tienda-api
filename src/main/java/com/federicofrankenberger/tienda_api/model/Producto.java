package com.federicofrankenberger.tienda_api.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoProducto;
    @Column(unique=true,nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String marca;
    @Column(nullable=false)
    private Double costo;
    @Column(nullable=false)
    private Double precio;
    @Column(nullable=false)
    private Double stock;
}
