package net.ibk.clientes.service;

import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.model.ClienteDTO;
import net.ibk.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> getClientes() {
        return clienteRepository.getClientes();
    }

    public Optional<Cliente> getCliente(String codigoUnico) {
        return clienteRepository.findClientesByCodigoUnico(codigoUnico);
    }

    public void updateCliente(String codigoUnico, Cliente clienteN) {
        if (verificarCliente(clienteN)) {
            Optional<Cliente> cliente = clienteRepository.findClientesByCodigoUnico(codigoUnico);
            if (cliente.isPresent()) {
                cliente.get().setIdTipoDocumento(clienteN.getIdTipoDocumento());
                cliente.get().setNumeroDocumento(clienteN.getNumeroDocumento());
                cliente.get().setNombres(clienteN.getNombres());
                cliente.get().setApellidos(clienteN.getApellidos());
                clienteRepository.save(cliente.get());
            }
            else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        } else {
            throw new IllegalStateException("Error: Datos de Cliente Incompletos");
        }
    }

    private boolean verificarCliente(Cliente cliente) {
        return cliente.getApellidos().length() != 0 &&
                cliente.getNombres().length() != 0 &&
                cliente.getNumeroDocumento().length() != 0 &&
                cliente.getIdTipoDocumento() >= 1 &&
                cliente.getIdTipoDocumento() <= 3;
    }
}
