package com.minimart.core.user;

import java.util.List;
import java.util.Optional;

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
          .statusCode(200)
          .message("Successful")
          .data(users)
          .build();
  }
}
