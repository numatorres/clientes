package net.ibk.clientes;

import net.ibk.clientes.tools.Utilidades;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClientesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(ClientesApplication.class , args);
        Utilidades.generarDatos(cac);
    }

}
