package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Mensaje;
import com.misiontic.backend_desarrollo_de_software.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Message")
public class MensajeController {
    
    private MensajeService mensajeService;
    
    @Autowired
    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> buscarTodosLosMensajes(){
        return ResponseEntity.ok(mensajeService.buscarTodosLosMensajes());
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> guardarMensaje(@RequestBody Mensaje m){
        return ResponseEntity.ok(mensajeService.guardarMensaje(m));
    }
    
}
