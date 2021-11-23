package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Categoria;
import com.misiontic.backend_desarrollo_de_software.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin
public class CategoriaController {

    private CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Collection<Categoria> buscarTodasLasCategorias(){
        return categoriaService.buscarTodasLasCategorias();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Categoria buscarCategoriaPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria guardarCategoria(@RequestBody Categoria c){
        return categoriaService.guardarCategoria(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Categoria actualizarCategoria(@RequestBody Categoria c){
        return categoriaService.actualizarCategoria(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean eliminarCategoria(@PathVariable Long id){
        return categoriaService.eliminarCategoriaPorId(id);
    }
}
