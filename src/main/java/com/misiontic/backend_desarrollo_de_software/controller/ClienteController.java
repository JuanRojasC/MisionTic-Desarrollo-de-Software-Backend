package com.misiontic.backend_desarrollo_de_software.controller;

import com.misiontic.backend_desarrollo_de_software.model.Cliente;
import com.misiontic.backend_desarrollo_de_software.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Client")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {this.clienteService = clienteService;}

    @GetMapping("/all")
    public ResponseEntity<?> buscarTodosLosClientes(){
        return ResponseEntity.ok(clienteService.buscarTodosLosClientes());
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente c){
        return ResponseEntity.ok(clienteService.guardarCliente(c));
    }
}
