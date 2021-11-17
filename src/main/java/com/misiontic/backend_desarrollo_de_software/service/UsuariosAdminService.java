package com.misiontic.backend_desarrollo_de_software.service;

import com.misiontic.backend_desarrollo_de_software.model.UsuariosAdmin;
import com.misiontic.backend_desarrollo_de_software.repository.UsuariosAdminRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Log4j
public class UsuariosAdminService {

    private UsuariosAdminRepository usuariosAdminRepository;

    @Autowired
    public UsuariosAdminService(UsuariosAdminRepository usuariosAdminRepository) {this.usuariosAdminRepository= usuariosAdminRepository;}

    public UsuariosAdmin guardarUsuarioAdmin(UsuariosAdmin admin) {
        try{
            UsuariosAdmin usuarioAdmin= usuariosAdminRepository.save(admin);
            log.info("Usuario Administrador con id: " + admin.getIdAdmin() + " ha sido guardado");
            return  usuarioAdmin;
        }catch (Exception e){
            log.error("Usuario Administrador con id: " + admin.getIdAdmin() + " no pudo ser guardado -- ERROR: " + e.getMessage());
            return null;
        }
    }

    public Collection<UsuariosAdmin> buscarTodosLosUsuariosAdmin() {
        log.info("Todos los usuarios administradores han sido buscados");
        return usuariosAdminRepository.findAll();

    }
}
