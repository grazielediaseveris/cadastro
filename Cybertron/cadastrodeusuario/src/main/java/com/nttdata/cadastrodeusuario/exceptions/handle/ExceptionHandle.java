package com.vyttor.cadastrocontas.exceptions.handle;

import com.vyttor.cadastrocontas.exceptions.ClienteJaRegistradoEmOutraContaException;
import com.vyttor.cadastrocontas.exceptions.ClienteNaoEncontradoException;
import com.vyttor.cadastrocontas.exceptions.IdadeNaoPermitidaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(IdadeNaoPermitidaException.class)
    public ResponseEntity<DefaultException> handle(IdadeNaoPermitidaException exception){
        DefaultException defaultException = new DefaultException();

        defaultException.setMsg( exception.getMessage() );
        defaultException.setDataHora(LocalTime.now());

        return ResponseEntity.unprocessableEntity().body(defaultException);
    }

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<DefaultException> handle(ClienteNaoEncontradoException exception){
        DefaultException defaultException = new DefaultException();

        defaultException.setMsg( exception.getMessage() );
        defaultException.setDataHora(LocalTime.now());

        return ResponseEntity.unprocessableEntity().body(defaultException);
    }

    @ExceptionHandler(ClienteJaRegistradoEmOutraContaException.class)
    public ResponseEntity<DefaultException> handle(ClienteJaRegistradoEmOutraContaException exception){
        DefaultException defaultException = new DefaultException();

        defaultException.setMsg( exception.getMessage() );
        defaultException.setDataHora(LocalTime.now());

        return ResponseEntity.unprocessableEntity().body(defaultException);
    }

//    ClienteNaoEncontradoException
//    ClienteJaRegistradoEmOutraContaException
}
