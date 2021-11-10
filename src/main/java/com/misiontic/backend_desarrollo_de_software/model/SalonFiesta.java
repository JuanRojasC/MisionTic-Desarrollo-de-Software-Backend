package com.misiontic.backend_desarrollo_de_software.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name= "salonfiesta" )
@Data
public class SalonFiesta {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    private String category;  // REVISAR









}

