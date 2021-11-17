package com.misiontic.backend_desarrollo_de_software.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "salonfiesta" )
@Data
public class SalonFiesta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "propietario", length = 45)
    private String owner;

    @Column(name = "nombre", length = 45 )
    private String name;

    @Column(name = "capacity")
    private int capacity;
    
    @Column(name = "descripcion")
    private String description;

    @Column(name = "categoria")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Categoria category;

    @OneToMany(mappedBy = "partyroom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Mensaje> messages;

    @OneToMany(mappedBy = "partyroom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Reserva> reservations;







}

