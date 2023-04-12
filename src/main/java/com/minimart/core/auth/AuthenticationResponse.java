package com.minimart.core.auth;

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
  private Integer statusCode;
  private String message;
  private T Data;
}
