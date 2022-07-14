package net.ibk.clientes.tools;

import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.model.TipoDocumento;
import net.ibk.clientes.repository.ClienteRepository;
import net.ibk.clientes.repository.TipoDocumentoRepository;
import org.springframework.context.ConfigurableApplicationContext;

public class Utilidades {
    public static void generarDatos(ConfigurableApplicationContext cac) {

        ClienteRepository clienteRepository = cac.getBean(ClienteRepository.class);
        TipoDocumentoRepository tipoDocumentoRepository = cac.getBean(TipoDocumentoRepository.class);

        tipoDocumentoRepository.save(new TipoDocumento("DNI"));
        tipoDocumentoRepository.save(new TipoDocumento("CARNET EXTRANJERIA"));
        tipoDocumentoRepository.save(new TipoDocumento("PASAPORTE"));

        clienteRepository.save(new Cliente("00000001", "12312312", "JUAN PABLO", "PEREZ MARTINEZ", new TipoDocumento(1L)));
        clienteRepository.save(new Cliente("00000022", "32132132", "ANA MARIA", "RAMIREZ TORRES", new TipoDocumento(1L)));
        clienteRepository.save(new Cliente("00000333", "003344556", "ANTONIO RAMIRO", "FERNANDEZ VIVAS", new TipoDocumento(2L)));
        clienteRepository.save(new Cliente("00004444", "33445511", "CARLOS ALBERTO", "LABRADOR MOLINA", new TipoDocumento(1L)));
        clienteRepository.save(new Cliente("00055555", "67452399", "VANESSA ANDREINA", "QUISPE FLORES", new TipoDocumento(1L)));
        clienteRepository.save(new Cliente("00666666", "856342223", "MOHAMED HASSAN", "SAFWAT ZAYED", new TipoDocumento(3L)));
    }

}
