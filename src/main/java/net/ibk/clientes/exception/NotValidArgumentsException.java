package net.ibk.clientes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE)
public class NotValidArgumentsException extends Exception{
    public NotValidArgumentsException(String mensaje){
        super(mensaje);
    }
}
