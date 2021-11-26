package com.misiontic.backend_desarrollo_de_software.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "salonfiesta" )
@Data
public class SalonFiesta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 45 )
    private String name;

    @Column(name = "propietario", length = 45)
    private String owner;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "descripcion", length = 250)
    private String description;

    @ManyToOne
    @JsonIgnoreProperties("partyrooms")
    private Categoria category;

    @OneToMany(mappedBy = "partyroom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"partyroom", "client"})
    private List<Mensaje> messages;

    @OneToMany(mappedBy = "partyroom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"partyroom", "client"})
    private List<Reserva> reservations;

}

