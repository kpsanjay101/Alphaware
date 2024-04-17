package com.alphaware.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@RestControllerAdvice
public class GlobaleExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorFormat> noHandlerFoundException(NoHandlerFoundException ex, WebRequest wr){
		
		MyErrorFormat ef = new MyErrorFormat();
		ef.setMessage(ex.getMessage());
		ef.setDescription(wr.getDescription(false));
		ef.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ef, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UsersException.class)
	public ResponseEntity<MyErrorFormat> noUsersFoundException(UsersException ex, WebRequest wr){
		
		MyErrorFormat ef = new MyErrorFormat();
		ef.setMessage(ex.getMessage());
		ef.setDescription(wr.getDescription(false));
		ef.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorFormat> noCategoryFoundException(CategoryException ex, WebRequest wr){
		
		MyErrorFormat ef = new MyErrorFormat();
		ef.setMessage(ex.getMessage());
		ef.setDescription(wr.getDescription(false));
		ef.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CommentException.class)
	public ResponseEntity<MyErrorFormat> noCommentFoundException(CommentException ex, WebRequest wr){
		
		MyErrorFormat ef = new MyErrorFormat();
		ef.setMessage(ex.getMessage());
		ef.setDescription(wr.getDescription(false));
		ef.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PostsException.class)
	public ResponseEntity<MyErrorFormat> noCommentFoundException(PostsException ex, WebRequest wr){
		
		MyErrorFormat ef = new MyErrorFormat();
		ef.setMessage(ex.getMessage());
		ef.setDescription(wr.getDescription(false));
		ef.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ef, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorFormat> noExceptionFoundException(Exception ex, WebRequest wr){
		
		MyErrorFormat ef = new MyErrorFormat();
		ef.setMessage(ex.getMessage());
		ef.setDescription(wr.getDescription(false));
		ef.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(ef, HttpStatus.NOT_FOUND);
	}
}
