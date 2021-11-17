/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.backend_desarrollo_de_software.service;

/**
 *
 * @author Iván Dueñas
 */

import com.misiontic.backend_desarrollo_de_software.model.SalonFiesta;
import com.misiontic.backend_desarrollo_de_software.repository.SalonFiestaRepository;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Iván Dueñas
 */
@Service
public class SalonFiestaService {
   
    private SalonFiestaRepository salonFiestaRepository;
    
    @Autowired
    public SalonFiestaService(SalonFiestaRepository salonFiestaRepository) {
        this.salonFiestaRepository = salonFiestaRepository;
    }
    
    public SalonFiesta buscarPorId(Long id){
        Optional<SalonFiesta> salonFiesta = salonFiestaRepository.findById(id);
        if(salonFiesta.isEmpty()){
            return null;
        }
        return salonFiesta.get();
    }

    public SalonFiesta guardarSalonFiesta(SalonFiesta c){
        return salonFiestaRepository.save(c);
    }
    
    public SalonFiesta actualizarSalonFiesta(SalonFiesta c){
        if(buscarPorId(c.getId()) != null){
            return salonFiestaRepository.save(c);
        }
        return null;
    }

    public void eliminarSalonFiestaPorId(Long id){
        salonFiestaRepository.deleteById(id);
    }
    
    public Collection<SalonFiesta> buscarTodosLosSalones(){
        return salonFiestaRepository.findAll();
    }
}
