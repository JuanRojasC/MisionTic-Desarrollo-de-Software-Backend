package com.misiontic.backend_desarrollo_de_software.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name ="mensajes")
@Data
public class Mensaje {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idMessage;

    @Column( name = "texto", length = 250)
    private String messageText;

    @ManyToOne
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private SalonFiesta partyroom;

    @ManyToOne
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Cliente client;
}
