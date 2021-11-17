package com.misiontic.backend_desarrollo_de_software.service;

import com.misiontic.backend_desarrollo_de_software.model.Cliente;
import com.misiontic.backend_desarrollo_de_software.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente guardarCliente(Cliente c) {
        return clienteRepository.save(c);
    }

    public Collection<Cliente> buscarTodosLosClientes() {
        return clienteRepository.findAll();
    }
}
