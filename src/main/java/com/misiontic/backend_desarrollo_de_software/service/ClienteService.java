package com.misiontic.backend_desarrollo_de_software.service;

import com.misiontic.backend_desarrollo_de_software.model.Cliente;
import com.misiontic.backend_desarrollo_de_software.repository.ClienteRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Log4j
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarPorId(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            return null;
        }
        log.info("Cliente con id: " + id + " buscada");
        return cliente.get();
    }

    public Cliente guardarCliente(Cliente c) {
        try{
            Cliente cliente = clienteRepository.save(c);
            log.info("Cliente con id: " + c.getIdClient() + " ha sido guardado");
            return  cliente;
        }catch (Exception e){
            log.error("Cliente con id: " + c.getIdClient() + " no pudo ser guardado -- ERROR: " + e.getMessage());
            return null;
        }
    }

    public Cliente actualizarCliente(Cliente c){
        Optional<Cliente> cliente = clienteRepository.findById(c.getIdClient());
        if(!cliente.isEmpty()){
            Cliente clienteEncontrado = cliente.get();
            log.info("Cliente con id: " + c.getIdClient() + " actualizado");
            return clienteRepository.save(c);
        }
        return null;
    }

    public Boolean eliminarClientePorId(Long id){
        try{
            clienteRepository.deleteById(id);
            log.info("Cliente con id: " + id + " eliminado");
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public Collection<Cliente> buscarTodosLosClientes() {
        log.info("Todos lo clientes han sido buscados");
        return clienteRepository.findAll();
    }
}
