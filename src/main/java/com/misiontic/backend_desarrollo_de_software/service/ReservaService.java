package com.misiontic.backend_desarrollo_de_software.service;

import com.misiontic.backend_desarrollo_de_software.model.Cliente;
import com.misiontic.backend_desarrollo_de_software.model.Reserva;
import com.misiontic.backend_desarrollo_de_software.repository.ReservaRepository;
import com.misiontic.backend_desarrollo_de_software.vo.InfomeCliente;
import com.misiontic.backend_desarrollo_de_software.vo.InformeReservas;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /*1. Cantidad de reservas en un tiempo determinado. */
    public List<Reserva> obtenerPeriodoReservas(String fechaA, String fechaB) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat parser = new SimpleDateFormat(pattern);
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(fechaA);
            b = parser.parse(fechaB);
        } catch (ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservaRepository.findBookingsByRangeDate(a,b);
        } else {
            return new ArrayList<>();
        }
    }

    /*2. Cantidad de reservas completadas y canceladas*/
    public InformeReservas obtenerReservasCompletadasYCanceladas(){
        Integer reservasCompletadas = reservaRepository.findBookingByStatus("completed").size();
        Integer reservasCanceladas = reservaRepository.findBookingByStatus("cancelled").size();
        return new InformeReservas(reservasCompletadas, reservasCanceladas);
    }

    /*3. Agrupar reservas por cliente y ordernar en forma descenndente*/
    public List<InfomeCliente> obtenerReservasCompletadasPorCliente(){
        List<Object[]> results = reservaRepository.sortBookingsCompletedByClient();
        List<InfomeCliente> clients = new ArrayList<>();
        for(Object[] result : results){
            clients.add(new InfomeCliente(((Long) result[0]).intValue(), (Cliente) result[1]));
        }
        return clients;
    }
}
