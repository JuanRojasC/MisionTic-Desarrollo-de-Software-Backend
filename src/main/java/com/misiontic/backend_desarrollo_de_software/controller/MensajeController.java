package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Mensaje;
import com.misiontic.backend_desarrollo_de_software.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MensajeController {
    
    private MensajeService mensajeService;
    
    @Autowired
    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Mensaje> buscarTodasLosMensajes(){
        return mensajeService.buscarTodosLosMensajes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mensaje buscarMensajePorId(@PathVariable Long id){
        return mensajeService.buscarPorId(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarMensaje(@RequestBody Mensaje c){
        mensajeService.guardarMensaje(c);
        return ResponseEntity.status(201).body(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje actualizarMensaje(@RequestBody Mensaje c){
        return mensajeService.actualizarMensaje(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean eliminarMensaje(@PathVariable Long id){
        return mensajeService.eliminarMensajePorId(id);
    }
    
}
