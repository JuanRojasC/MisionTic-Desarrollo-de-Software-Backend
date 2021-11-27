package com.misiontic.backend_desarrollo_de_software.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformeReservas {

    private Integer completed;
    private Integer cancelled;

}
