package net.ibk.clientes.controller;

import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Optional<Cliente> getCliente(@PathVariable(value ="id") String id){
        return clienteRepository.findById(id);
    }

    @PutMapping("/cliente/{id}")
    public void updateCliente(@PathVariable(value ="id") String id,
                              @RequestBody Cliente clienteN){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        cliente.get().setTipoDocumento(clienteN.getTipoDocumento());
        cliente.get().setNumeroDocumento(clienteN.getNumeroDocumento());
        cliente.get().setNombres(clienteN.getNombres());
        cliente.get().setApellidos(clienteN.getApellidos());
        //clienteRepository.save(cliente);

    }
}
