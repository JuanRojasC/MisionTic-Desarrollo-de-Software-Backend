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

import com.misiontic.backend_desarrollo_de_software.model.Salon de Fiesta;
import com.misiontic.backend_desarrollo_de_software.model.SalonFiesta;
import com.misiontic.backend_desarrollo_de_software.repository.SalonFiestaRepository;
import java.util.Collection;
import java.util.Optional;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Iván Dueñas
 */
@Service
@Log4j
public class SalonFiestaService {
   
    private SalonFiestaRepository salonFiestaRepository;
    
    @Autowired
    public SalonFiestaService(SalonFiestaRepository salonFiestaRepository) {
        this.salonFiestaRepository = salonFiestaRepository;
    }
    
    public SalonFiesta buscarPorId(Long id){
        Optional<SalonFiesta> salonFiesta = salonFiestaRepository.findById(id);
        if(salonFiesta.isEmpty()){
            log.info("Salon de fiesta con id: " + id + " no fue encontrado");
            return null;
        }
        log.info("Salon de fiesta con id: "+ id + " encontrado");
        return salonFiesta.get();
    }

    public SalonFiesta guardarSalonFiesta(SalonFiesta c){
        try{
            SalonFiesta salonFiesta = salonFiestaRepository.save(c);
            log.info("Salon de Fiesta con id: " + c.getId() + " guardado");
            return  salonFiesta;
        }catch (Exception e){
            log.error("Salon de Fiesta con id: " + c.getId() + " no pudo ser guardo -- ERROR: " + e.getMessage());
            return null;
        }
    }
    
    public SalonFiesta actualizarSalonFiesta(SalonFiesta c){
        if(buscarPorId(c.getId()) != null){
            SalonFiesta salonFiesta = new SalonFiesta();
            try{
                salonFiesta = salonFiestaRepository.save(c);
                log.info("Salon de fiesta con id: " + c.getId() + " actualizado");
            }catch (Exception e){
                log.info("Salon de fiesta con id: " + c.getId() + " no pudo ser actualizado -- ERROR: " + e.getMessage());
            }
            return salonFiesta;
        }
        return null;
    }

    public void eliminarSalonFiestaPorId(Long id){
        log.info("Salon de fiesta con id: " + id + " eliminado");
        salonFiestaRepository.deleteById(id);
    }
    
    public Collection<SalonFiesta> buscarTodosLosSalones(){
        return salonFiestaRepository.findAll();
    }
}
