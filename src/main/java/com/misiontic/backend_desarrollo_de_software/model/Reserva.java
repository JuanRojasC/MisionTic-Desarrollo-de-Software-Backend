package com.misiontic.backend_desarrollo_de_software.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "reservas" )
@Data
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(name = "fecha_inicio")
    private Date startDate;

    @Column(name = "fecha_entrega")
    private Date devolutionDate;

    @Column(name = "estado", length = 45 )
    private String status = "created"; // Valor por defecto

    @ManyToOne()
    @JoinColumn( name = "id")
    @JsonIgnoreProperties("reservations")
    private SalonFiesta partyroom;

    @ManyToOne()
    @JoinColumn( name = "idClient")
    private Cliente client;

    @Column(name = "calificacion")
    private Long score;

}
