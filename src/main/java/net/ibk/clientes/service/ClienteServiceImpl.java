package net.ibk.clientes.service;

import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.model.ClienteDTO;
import net.ibk.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> getClientes() {
        List<ClienteDTO> resultado = clienteRepository.getClientes(); //return clienteRepository.getClientes();
        return resultado;
    }

    @Override
    public Optional<ClienteDTO> getCliente(String codigoUnico) {
        Optional<ClienteDTO> resultado = clienteRepository.findClientesByCodigoUnico(encriptar(codigoUnico));
        return resultado;
    }

    @Override
    public String updateCliente(String codigoUnico, Cliente clienteN) {
        if (verificarCliente(clienteN)) {
            Optional<Cliente> cliente = clienteRepository.findClienteBeforeUpdateByCodigoUnico(encriptar(codigoUnico));
            if (cliente.isPresent()) {
                cliente.get().setTipoDocumento(clienteN.getTipoDocumento());
                cliente.get().setNumeroDocumento(clienteN.getNumeroDocumento());
                cliente.get().setNombres(clienteN.getNombres());
                cliente.get().setApellidos(clienteN.getApellidos());
                clienteRepository.save(cliente.get());
                return "200";
            }
            else {
                return "404";
            }
        } else {
            return "406";
        }
    }

    @Override
    public String getEncriptado(String cadena) {
        return encriptar(cadena);
    }

    private boolean verificarCliente(Cliente cliente) {
        return cliente.getApellidos().length() != 0 &&
                cliente.getNombres().length() != 0 &&
                cliente.getNumeroDocumento().length() != 0 &&
                cliente.getTipoDocumento().getIdTipoDocumento() >= 1 &&
                cliente.getTipoDocumento().getIdTipoDocumento() <= 3;
    }

    private String encriptar(String cadena)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cadena.length(); i++)
            sb.append((char)(cadena.charAt(i) ^ (i) ^ (64)));
        return(sb.toString());
    }

}
