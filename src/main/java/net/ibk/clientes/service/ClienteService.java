package net.ibk.clientes.service;

import net.ibk.clientes.exception.NotFoundException;
import net.ibk.clientes.exception.NotValidArgumentsException;
import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.model.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<ClienteDTO> getClientes();

    Optional<ClienteDTO> getCliente(String codigoUnico);

    void updateCliente(String codigoUnico, Cliente clienteN) throws NotFoundException, NotValidArgumentsException;

    String getEncriptado(String cadena);
}
