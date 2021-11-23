package com.misiontic.backend_desarrollo_de_software.service;

import com.misiontic.backend_desarrollo_de_software.model.UsuariosAdmin;
import com.misiontic.backend_desarrollo_de_software.repository.UsuariosAdminRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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

    public UsuariosAdmin buscarPorId(Long id){
        Optional<UsuariosAdmin> salonFiesta = usuariosAdminRepository.findById(id);
        if(salonFiesta.isEmpty()){
            log.info("Usuario Administrador con id: " + id + " no fue encontrado");
            return null;
        }
        log.info("Usuario Administrador con id: "+ id + " ha sido encontrado");
        return salonFiesta.get();
    }

    public Collection<UsuariosAdmin> buscarTodosLosUsuariosAdmin() {
        log.info("Todos los usuarios administradores han sido buscados");
        return usuariosAdminRepository.findAll();

    }

    public UsuariosAdmin actualizarUsuarioAdmin(UsuariosAdmin u){
        Optional<UsuariosAdmin> usuarioAdmin = usuariosAdminRepository.findById(u.getIdAdmin());
        if(!usuarioAdmin.isEmpty()){
            log.info("Usuario Administrador con id: " + u.getIdAdmin() + " actualizado");
            return usuariosAdminRepository.save(u);
        }
        return null;
    }

    public Boolean eliminarUsuarioAdminPorId(Long id){
        try{
            usuariosAdminRepository.deleteById(id);
            log.info("Usuario Administrador con id: " + id + " eliminado");
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
