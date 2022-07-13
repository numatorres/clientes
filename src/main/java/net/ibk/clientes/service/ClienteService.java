package net.ibk.clientes.service;

import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.model.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<ClienteDTO> getClientes();

    Optional<ClienteDTO> getCliente(String codigoUnico);

    String updateCliente(String codigoUnico, Cliente clienteN);

    String getEncriptado(String cadena);
}
