package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Categoria;
import com.misiontic.backend_desarrollo_de_software.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoriaController {

    private CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Categoria> buscarTodasLasCategorias(){
        return categoriaService.buscarTodasLasCategorias();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria buscarCategoriaPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarCategoria(@RequestBody Categoria c){
        categoriaService.guardarCategoria(c);
        return ResponseEntity.status(201).body(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria actualizarCategoria(@RequestBody Categoria c){
        return categoriaService.actualizarCategoria(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean eliminarCategoria(@PathVariable Long id){
        return categoriaService.eliminarCategoriaPorId(id);
    }
}
