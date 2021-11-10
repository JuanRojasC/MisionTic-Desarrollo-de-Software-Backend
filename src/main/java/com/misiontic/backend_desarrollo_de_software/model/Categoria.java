package com.misiontic.backend_desarrollo_de_software.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table( name = "categorias")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( name = "nombre", length = 45)
    private String name;

    @Column( name = "descripcion" )
    private String description;

}
