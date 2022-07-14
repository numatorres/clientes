package net.ibk.clientes.controller;

import net.ibk.clientes.exception.NotFoundException;
import net.ibk.clientes.exception.NotValidArgumentsException;
import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.model.ClienteDTO;
import net.ibk.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> clientes = clienteService.getClientes();
        return new ResponseEntity<List<ClienteDTO>>(clientes, HttpStatus.OK);
    }

    @GetMapping(value = "/cliente/{codigoUnico}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCliente(@PathVariable(value = "codigoUnico") String codigoUnico) {
        Optional<ClienteDTO> cliente = clienteService.getCliente(codigoUnico);
        return new ResponseEntity<Object>(cliente, HttpStatus.OK);
    }

    @PutMapping(value = "/cliente/{codigoUnico}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "codigoUnico") String codigoUnico,
                                                @RequestBody Cliente clienteN) throws NotValidArgumentsException, NotFoundException {
        clienteService.updateCliente(codigoUnico, clienteN);
        return new ResponseEntity<Object>("OK",HttpStatus.OK);
    }

    @GetMapping(value = "/encriptado/{cadena}")
    public ResponseEntity<String> getEncriptado(@PathVariable(value = "cadena") String cadena) {
        String resultado = clienteService.getEncriptado(cadena);
        return new ResponseEntity<String>(resultado,HttpStatus.OK);
    }
}
