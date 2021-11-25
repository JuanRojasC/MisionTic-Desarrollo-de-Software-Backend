package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Cliente;
import com.misiontic.backend_desarrollo_de_software.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin
public class ClienteController {

     private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {this.clienteService = clienteService;}

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Cliente> buscarTodasLosClientes(){
        return clienteService.buscarTodosLosClientes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente c){
        clienteService.guardarCliente(c);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente actualizarCliente(@RequestBody Cliente c){
        return clienteService.actualizarCliente(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean eliminarCliente(@PathVariable Long id){
        return clienteService.eliminarClientePorId(id);
    }
}
