package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.SalonFiesta;
import com.misiontic.backend_desarrollo_de_software.service.SalonFiestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Partyroom")
public class SalonFiestaController {
    
   private SalonFiestaService salonFiestaService;
   
   @Autowired
   public SalonFiestaController(SalonFiestaService salonFiestaService) {
        this.salonFiestaService = salonFiestaService;
    }
   
   @GetMapping("/all")
   public ResponseEntity<?> buscarTodosLosSalones(){
        return ResponseEntity.ok(salonFiestaService.buscarTodosLosSalones());
    }
    
   @PostMapping("/save")
    public ResponseEntity<?> guardarSalonFiesta(@RequestBody SalonFiesta c){
        return ResponseEntity.ok(salonFiestaService.guardarSalonFiesta(c));
    }
}
