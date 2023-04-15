package com.minimart.core.json;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonResponseEntity<T> {
  private Boolean status;
  private Boolean error;
  private HttpStatus statusCode;
  private String message;
  private T data;
  private String token;
}
