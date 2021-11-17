package com.misiontic.backend_desarrollo_de_software.service;

import com.misiontic.backend_desarrollo_de_software.model.Cliente;
import com.misiontic.backend_desarrollo_de_software.repository.ClienteRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Log4j
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente guardarCliente(Cliente c) {
        try{
            Cliente cliente = clienteRepository.save(c);
            log.info("Cliente con id: " + c.getIdClient() + " guardado");
            return  cliente;
        }catch (Exception e){
            log.error("Cliente con id: " + c.getIdClient() + " no pudo ser guardo -- ERROR: " + e.getMessage());
            return null;
        }
    }

    public Collection<Cliente> buscarTodosLosClientes() {
        log.info("Todos lo clientes han sido buscados");
        return clienteRepository.findAll();
    }
}
