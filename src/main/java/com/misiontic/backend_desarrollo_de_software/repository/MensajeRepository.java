package com.misiontic.backend_desarrollo_de_software.repository;

import com.misiontic.backend_desarrollo_de_software.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}
