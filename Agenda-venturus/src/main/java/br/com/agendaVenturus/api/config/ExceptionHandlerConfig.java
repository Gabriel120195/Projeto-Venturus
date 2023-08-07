package br.com.agendaVenturus.api.config;


import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerConfig {
    @Getter
    @AllArgsConstructor
    public static class Errors{

        private final String mensagem;
        private final LocalDateTime dataHora;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Errors handleIllegalArgumentException(final HttpServletRequest request, final IllegalArgumentException exception){
        return new Errors(exception.getMessage(), LocalDateTime.now());
    }
}
