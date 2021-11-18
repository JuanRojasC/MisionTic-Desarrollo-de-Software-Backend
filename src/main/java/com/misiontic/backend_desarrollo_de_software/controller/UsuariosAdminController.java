package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.UsuariosAdmin;
import com.misiontic.backend_desarrollo_de_software.service.UsuariosAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Admin")
public class UsuariosAdminController {

    private UsuariosAdminService usuariosAdminService;

    @Autowired
    public UsuariosAdminController(UsuariosAdminService usuariosAdminService) {
        this.usuariosAdminService = usuariosAdminService;
    }
    @GetMapping("/all")
    public ResponseEntity<?> buscarTodosLosAdmin() {
        return ResponseEntity.ok(usuariosAdminService.buscarTodosLosUsuariosAdmin());
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarAdmin(@RequestBody UsuariosAdmin admin){
        return ResponseEntity.ok(usuariosAdminService.guardarUsuarioAdmin(admin));
    }
}
