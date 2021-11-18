package com.misiontic.backend_desarrollo_de_software.service;

import com.misiontic.backend_desarrollo_de_software.model.Mensaje;
import com.misiontic.backend_desarrollo_de_software.repository.MensajeRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Log4j
public class MensajeService {

    private MensajeRepository mensajeRepository;

    @Autowired
    public MensajeService(MensajeRepository mensajeRepository){this.mensajeRepository = mensajeRepository;}

    public Mensaje guardarMensaje(Mensaje m){
        try{
            Mensaje mensaje = mensajeRepository.save(m);
            log.info("Mensaje con id: " + m.getIdMessage() + " ha sido guardado");
            return mensaje;
        }catch (Exception e){
            log.error("Mensaje con id: " + m.getIdMessage() + " no pudo ser guardado -- ERROR: " + e.getMessage());
            return null;
        }

    }
    public Collection<Mensaje> buscarTodosLosMensajes(){
        log.info("Todos los mensajes han sido buscados");
        return mensajeRepository.findAll();
    }

}
