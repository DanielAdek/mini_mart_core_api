package com.minimart.core.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minimart.core.json.JsonResponseEntity;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
  private final AuthenticationService service;

  /**
   * @param customer
   * @return
   */
  @PostMapping("/register")
  public ResponseEntity<JsonResponseEntity<Object>>registration(
    @RequestBody() AuthRegisterRequest customer
  ) {
    JsonResponseEntity<Object>createdCustomer = service.registerCustomer(customer);
    return ResponseEntity.status(createdCustomer.getStatusCode()).body(createdCustomer);
  }

  /**
   * @param user
   * @return
   */
  @PostMapping("/login")
  public ResponseEntity<JsonResponseEntity<Object>>authenticate(
    @RequestBody() AuthenticationRequest userRequest
  ) {
    JsonResponseEntity<Object>user = service.authenticate(userRequest);
    return ResponseEntity.status(user.getStatusCode()).body(user);
  }
}
