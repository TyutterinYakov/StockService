package stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public ResponseEntity<?> handleNotFound(Exception ex){
		return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
	}
}
