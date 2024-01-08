package com.example.springproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a response dto (data transfer object) class contains user information
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
  private String id;
  private String username;
  private String password;
  private String email;
  private String phone;
  private String role;
}