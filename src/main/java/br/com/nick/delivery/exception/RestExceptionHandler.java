package br.com.nick.quotation.exception;

import br.com.nick.quotation.domain.bean.ErrorQuotation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> handleRunTimeException(RuntimeException ex) {
        ErrorQuotation error = new ErrorQuotation();
        error.setCode("400");
        error.setDescription(ex.getMessage());

        return ResponseEntity.badRequest().body(error);
    }
}
