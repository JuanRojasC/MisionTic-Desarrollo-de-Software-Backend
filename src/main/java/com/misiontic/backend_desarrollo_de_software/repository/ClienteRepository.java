package com.misiontic.backend_desarrollo_de_software.repository;

import com.misiontic.backend_desarrollo_de_software.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
