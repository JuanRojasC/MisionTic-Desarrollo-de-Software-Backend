package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Reserva;
import com.misiontic.backend_desarrollo_de_software.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
public class ReservaController {
    
    private ReservaService reservaService;
    
    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> buscarTodasLasReservas(){
        return ResponseEntity.ok(reservaService.buscarTodasLasReservas());
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> guardarReserva(@RequestBody Reserva r){
        return ResponseEntity.ok(reservaService.guardarReserva(r));
    }
}
