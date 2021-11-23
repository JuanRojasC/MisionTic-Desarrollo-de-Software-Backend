package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.SalonFiesta;
import com.misiontic.backend_desarrollo_de_software.service.SalonFiestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/Partyroom")
@CrossOrigin
public class SalonFiestaController {
    
   private SalonFiestaService salonFiestaService;
   
   @Autowired
   public SalonFiestaController(SalonFiestaService salonFiestaService) {
        this.salonFiestaService = salonFiestaService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Collection<SalonFiesta> buscarTodasLasSalonFiestas(){
        return salonFiestaService. buscarTodosLosSalones();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SalonFiesta buscarSalonFiestaPorId(@PathVariable Long id){
        return salonFiestaService.buscarPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public SalonFiesta guardarSalonFiesta(@RequestBody SalonFiesta c){
        return salonFiestaService.guardarSalonFiesta(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SalonFiesta actualizarSalonFiesta(@RequestBody SalonFiesta c){
        return salonFiestaService.actualizarSalonFiesta(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean eliminarSalonFiesta(@PathVariable Long id){
        return salonFiestaService.eliminarSalonFiestaPorId(id);
    }

}
