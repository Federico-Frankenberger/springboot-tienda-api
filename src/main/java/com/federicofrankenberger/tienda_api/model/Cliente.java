package com.federicofrankenberger.tienda_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCliente;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellido;
    @Column(unique=true,nullable=false)
    private String dni;
    @Column(unique=true,nullable=false)
    private String email;
    @Column(unique=true,nullable=false)
    private String telefono;
    @Column(nullable=false)
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;

}
