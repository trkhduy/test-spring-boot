package com.example.springproject.exception;

import com.example.springproject.exception.base.ConflictException;

import static com.example.springproject.constant.ExceptionCode.DUPLICATE_CODE;

public class DuplicateNameException extends ConflictException {
  public DuplicateNameException(){
    setCode(DUPLICATE_CODE);
  }
}
