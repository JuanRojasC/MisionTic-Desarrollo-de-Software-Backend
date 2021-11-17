package com.misiontic.backend_desarrollo_de_software.service;

import com.misiontic.backend_desarrollo_de_software.model.Categoria;
import com.misiontic.backend_desarrollo_de_software.model.Categoria;
import com.misiontic.backend_desarrollo_de_software.repository.CategoriaRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Log4j
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

//    public Categoria buscarPorId(Long id){
//        Optional<Categoria> categoria = categoriaRepository.findById(id);
//        if(categoria.isEmpty()){
//            return null;
//        }
//        return categoria.get();
//    }

    public Categoria guardarCategoria(Categoria c){
        try{
            Categoria categoria = categoriaRepository.save(c);
            log.info("Categoria con id: " + c.getId() + " guardada");
            return  categoria;
        }catch (Exception e){
            log.error("Categoria con id: " + c.getId() + " no pudo ser guardar -- ERROR: " + e.getMessage());
            return null;
        }
    }

//    public Categoria actualizarCategoria(Categoria c){
//        if(buscarPorId(c.getId()) != null){
//            return categoriaRepository.save(c);
//        }
//        return null;
//    }
//
//    public void eliminarCategoriaPorId(Long id){
//        categoriaRepository.deleteById(id);
//    }

    public Collection<Categoria> buscarTodasLasCategorias(){
        log.info("Todas las categorias han sido buscadas");
        return categoriaRepository.findAll();
    }
}
