package net.ibk.clientes.tools;

import net.ibk.clientes.model.Cliente;
import net.ibk.clientes.repository.ClienteRepository;
import org.springframework.context.ConfigurableApplicationContext;

public class Utilidades {
    public static void generarDatos(ConfigurableApplicationContext cac){
        ClienteRepository clienteRepository = cac.getBean(ClienteRepository.class);
        clienteRepository.save(new Cliente("d731da63040a","DNI", "12312312", "JUAN PABLO", "PEREZ MARTINEZ"));
        clienteRepository.save(new Cliente("a94d7c280d9e","DNI", "32132132", "ANA MARIA", "RAMIREZ TORRES"));
        clienteRepository.save(new Cliente("cf5832b8dd70","CE", "003344556", "ANTONIO RAMIRO", "FERNANDEZ VIVAS"));
        clienteRepository.save(new Cliente("b580cf37c367","DNI", "33445511", "CARLOS ALBERTO", "LABRADOR MOLINA"));
        clienteRepository.save(new Cliente("fdaeef4a92af","DNI", "67452399", "VANESSA ANDREINA", "QUISPE FLORES"));
        clienteRepository.save(new Cliente("ebfafaeb43a0","PASAPORTE", "856342223", "MOHAMED HASSAN", "SAFWAT ZAYED"));
    }

}
