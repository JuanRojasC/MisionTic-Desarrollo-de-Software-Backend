package com.misiontic.backend_desarrollo_de_software.service;


import com.misiontic.backend_desarrollo_de_software.model.Reserva;
import com.misiontic.backend_desarrollo_de_software.repository.ReservaRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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

    public Reserva buscarPorId(Long id){
        Optional<Reserva> mensaje = reservaRepository.findById(id);
        if(mensaje.isEmpty()){
            return null;
        }
        log.info("Reserva con id: " + id + " buscado");
        return mensaje.get();
    }

    public Reserva actualizarReserva(Reserva r){
        Optional<Reserva> reserva = reservaRepository.findById(r.getIdReservation());
        if(!reserva.isEmpty()){
            Reserva reservaEncontrada = reserva.get();
            r.setClient(reservaEncontrada.getClient());
            r.setPartyroom(reservaEncontrada.getPartyroom());
            log.info("Reservas con id: " + reservaEncontrada.getIdReservation() + " actualizada");
            return reservaRepository.save(r);
        }
        return null;
    }

    public Boolean eliminarReservaPorId(Long id){
        try{
            reservaRepository.deleteById(id);
            log.info("Reserva con id: " + id + " eliminada");
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public Collection<Reserva> buscarTodasLasReservas(){
        log.info("Todas las reservas han sido buscadas");
        return reservaRepository.findAll();
    }

}
