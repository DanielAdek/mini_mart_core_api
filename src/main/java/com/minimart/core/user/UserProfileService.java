package com.minimart.core.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.minimart.core.json.JsonResponseEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProfileService {
  private final UserRepository repository;

  /**
   * @return JSON
   */
  public JsonResponseEntity<Object> getUsers() {
    try {
      Optional<List<User>> users = repository.findByQueryCustomers();

      return JsonResponseEntity.builder().status(true).statusCode(HttpStatus.OK)
        .message("Successful").data(users).build();

    } catch (Exception e) {
      return JsonResponseEntity.builder().error(true).statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
          .message("Error: " + e.getMessage()).build();
    }
  }

  /**
   * @param customerId
   * @return JSON
   */
  public JsonResponseEntity<Object> getUserById(UUID customerId) {
    try {
      User customer = repository.findByQueryCustomer(customerId);

      if (customer == null)
        return JsonResponseEntity.builder().status(false).statusCode(HttpStatus.NOT_FOUND)
            .message("No Found!").data(null).build();

      return JsonResponseEntity.builder().status(true).statusCode(HttpStatus.OK)
          .message("Successful!").data(customer).build();

    } catch (Exception e) {
      return JsonResponseEntity.builder().error(false).statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
          .message("Error: " + e.getMessage()).build();
    } 
  }

  /**
   * @param customerId
   * @return JSON
   */
  public JsonResponseEntity<?> removeUser(UUID customerId) {
    try {
      User customer = repository.findByQueryCustomer(customerId);

      if (customer == null)
        return JsonResponseEntity.builder().status(false).statusCode(HttpStatus.NOT_FOUND)
            .message("No Found!").data(null).build();

      repository.deleteByQueryCustomer(customerId);

      return JsonResponseEntity.builder().status(true).statusCode(HttpStatus.OK)
          .message("User with " + customerId + " deleted successfully").data(null).build();

    } catch (Exception e) {
      return JsonResponseEntity.builder().error(false).statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
          .message("Error: " + e.getMessage()).build();
    }
  }

  public JsonResponseEntity<Object>editCustomer(UUID customerId, User reqObj) {
    try {
     User customer = repository.findByQueryCustomer(customerId);

      if (customer == null)
        return JsonResponseEntity.builder().status(false).statusCode(HttpStatus.NOT_FOUND)
            .message("Customer Not Found!").data(null).build();
      
      String firstName = reqObj.getFirstName() != null && !reqObj.getFirstName().isEmpty() ? reqObj.getFirstName().trim() : customer.getFirstName();
      
      String lastName = reqObj.getLastName() != null && !reqObj.getLastName().isEmpty() ? reqObj.getLastName().trim() : customer.getLastName();

      String email = reqObj.getEmail() != null && !reqObj.getEmail().trim().isEmpty() ? reqObj.getEmail().trim() : customer.getEmail();

      String phone = reqObj.getPhone() != null && !reqObj.getPhone().isEmpty() ? reqObj.getPhone().trim() : customer.getPhone();

      // check why email is not trimed before save
      repository.updateByQueryCustomer(firstName, lastName, email, phone, customerId);
      
      return JsonResponseEntity.builder().status(true).statusCode(HttpStatus.OK)
          .message("User with " + customerId + " updated successfully").data(null).build();
      
    } catch (Exception e) {
      return JsonResponseEntity.builder().error(false).statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
          .message("Error: " + e.getMessage()).build();
    }
  }
}
