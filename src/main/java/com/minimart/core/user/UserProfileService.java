package com.minimart.core.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.minimart.core.auth.AuthenticationResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProfileService {
  private final UserRepository repository;

  public AuthenticationResponse<Object> getUsers() {
    Optional<List<User>> users = repository.findByQueryCustomers();
    return AuthenticationResponse.builder()
        .status(true)
        .statusCode(HttpStatus.OK)
        .message("Successful")
        .data(users)
        .build();
  }

  public AuthenticationResponse<Object> getUserById(UUID customerId) {
    Optional<User> customer = repository.findByQueryCustomer(customerId);
    if (customer == null || customer.isEmpty()) {
      return AuthenticationResponse.builder()
          .status(false)
          .statusCode(HttpStatus.NOT_FOUND)
          .message("No Found!")
          .data(null)
          .build();
    }
    return AuthenticationResponse.builder()
        .status(true)
        .statusCode(HttpStatus.OK)
        .message("Successful!")
        .data(customer)
        .build();
  }

  public AuthenticationResponse<?> removeUser(UUID customerId) {
    repository.deleteByQueryCustomer(customerId);
    return AuthenticationResponse.builder()
        .status(true)
        .statusCode(HttpStatus.NO_CONTENT)
        .message("User with " + customerId + " deleted successfully")
        .data(null)
        .build();
  }
}
