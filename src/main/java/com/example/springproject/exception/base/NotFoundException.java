package com.example.springproject.exception.base;

public class NotFoundException extends BaseException {
  public NotFoundException() {
    setCode("com.example.springproject.exception;.base.NotFoundException");
    setStatus(StatusConstants.NOT_FOUND);
  }
}