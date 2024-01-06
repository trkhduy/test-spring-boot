package com.example.springproject.exception.advice;

import com.example.springproject.utils.DateUtils;
import com.example.springproject.exception.base.BaseException;
import com.example.springproject.exception.base.ErrorResponse;
import com.example.springproject.exception.base.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.springproject.exception.base.Error;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerAdvice {
  private final MessageSource messageSource;

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<Map<String, Object>> handleBaseException(BaseException ex) {
    Map<String, Object> response = new HashMap<>();
    response.put("code", ex.getCode());
    response.put("message", ex.getMessage());
    response.put("status", ex.getStatus());
    response.put("params", ex.getParams());
    return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getStatus()));
  }

//  @ExceptionHandler(NotFoundException.class)
//  @ResponseStatus(HttpStatus.NOT_FOUND)
//  public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException ex) {
//    Map<String, Object> response = new HashMap<>();
//    response.put("code", ex.getCode());
//    response.put("message", ex.getMessage());
//    response.put("status", ex.getStatus());
//    response.put("params", ex.getParams());
//    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
    Map<String, Object> response = new HashMap<>();
    response.put("code", "INTERNAL_SERVER_ERROR");
    response.put("message", "Internal Server Error");
    response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex, Locale locale) {
    return getError(ex, locale);
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex, Locale locale) {
    return getError(ex, locale);
  }

  public ResponseEntity<ErrorResponse> getError(BaseException ex, Locale locale) {
    Error error = new Error(ex.getCode(), ex.getMessage());
    ErrorResponse response = new ErrorResponse(ex.getStatus(), getMessage("error." + ex.getCode(), locale), error, DateUtils.getCurrentDateString());
    return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getStatus()));
  }

  private String getMessage(String code, Locale locale, Map<String, String> params) {
    var message = getMessage(code, locale);
    if (params != null && !params.isEmpty()) {
      for (var param : params.entrySet()) {
        message = message.replace(getMessageParamsKey(param.getKey()), param.getValue());
      }
    }
    return message;
  }
  private String getMessage(String code, Locale locale) {
    try {
      return messageSource.getMessage(code, null, locale);
    } catch (Exception ex) {
      return code;
    }
  }

  private String getMessageParamsKey(String key) {
    return "%" + key + "%";
  }
}

