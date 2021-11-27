package com.misiontic.backend_desarrollo_de_software.repository;

import com.misiontic.backend_desarrollo_de_software.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    /*1. Cantidad de reservas en un tiempo determinado. */
    @Query("FROM Reserva r WHERE r.startDate >= ?1 AND r.devolutionDate <= ?2")
    List<Reserva> findBookingsByRangeDate(Date a, Date b);

    /*2. Cantidad de reservas completadas y canceladas*/
    @Query("FROM Reserva r WHERE r.status = ?1")
    List<Reserva> findBookingByStatus(String status);

    @Query("SELECT COUNT(r.client) AS total, r.client AS client FROM Reserva r GROUP BY client ORDER BY total DESC")
    List<Object[]> sortBookingsCompletedByClient();
}
