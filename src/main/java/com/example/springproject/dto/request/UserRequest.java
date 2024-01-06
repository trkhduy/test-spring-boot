package com.example.springproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
  private Long id;
  private String username;
  private String password;
  private String email;
  private String phone;
  private String role;
}