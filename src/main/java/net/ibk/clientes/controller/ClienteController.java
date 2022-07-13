package net.ibk.clientes.controller;

import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.model.ClienteDTO;
import net.ibk.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<ClienteDTO> getAllClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/cliente/{codigoUnico}")
    public Optional<Cliente> getCliente(@PathVariable(value = "codigoUnico") String codigoUnico) {
        return clienteService.getCliente(codigoUnico);
    }

    @PutMapping("/cliente/{codigoUnico}")
    public void updateCliente(@PathVariable(value = "codigoUnico") String codigoUnico,
                              @RequestBody Cliente clienteN) {
        clienteService.updateCliente(codigoUnico, clienteN);
    }
}
