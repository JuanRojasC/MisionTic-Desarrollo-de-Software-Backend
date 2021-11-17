package com.misiontic.backend_desarrollo_de_software.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "reservas" )
@Data
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReservation;

    @Column(name = "fecha_inicio")
    private Date startDate;

    @Column(name = "fecha_entrega")
    private Date devolutionDate;

    @Column(name = "estado", length = 45 )
    private String status = "created"; // Valor por defecto

    @Column(name = "calificacion")
    private Long score;

}
