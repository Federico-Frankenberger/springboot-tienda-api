package com.federicofrankenberger.tienda_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long codigoVenta;
    @Column(nullable=false)
    private LocalDate fechaVenta;
    @Column(nullable=false)
    private double total;
    @ManyToOne
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Cliente cliente;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> listaItems;

    @PrePersist
    @PreUpdate
    public void calcularTotal(){
        if(listaItems != null){
            this.total = listaItems.stream()
                    .mapToDouble(ItemPedido::getSubtotal)
                    .sum();
        }
    }
}