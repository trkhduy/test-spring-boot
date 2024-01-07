package com.example.springproject.exception.base;

public class BadRequestException extends BaseException {
  public BadRequestException() {
    setCode("com.example.springproject.exception.base.BadRequestException");
    setStatus(StatusConstants.BAD_REQUEST);
  }
}