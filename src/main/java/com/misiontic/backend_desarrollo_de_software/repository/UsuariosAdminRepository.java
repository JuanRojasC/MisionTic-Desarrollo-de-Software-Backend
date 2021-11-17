package com.misiontic.backend_desarrollo_de_software.repository;

import com.misiontic.backend_desarrollo_de_software.model.UsuariosAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosAdminRepository extends JpaRepository<UsuariosAdmin, Long> {
}
