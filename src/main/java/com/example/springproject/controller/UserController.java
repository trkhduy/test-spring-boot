package com.example.springproject.controller;


import com.example.springproject.dto.base.PageResponse;
import com.example.springproject.dto.base.ResponseGeneral;
import com.example.springproject.dto.request.UserRequest;
import com.example.springproject.dto.response.UserResponse;
import com.example.springproject.service.UserService;
import com.example.springproject.service.base.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.example.springproject.constant.Constants.CommonConstants.DEFAULT_LANGUAGE;
import static com.example.springproject.constant.Constants.CommonConstants.LANGUAGE;
import static com.example.springproject.constant.Constants.MessageCode.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
  private final UserService userService;
  private final MessageService messageService;

  @GetMapping("/{id}")
  public ResponseGeneral<UserResponse> getById(
        @PathVariable String id,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language

  ) {
    return ResponseGeneral.ofSuccess(messageService.getMessage(GET_USER_BY_ID, language),
          userService.getById(id));
  }
  @PostMapping
  public ResponseGeneral<UserResponse> create(
        @RequestBody UserRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language

  ) {
    return ResponseGeneral.ofCreated(messageService.getMessage(CREATE_USER, language),
          userService.create(request));
  }

  @GetMapping
  public ResponseGeneral<PageResponse<UserResponse>> list(
        @RequestParam(name = "keyword", required = false) String keyword,
        @RequestParam(name = "size", defaultValue = "10") int size,
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "all", defaultValue = "false", required = false) boolean isAll,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(list) keyword: {}, size : {}, page: {}, isAll: {}", keyword, size, page, isAll);
    return ResponseGeneral.ofSuccess(messageService.getMessage(LIST_USER, language),
          userService.list(keyword, size, page, isAll)
    );
  }
}