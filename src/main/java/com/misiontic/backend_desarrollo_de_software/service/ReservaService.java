package com.misiontic.backend_desarrollo_de_software.service;


import com.misiontic.backend_desarrollo_de_software.model.Reserva;
import com.misiontic.backend_desarrollo_de_software.repository.ReservaRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Log4j
public class ReservaService {

    private ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {this.reservaRepository = reservaRepository;}

    public Reserva guardarReserva(Reserva r){
        try{
            Reserva reserva = reservaRepository.save(r);
            log.info("Reserva con id: " + r.getIdReservation() + " ha sido guardada");
            return reserva;
        }catch (Exception e){
            log.error("Reserva con id: " + r.getIdReservation() + " no pudo ser guardada -- ERROR: " + e.getMessage());
            return null;
        }

    }

    public Collection<Reserva> buscarTodasLasReservas() {
        log.info("Todas las reservas han sido buscadas");
        return reservaRepository.findAll();
    }

}
