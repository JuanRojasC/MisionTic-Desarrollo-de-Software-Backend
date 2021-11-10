package com.misiontic.backend_desarrollo_de_software.service;

import com.misiontic.backend_desarrollo_de_software.model.Categoria;
import com.misiontic.backend_desarrollo_de_software.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
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
        return categoriaRepository.save(c);
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
        return categoriaRepository.findAll();
    }
}
