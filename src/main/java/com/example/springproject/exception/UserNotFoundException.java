package com.example.springproject.exception;

import com.example.springproject.exception.base.NotFoundException;

public class UserNotFoundException extends NotFoundException {
  public UserNotFoundException() {
    setCode("com.example.springproject.exception.base.NotFoundException.UserNotFoundException");
  }
}