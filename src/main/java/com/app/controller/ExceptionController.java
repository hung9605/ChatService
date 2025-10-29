package com.app.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.constants.AppHttpStatus;
import com.app.constants.CommonConstant;
import com.app.dto.ResponseBean;
import lombok.RequiredArgsConstructor;

	@RestControllerAdvice
	@RequiredArgsConstructor
	public class ExceptionController extends BaseController {
		
	    public final MessageSource messageSource;
		
		 @ExceptionHandler(Exception.class)
		 public ResponseEntity<?> handle(Exception ex) {
			 ResponseBean mapping = ERROR_MAP.entrySet().stream()
				        .filter(e -> e.getKey().isInstance(ex))
				        .map(Map.Entry::getValue)
				        .findFirst()
				        .orElse(new ResponseBean("","error.field.blank",AppHttpStatus.INTERNAL_SERVER_ERROR));
		        String message = messageSource.getMessage(mapping.getMessage(), null, Locale.getDefault());
		        mapping.setMessage(message);
		        return responseError(mapping, ex);
		 }
		 
		 private static final Map<Class<? extends Exception>, ResponseBean> ERROR_MAP = Map.of(			     
			        MethodArgumentNotValidException.class,new ResponseBean(CommonConstant.ERROR,"error.field.blank",AppHttpStatus.INTERNAL_SERVER_ERROR)
		 );
		

	
}
