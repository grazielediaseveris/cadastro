package com.nttdata.cadastrodeusuario.exceptions.handle;

import com.nttdata.cadastrodeusuario.exceptions.EmailNãoEncontradoException;
import com.nttdata.cadastrodeusuario.exceptions.SenhaNãoEncontradaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(EmailNãoEncontradoException.class)
    public ResponseEntity<com.nttdata.cadastrodeusuario.exceptions.handle.DefaultException> handle(EmailNãoEncontradoException exception){
        com.nttdata.cadastrodeusuario.exceptions.handle.DefaultException defaultException = new com.nttdata.cadastrodeusuario.exceptions.handle.DefaultException();

        defaultException.setMsg( exception.getMessage() );
        defaultException.setDataHora(LocalTime.now());

        return ResponseEntity.unprocessableEntity().body(defaultException);
    }

    @ExceptionHandler(SenhaNãoEncontradaException.class)
    public ResponseEntity<com.nttdata.cadastrodeusuario.exceptions.handle.DefaultException> handle(SenhaNãoEncontradaException exception){
        com.nttdata.cadastrodeusuario.exceptions.handle.DefaultException defaultException = new com.nttdata.cadastrodeusuario.exceptions.handle.DefaultException();

        defaultException.setMsg( exception.getMessage() );
        defaultException.setDataHora(LocalTime.now());

        return ResponseEntity.unprocessableEntity().body(defaultException);
    }

}
