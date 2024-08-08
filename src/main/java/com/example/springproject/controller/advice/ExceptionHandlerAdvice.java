package com.example.springproject.controller.advice;

import com.example.springproject.dto.base.ResponseGeneral;
import com.example.springproject.exception.base.BadRequestException;
import com.example.springproject.exception.base.BaseException;
import com.example.springproject.exception.base.ConflictException;
import com.example.springproject.exception.base.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Locale;
import java.util.Map;

import static com.example.springproject.constant.ExceptionCode.BAD_CREDENTIALS_CODE;
import static com.example.springproject.constant.ExceptionCode.GENERIC_CODE;

@RestControllerAdvice
@ControllerAdvice
public class ExceptionHandlerAdvice {
  private final MessageSource messageSource;

  @Autowired
  public ExceptionHandlerAdvice(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ResponseGeneral<Object>> handleBaseException(BaseException ex, Locale locale) {
    String message = getMessage(ex.getCode(), locale, ex.getParams());
    ResponseGeneral<Object> response = ResponseGeneral.of(ex.getStatus(), message, null);
    return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getStatus()));
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ResponseGeneral<Object>> handleNotFoundException(NotFoundException ex, Locale locale) {
    String message = getMessage(ex.getCode(), locale, ex.getParams());
    ResponseGeneral<Object> response = ResponseGeneral.of(ex.getStatus(), message, null);
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ResponseGeneral<Object>> handleBadRequestException(BadRequestException ex, Locale locale) {
    String message = getMessage(ex.getCode(), locale, ex.getParams());
    ResponseGeneral<Object> response = ResponseGeneral.of(ex.getStatus(), message, null);
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(ConflictException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ResponseEntity<ResponseGeneral<Object>> handleConflictException(ConflictException ex, Locale locale) {
    String message = getMessage(ex.getCode(), locale, ex.getParams());
    ResponseGeneral<Object> response = ResponseGeneral.of(ex.getStatus(), message, null);
    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }
  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ResponseGeneral<Object>> handleGenericException(Locale locale) {
    String message = getMessage(GENERIC_CODE, locale, null);
    ResponseGeneral<Object> response = ResponseGeneral.of(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, null);
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  @ExceptionHandler(BadCredentialsException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ResponseGeneral<Object>> handleBadCredentialsException(Locale locale) {
    String message = getMessage(BAD_CREDENTIALS_CODE, locale, null);
    ResponseGeneral<Object> response = ResponseGeneral.of(HttpStatus.BAD_REQUEST.value(), message, null);
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  private String getMessage(String code, Locale locale, Map<String, String> params) {
    try {
      return messageSource.getMessage(code, params != null ? params.values().toArray() : null, locale);
    } catch (Exception e) {
      return code;
    }
  }
}