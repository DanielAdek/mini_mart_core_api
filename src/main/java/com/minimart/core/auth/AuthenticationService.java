package com.minimart.core.auth;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minimart.core.configs.secure.JwtService;
import com.minimart.core.json.JsonResponseEntity;
import com.minimart.core.user.User;
import com.minimart.core.user.UserRepository;
import com.minimart.core.user.UserRole;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;

  /**
   * @param regReqData
   * @return
   */
  public JsonResponseEntity<Object>registerCustomer(AuthRegisterRequest regReqData) {
    try {
      var user = User.builder()
        .firstName(regReqData.getFirstName())
        .lastName(regReqData.getLastName())
        .email(regReqData.getEmail())
        .phone(regReqData.getPhone())
        .password(passwordEncoder.encode(regReqData.getPassword()))
        .role(UserRole.CUSTOMER)
        .build();

      User new_user = repository.createCustomerByQuery(user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getPassword(), user.getRole().name());

      var token = jwtService.generateToken(new_user);

      return JsonResponseEntity.builder().status(true).statusCode(HttpStatus.OK)
        .message("Successful").data(new_user).token(token).build();

    } catch (Exception e) {
      return JsonResponseEntity.builder().error(true).statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
          .message("Error: " + e.getMessage()).build(); 
    }
  }

  public JsonResponseEntity<Object>authenticate(AuthenticationRequest auth) {
    try {
      User user = repository.findByEmailQueryCustomer(auth.getEmail());

      var jwt = jwtService.generateToken(user);
      
      return JsonResponseEntity.builder().status(true).statusCode(HttpStatus.OK)
      .message("Successful").data(user).token(jwt).build();

    } catch (Exception e) {
      return JsonResponseEntity.builder().error(true).statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
          .message("Error: " + e.getMessage()).build(); 
    }
  }
}
