package com.example.springproject.service.impl;

import com.example.springproject.dto.base.PageResponse;
import com.example.springproject.dto.request.UserRequest;
import com.example.springproject.dto.response.UserResponse;
import com.example.springproject.exception.UserNotFoundException;
import com.example.springproject.repository.UserRepository;
import com.example.springproject.service.UserService;

public class UserServiceImpl implements UserService {
  private final UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public UserResponse getById(Long id) {
    UserResponse user = repository.getByUserId(id);
    if (user != null)
      return user;
    else
      throw new UserNotFoundException();
  }

  @Override
  public UserResponse create(UserRequest request) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public PageResponse<UserResponse> list(String keyword, int size, int page, boolean isAll) {
    return null;
  }
}