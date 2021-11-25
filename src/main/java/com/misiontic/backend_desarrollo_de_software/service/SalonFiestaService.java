/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.backend_desarrollo_de_software.service;
import com.misiontic.backend_desarrollo_de_software.model.SalonFiesta;
import com.misiontic.backend_desarrollo_de_software.repository.SalonFiestaRepository;
import java.util.Collection;
import java.util.Optional;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        log.info("Salon de fiesta con id: "+ id + " ha sido encontrado");
        return salonFiesta.get();
    }

    public SalonFiesta guardarSalonFiesta(SalonFiesta c){
        try{
            SalonFiesta salonFiesta = salonFiestaRepository.save(c);
            log.info("Salon de Fiesta con id: " + c.getId() + " ha sido guardado");
            return  salonFiesta;
        }catch (Exception e){
            log.error("Salon de Fiesta con id: " + c.getId() + " no pudo ser guardado -- ERROR: " + e.getMessage());
            return null;
        }
    }
    
    public SalonFiesta actualizarSalonFiesta(SalonFiesta c){
        Optional<SalonFiesta> salonFiesta = salonFiestaRepository.findById(c.getId());
        if(!salonFiesta.isEmpty()){
            try{
                SalonFiesta salonFiestaEncontrado = salonFiesta.get();
                c.setMessages(salonFiestaEncontrado.getMessages());
                c.setReservations(salonFiestaEncontrado.getReservations());
                c.setCategory(salonFiestaEncontrado.getCategory());
                SalonFiesta salonFiestaRespnse = salonFiestaRepository.save(c);
                log.info("Salon de fiesta con id: " + c.getId() + " ha sido actualizado");
                return salonFiestaRespnse;
            }catch (Exception e){
                log.info("Salon de fiesta con id: " + c.getId() + " no pudo ser actualizado -- ERROR: " + e.getMessage());
            }
        }
        return null;
    }

    public Boolean eliminarSalonFiestaPorId(Long id){
        try{
            salonFiestaRepository.deleteById(id);
            log.info("Salon de fiesta con id: " + id + " ha sido eliminado");
            return true;
        }catch (Exception ex){
            return false;
        }
    }
    
    public Collection<SalonFiesta> buscarTodosLosSalones(){
        log.info("Todos los salones de fiesta han sido buscados");
        return salonFiestaRepository.findAll();
    }
}
