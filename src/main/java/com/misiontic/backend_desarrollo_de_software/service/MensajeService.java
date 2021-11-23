package com.misiontic.backend_desarrollo_de_software.service;

import com.misiontic.backend_desarrollo_de_software.model.Mensaje;
import com.misiontic.backend_desarrollo_de_software.repository.MensajeRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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

    public Mensaje buscarPorId(Long id){
        Optional<Mensaje> mensaje = mensajeRepository.findById(id);
        if(mensaje.isEmpty()){
            return null;
        }
        log.info("Mensaje con id: " + id + " buscado");
        return mensaje.get();
    }

    public Collection<Mensaje> buscarTodosLosMensajes(){
        log.info("Todos los mensajes han sido buscados");
        return mensajeRepository.findAll();
    }

    public Mensaje actualizarMensaje(Mensaje m){
        Optional<Mensaje> mensaje = mensajeRepository.findById(m.getIdMessage());
        if(!mensaje.isEmpty()){
            log.info("Mensajes con id: " + m.getIdMessage() + " actualizad0");
            return mensajeRepository.save(m);
        }
        return null;
    }

    public Boolean eliminarMensajePorId(Long id){
        try{
            mensajeRepository.deleteById(id);
            log.info("Mensaje con id: " + id + " eliminad0");
            return true;
        }catch (Exception ex){
            return false;
        }
    }

}
