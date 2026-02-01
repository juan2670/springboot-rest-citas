package com.example.Gestion.de.Citas.presentation.advice;
import com.example.Gestion.de.Citas.presentation.dto.ErrorDto;
import com.example.Gestion.de.Citas.service.exception.RecursoNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler{

    // Manejar errores 404 (Not Found)
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ErrorDto> manejarNoEncontrado(RecursoNoEncontradoException ex){

       ErrorDto error = new ErrorDto(
               ex.getMessage(),
               HttpStatus.NOT_FOUND.value(),
               LocalDateTime.now().toString()
       );

       return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // Manejar errores de Validación (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> manejarValidaciones(MethodArgumentNotValidException ex){

        // Extraemos todos los errores de los campos y los unimos en un solo String
        String mensajesErrores = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorDto error = new ErrorDto(
                mensajesErrores,
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Manejar errores 404 (BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> manejarArgumentoInvalido(IllegalArgumentException ex){

        ErrorDto error = new ErrorDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    // Manejar errores inesperados (Bugs, Base de datos caída, etc.) -> 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> manejarErrorGeneral(Exception ex){

        ex.printStackTrace();

        ErrorDto error = new ErrorDto(
                "Ocurrió un error interno en el servidor. Intente más tarde.",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
