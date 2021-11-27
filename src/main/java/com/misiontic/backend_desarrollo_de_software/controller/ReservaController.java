package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Reserva;
import com.misiontic.backend_desarrollo_de_software.service.ReservaService;
import com.misiontic.backend_desarrollo_de_software.vo.InfomeCliente;
import com.misiontic.backend_desarrollo_de_software.vo.InformeReservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
        return ResponseEntity.status(201).body(c);
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

    /*1. Cantidad de reservas en un tiempo determinado. */
    @GetMapping("/report-dates/{fechaUno}/{fechaDos}")
    public List<Reserva> obtenerReservasEntreFechas(@PathVariable("fechaUno") String fechaUno, @PathVariable("fechaDos") String fechaDos) {
        return reservaService.obtenerPeriodoReservas(fechaUno, fechaDos);
    }

    /*2. Cantidad de reservas completadas y canceladas*/
    @GetMapping("/report-status")
    public InformeReservas obtenerReservasCompletadasYCanceladas(){
        return reservaService.obtenerReservasCompletadasYCanceladas();
    }

    /*3. Agrupar reservas por cliente y ordernar en forma descenndente*/
    @GetMapping("/report-clients")
    public List<InfomeCliente> obtenerReservasCompletdasPorClientes(){
        return reservaService.obtenerReservasCompletadasPorCliente();
    }
}
