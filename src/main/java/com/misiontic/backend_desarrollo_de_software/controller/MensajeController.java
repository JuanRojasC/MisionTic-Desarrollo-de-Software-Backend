package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Mensaje;
import com.misiontic.backend_desarrollo_de_software.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin
public class MensajeController {
    
    private MensajeService mensajeService;
    
    @Autowired
    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Collection<Mensaje> buscarTodasLosMensajes(){
        return mensajeService.buscarTodosLosMensajes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mensaje buscarMensajePorId(@PathVariable Long id){
        return mensajeService.buscarPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje guardarMensaje(@RequestBody Mensaje c){
        return mensajeService.guardarMensaje(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mensaje actualizarMensaje(@RequestBody Mensaje c){
        return mensajeService.actualizarMensaje(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean eliminarMensaje(@PathVariable Long id){
        return mensajeService.eliminarMensajePorId(id);
    }
    
}
