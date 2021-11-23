package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.UsuariosAdmin;
import com.misiontic.backend_desarrollo_de_software.service.UsuariosAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin
public class UsuariosAdminController {

    private UsuariosAdminService usuariosAdminService;

    @Autowired
    public UsuariosAdminController(UsuariosAdminService usuariosAdminService) {
        this.usuariosAdminService = usuariosAdminService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Collection<UsuariosAdmin> buscarTodasLasUsuariosAdmins(){
        return usuariosAdminService.buscarTodosLosUsuariosAdmin();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UsuariosAdmin buscarUsuariosAdminPorId(@PathVariable Long id){
        return usuariosAdminService.buscarPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuariosAdmin guardarUsuariosAdmin(@RequestBody UsuariosAdmin c){
        return usuariosAdminService.guardarUsuarioAdmin(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UsuariosAdmin actualizarUsuariosAdmin(@RequestBody UsuariosAdmin c){
        return usuariosAdminService.actualizarUsuarioAdmin(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean eliminarUsuariosAdmin(@PathVariable Long id){
        return usuariosAdminService.eliminarUsuarioAdminPorId(id);
    }
}
