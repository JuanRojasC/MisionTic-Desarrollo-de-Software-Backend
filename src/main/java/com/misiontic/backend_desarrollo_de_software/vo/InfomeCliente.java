package com.misiontic.backend_desarrollo_de_software.vo;

import com.misiontic.backend_desarrollo_de_software.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfomeCliente {

    private Integer total;
    private Cliente client;

}
