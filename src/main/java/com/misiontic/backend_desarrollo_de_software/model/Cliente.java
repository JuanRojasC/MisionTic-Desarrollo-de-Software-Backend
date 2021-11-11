package com.misiontic.backend_desarrollo_de_software.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name ="clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idClient;

    @Column(name = "correo", length = 45)
    private String email;

    @Column(name = "contrasena", length = 45)
    private String password;

    @Column(name = "edad")
    private Integer age;

    @Column(name = "nombre", length = 250)
    private String name;



}
