package com.project.dmcapp.exception;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.dmcapp.model.Msg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("Start");
		
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		
        body.put("timestamp", new Date());
        body.put("status code", status.value());
        body.put("status", status.getReasonPhrase());
        
        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);
        
        log.info("End");
        
        return new ResponseEntity<>(body, headers, status);
	}
	
	/*
	 * @ExceptionHandler(ItemAlreadyPresentInCartException.class)
	 * 
	 * @ResponseStatus(code = HttpStatus.CONFLICT) public ResponseEntity<?>
	 * itemAlreadyPresentInCartException(ItemAlreadyPresentInCartException exp) {
	 * log.error(exp.getMessage());
	 * 
	 * return ResponseEntity.badRequest() .body(new Msg(HttpStatus.CONFLICT,
	 * LocalDateTime.now(), exp.getMessage())); }
	 */
	
	@ExceptionHandler(UnauthorisedException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public ResponseEntity<?> unauthorisedException(UnauthorisedException exp) {
		log.error(exp.getMessage());
		
		return ResponseEntity.badRequest()
				.body(new Msg(HttpStatus.UNAUTHORIZED, LocalDateTime.now(), exp.getMessage()));
	}
	
	@ExceptionHandler(BookingNotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> menuItemNotFoundException(BookingNotFoundException exp) {
		log.error(exp.getMessage());
		
		return ResponseEntity.badRequest()
				.body(new Msg(HttpStatus.BAD_REQUEST, LocalDateTime.now(), exp.getMessage()));
	}
	
	/*
	 * @ExceptionHandler(NotRemovedFromCartException.class)
	 * 
	 * @ResponseStatus(code = HttpStatus.REQUEST_TIMEOUT) public ResponseEntity<?>
	 * notRemovedFromCartException(NotRemovedFromCartException exp) {
	 * log.error(exp.getMessage());
	 * 
	 * return ResponseEntity.badRequest() .body(new Msg(HttpStatus.REQUEST_TIMEOUT,
	 * LocalDateTime.now(), exp.getMessage())); }
	 */
	
	@ExceptionHandler(SignupUnsuccessfullException.class)
	@ResponseStatus(code = HttpStatus.REQUEST_TIMEOUT)
	public ResponseEntity<?> signupUnsuccessfullException(SignupUnsuccessfullException exp) {
		log.error(exp.getMessage());
		
		return ResponseEntity.badRequest()
				.body(new Msg(HttpStatus.REQUEST_TIMEOUT, LocalDateTime.now(), exp.getMessage()));
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ResponseEntity<?> UserAlreadyExistsException(UserAlreadyExistsException exp) {
		log.error(exp.getMessage());
		
		return ResponseEntity.badRequest()
				.body(new Msg(HttpStatus.CONFLICT, LocalDateTime.now(), exp.getMessage()));
	}
}