package com.misiontic.backend_desarrollo_de_software.repository;

import com.misiontic.backend_desarrollo_de_software.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
