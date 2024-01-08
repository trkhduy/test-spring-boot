package com.example.springproject.exception.base;

import static com.example.springproject.constant.ExceptionCode.BAD_REQUEST_CODE;

public class BadRequestException extends BaseException {
  public BadRequestException() {
    setCode(BAD_REQUEST_CODE);
    setStatus(StatusConstants.BAD_REQUEST);
  }
}