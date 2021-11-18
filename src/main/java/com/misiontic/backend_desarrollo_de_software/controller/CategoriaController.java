package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Categoria;
import com.misiontic.backend_desarrollo_de_software.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Category")
public class CategoriaController {

    private CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> buscarTodasLasCategorias(){
        //return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarTodasLasCategorias());
        return ResponseEntity.ok(categoriaService.buscarTodasLasCategorias());
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarCategoria(@RequestBody Categoria c){
        return ResponseEntity.ok(categoriaService.guardarCategoria(c));
    }
}
