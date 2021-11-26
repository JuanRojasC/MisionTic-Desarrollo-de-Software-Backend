package com.misiontic.backend_desarrollo_de_software.repository;

import com.misiontic.backend_desarrollo_de_software.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    /*1. Cantidad de reservas en un tiempo determinado. */
    List<Reserva> obtenerPeriodoReserva(Date a, Date b);
}
