package com.federicofrankenberger.tienda_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true,nullable=false)
    private String nombre;

    @Column(nullable=false)
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
}
