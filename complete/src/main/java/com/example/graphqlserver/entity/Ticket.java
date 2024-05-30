package com.example.graphqlserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    @Column(name = "fecha_creacion")
    private String fechaCreacion;
    @Column(name = "fecha_actualizacion")
    private String fechaActualizacion;
    @Column(name = "estado")
    private String estado;

}
