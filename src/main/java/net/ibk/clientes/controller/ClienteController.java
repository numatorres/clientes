package net.ibk.clientes.controller;

import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.model.ClienteDTO;
import net.ibk.clientes.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping(value = "/clientes")
    public ResponseEntity<Object> getAllClientes() {
        List<ClienteDTO> clientes = clienteServiceImpl.getClientes();
        return new ResponseEntity<Object>(clientes, HttpStatus.OK);
    }

    @GetMapping(value = "/cliente/{codigoUnico}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCliente(@PathVariable(value = "codigoUnico") String codigoUnico) {
        Optional<ClienteDTO> cliente = clienteServiceImpl.getCliente(codigoUnico);
        return new ResponseEntity<Object>(cliente, HttpStatus.OK);
    }

    @PutMapping(value = "/cliente/{codigoUnico}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "codigoUnico") String codigoUnico,
                                                @RequestBody Cliente clienteN) {
        String codigo = clienteServiceImpl.updateCliente(codigoUnico, clienteN);
        if (codigo.contains("200")) {
            return new ResponseEntity<Object>("Cliente Actualizado", HttpStatus.OK);
        }
        if (codigo.contains("404")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (codigo.contains("406")) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        return null;
    }

    @GetMapping(value = "/encriptado/{cadena}")
    public ResponseEntity<Object> getEncriptado(@PathVariable(value = "cadena") String cadena) {
        String resultado = clienteServiceImpl.getEncriptado(cadena);
        return new ResponseEntity<Object>(resultado,HttpStatus.OK);
    }
}
