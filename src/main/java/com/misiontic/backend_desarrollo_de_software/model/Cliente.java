package com.misiontic.backend_desarrollo_de_software.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idClient;

    @Column(name = "correo", length = 45)
    private String email;

    @Column(name = "contrasena", length = 45)
    private String password;

    @Column(name = "nombre", length = 250)
    private String name;

    @Column(name = "edad")
    private Integer age;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("client")
    private List<Mensaje> messages;

    @OneToMany( mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("client")
    private List<Reserva> reservations;

}
