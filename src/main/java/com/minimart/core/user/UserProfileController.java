package com.minimart.core.user;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minimart.core.auth.AuthenticationResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class UserProfileController {
  private final UserProfileService service;

  @GetMapping
  public ResponseEntity<AuthenticationResponse<Object>>retrieveCustomers() {
    return ResponseEntity.ok(service.getUsers());
  }

  /**
   * @param customerId
   * @return
   */
  @GetMapping(path="{customerId}")
  public ResponseEntity<AuthenticationResponse<Object>>retrieveCustomer(
    @PathVariable("customerId") UUID customerId
  ) {
    AuthenticationResponse<Object> customer = service.getUserById(customerId);
    return ResponseEntity.status(customer.getStatusCode()).body(customer);
  }

  @DeleteMapping(path="{customerId}")
  public ResponseEntity<AuthenticationResponse<?>>deleteCustomer(
    @PathVariable("customerId") UUID customerId
  ) {
    return ResponseEntity.ok(service.removeUser(customerId));
  }
}
