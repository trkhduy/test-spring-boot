package com.example.springproject.controller;


import com.example.springproject.dto.base.ResponseGeneral;
import com.example.springproject.dto.response.UserResponse;
import com.example.springproject.service.UserService;
import com.example.springproject.service.base.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.example.springproject.constant.Constants.CommonConstants.DEFAULT_LANGUAGE;
import static com.example.springproject.constant.Constants.CommonConstants.LANGUAGE;
import static com.example.springproject.constant.Constants.MessageCode.GET_USER_BY_ID;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
  private final UserService userService;
  private final MessageService messageService;

  @GetMapping("/{id}")
  public ResponseGeneral<UserResponse> getById(
        @PathVariable Long id,
        @RequestHeader(name = LANGUAGE, defaultValue = "vi") String language

  ) {
    return ResponseGeneral.ofSuccess(messageService.getMessage(GET_USER_BY_ID, language),
          userService.getById(id));
  }
}