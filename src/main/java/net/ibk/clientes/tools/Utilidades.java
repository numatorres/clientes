package net.ibk.clientes.tools;

import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.model.TipoDocumento;
import net.ibk.clientes.repository.ClienteRepository;
import net.ibk.clientes.repository.TipoDocumentoRepository;
import org.springframework.context.ConfigurableApplicationContext;

public class Utilidades {
    public static void generarDatos(ConfigurableApplicationContext cac){

        ClienteRepository clienteRepository = cac.getBean(ClienteRepository.class);
        TipoDocumentoRepository tipoDocumentoRepository = cac.getBean(TipoDocumentoRepository.class);

        tipoDocumentoRepository.save(new TipoDocumento("DNI"));
        tipoDocumentoRepository.save(new TipoDocumento("CARNET EXTRANJERIA"));
        tipoDocumentoRepository.save(new TipoDocumento("PASAPORTE"));

        clienteRepository.save(new Cliente("00000001", "12312312", "JUAN PABLO", "PEREZ MARTINEZ",1L));
        clienteRepository.save(new Cliente("00000002", "32132132", "ANA MARIA", "RAMIREZ TORRES",1L));
        clienteRepository.save(new Cliente("00000003", "003344556", "ANTONIO RAMIRO", "FERNANDEZ VIVAS",2L));
        clienteRepository.save(new Cliente("00000004", "33445511", "CARLOS ALBERTO", "LABRADOR MOLINA",1L));
        clienteRepository.save(new Cliente("00000005", "67452399", "VANESSA ANDREINA", "QUISPE FLORES",1L));
        clienteRepository.save(new Cliente("00000006", "856342223", "MOHAMED HASSAN", "SAFWAT ZAYED",3L));

    }

}
