package com.example.springproject.service;


import com.example.springproject.dto.base.PageResponse;
import com.example.springproject.dto.request.UserRequest;
import com.example.springproject.dto.response.UserResponse;

public interface UserService {
  UserResponse getById(String id);
  UserResponse create(UserRequest request);
  void delete(Long id);
  PageResponse<UserResponse> list (String keyword, int size, int page, boolean isAll);
}