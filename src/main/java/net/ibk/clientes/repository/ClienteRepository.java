package net.ibk.clientes.repository;

import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.model.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    @Query("SELECT t.tipoDocumento as tipoDocumento, c.numeroDocumento as numeroDocumento, c.codigoUnico as codigoUnico, c.nombres as nombres, c.apellidos as apellidos FROM Cliente c JOIN TipoDocumento t ON c.tipoDocumento.idTipoDocumento = t.idTipoDocumento WHERE c.codigoUnico=:codigoUnico ORDER BY c.apellidos")
    Optional<ClienteDTO> findClientesByCodigoUnico(String codigoUnico);

    Optional<Cliente> findClienteBeforeUpdateByCodigoUnico(String codigoUnico);

    @Query("SELECT t.tipoDocumento as tipoDocumento, c.numeroDocumento as numeroDocumento, c.codigoUnico as codigoUnico, c.nombres as nombres, c.apellidos as apellidos FROM Cliente c JOIN TipoDocumento t ON c.tipoDocumento.idTipoDocumento = t.idTipoDocumento ORDER BY c.apellidos")
    List<ClienteDTO> getClientes();

}
