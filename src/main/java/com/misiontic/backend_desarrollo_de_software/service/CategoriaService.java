package com.misiontic.backend_desarrollo_de_software.service;

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

    public Categoria buscarPorId(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isEmpty()){
            return null;
        }
        log.info("Categoria con id: " + id + " buscado");
        return categoria.get();
    }

    public Categoria guardarCategoria(Categoria c){
        try{
            Categoria categoria = categoriaRepository.save(c);
            log.info("Categoria con id: " + c.getId() + " ha sido guardada");
            return  categoria;
        }catch (Exception e){
            log.error("Categoria con id: " + c.getId() + " no pudo ser guardada -- ERROR: " + e.getMessage());
            return null;
        }
    }

    public Categoria actualizarCategoria(Categoria c){
        Optional<Categoria> categoria = categoriaRepository.findById(c.getId());
        if(!categoria.isEmpty()){
            c.setPartyrooms(categoria.get().getPartyrooms());
            log.info("Categorias con id: " + c.getId() + " actualizada");
            return categoriaRepository.save(c);
        }
        return null;
    }

    public Boolean eliminarCategoriaPorId(Long id){
        try{
            categoriaRepository.deleteById(id);
            log.info("Categoria con id: " + id + " eliminada");
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public Collection<Categoria> buscarTodasLasCategorias(){
        log.info("Todas las categorias han sido buscadas");
        return categoriaRepository.findAll();
    }
}
