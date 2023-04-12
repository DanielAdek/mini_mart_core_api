package com.minimart.core.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minimart.core.auth.AuthenticationResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserProfileController {
  private final UserProfileService service;

  @GetMapping
  public ResponseEntity<AuthenticationResponse<Object>> getAllUsers() {
    return ResponseEntity.ok(service.getUsers());
  }
}
