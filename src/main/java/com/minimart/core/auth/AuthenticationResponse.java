package com.minimart.core.auth;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse<T> {
  private Boolean status;
  private HttpStatus statusCode;
  private String message;
  private T data;
}
