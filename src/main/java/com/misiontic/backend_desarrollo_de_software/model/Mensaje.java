package com.misiontic.backend_desarrollo_de_software.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name ="mensajes")
@Data
public class Mensaje {

    private Long idMessage;

    @Column( name = "texto", length = 250)
    private String messageText;
    // continuar...
}
