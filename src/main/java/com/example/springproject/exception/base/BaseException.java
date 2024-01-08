package com.example.springproject.exception.base;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.example.springproject.constant.CommonConstants.*;

@Data
public class BaseException extends RuntimeException {
  private String message;
  private String code;
  private int status;
  private Map<String, String> params;

  public BaseException() {
    this.status = DEFAULT_STATUS;
    this.code = BLANK_CONSTANT;
    this.message = BLANK_CONSTANT;
    this.params = new HashMap<>();
  }

  public void addParam(String key, String value) {
    if (Objects.isNull(params)) {
      params = new HashMap<>();
    }
    params.put(key, value);
  }
}