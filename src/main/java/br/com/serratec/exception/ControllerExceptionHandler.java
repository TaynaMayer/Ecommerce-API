package br.com.serratec.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.serratec.status.StatusMessage;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmailException.class)
	public ResponseEntity<Object> handleEmailException(EmailException ex) {
		EmailException emailException = new EmailException(ex.getMessage());
		return ResponseEntity.unprocessableEntity().body(emailException);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex) {
        return ResponseEntity.unprocessableEntity().body("CEP INVALIDO AMIGAO!");
    }
	

	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<StatusMessage> handleResourceOkException2(ResourceOkException ex) {
	        
	        //Aqui eu estou criando o objeto que vai conter as informações da mensagem personalizada.
	        StatusMessage status = new StatusMessage(HttpStatus.OK.value(), "Finalizado", ex.getMessage());

	        //Aqui eu estou devolvendo o erro personalizado para o usuario.
	        return new ResponseEntity<>(status, HttpStatus.OK);
	    }
	    
	    
	    @ExceptionHandler(ResourceOkException.class)
        public ResponseEntity<StatusMessage> handleResourceOkException(ResourceOkException ex) {
            
            //Aqui eu estou criando o objeto que vai conter as informações da mensagem personalizada.
            StatusMessage status = new StatusMessage(HttpStatus.OK.value(), "Nao Finalizado", ex.getMessage());

            //Aqui eu estou devolvendo o erro personalizado para o usuario.
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
	
	
}
