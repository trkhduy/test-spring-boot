package com.example.springproject.service;


import com.example.springproject.dto.base.PageResponse;
import com.example.springproject.dto.request.UserRequest;
import com.example.springproject.dto.response.UserResponse;

public interface UserService {
  UserResponse getById(String id);
  UserResponse create(UserRequest request);
  void delete(String id);
  PageResponse<UserResponse> getAllUser(int size, int page);
  PageResponse<UserResponse> getUserBySearch(String keyword, int size, int page);

}