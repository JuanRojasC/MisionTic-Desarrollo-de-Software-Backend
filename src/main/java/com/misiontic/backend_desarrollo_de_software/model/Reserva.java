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
    private String status = "completed"; // Valor por defecto

    @ManyToOne
    @JsonIgnoreProperties("reservations")
    private SalonFiesta partyroom;

    @ManyToOne
    @JsonIgnoreProperties({"messages", "reservations"})
    private Cliente client;

    @Column(name = "calificacion")
    private Long score = null;

}
