package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Reserva;
import com.misiontic.backend_desarrollo_de_software.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin
public class ReservaController {
    
    private ReservaService reservaService;
    
    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Reserva> buscarTodasLasReservas(){
        return reservaService.buscarTodasLasReservas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reserva buscarReservaPorId(@PathVariable Long id){
        return reservaService.buscarPorId(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarReserva(@RequestBody Reserva c){
        reservaService.guardarReserva(c);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva actualizarReserva(@RequestBody Reserva c){
        return reservaService.actualizarReserva(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean eliminarReserva(@PathVariable Long id){
        return reservaService.eliminarReservaPorId(id);
    }

}
