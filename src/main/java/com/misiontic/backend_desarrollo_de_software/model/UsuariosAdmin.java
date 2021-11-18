package com.misiontic.backend_desarrollo_de_software.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usuarios_admin")
@Data
public class UsuariosAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    @Column(name="correo", length=45)
    private String email;

    @Column(name="contrasena", length=45)
    private String password;

    @Column(name ="nombre", length = 250)
    private String name;


}
