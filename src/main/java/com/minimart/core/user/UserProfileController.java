package com.minimart.core.user;

import java.util.Optional;
import java.util.UUID;

import javax.swing.text.html.Option;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minimart.core.json.JsonResponseEntity;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class UserProfileController {
  private final UserProfileService service;

  @GetMapping
  public ResponseEntity<JsonResponseEntity<Object>>retrieveCustomers() {
    return ResponseEntity.ok(service.getUsers());
  }

  /**
   * @param customerId
   * @return
   */
  @GetMapping(path="{customerId}")
  public ResponseEntity<JsonResponseEntity<Object>>retrieveCustomer(
    @PathVariable("customerId") UUID customerId
  ) {
    JsonResponseEntity<Object> customer = service.getUserById(customerId);
    return ResponseEntity.status(customer.getStatusCode()).body(customer);
  }

  @DeleteMapping(path="{customerId}")
  public ResponseEntity<JsonResponseEntity<?>>deleteCustomer(
    @PathVariable("customerId") UUID customerId
  ) {
    JsonResponseEntity<?> resp = service.removeUser(customerId);
    return ResponseEntity.status(resp.getStatusCode()).body(resp);
  }

  @PutMapping(path="{customerId}")
  public ResponseEntity<JsonResponseEntity<Object>>updateCustomer(
    @PathVariable("customerId") UUID customerId,
    @RequestBody() User requestObject
  ) {
    JsonResponseEntity<Object> updatedCustomer = service.editCustomer(customerId, requestObject);
    return ResponseEntity.status(updatedCustomer.getStatusCode()).body(updatedCustomer);
  }
}
