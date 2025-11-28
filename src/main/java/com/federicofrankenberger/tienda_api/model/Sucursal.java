package com.federicofrankenberger.tienda_api.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true,nullable=false)
    private String nombre;

    @Column(nullable=false)
    private String direccion;
}
