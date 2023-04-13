package com.minimart.core.user;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, UUID> {
  Optional<User>findByEmail(String email);
  
  @Query(value = "SELECT * FROM customers", nativeQuery = true)
  Optional<List<User>>findByQueryCustomers();

  @Query(value = "DELETE FROM customers WHERE customerid = ?1", nativeQuery = true)
  Optional<?>deleteByQueryCustomer(UUID cusomerId);

  @Query(value="SELECT * FROM customers WHERE customerid = :customerId", nativeQuery = true)
  Optional<User>findByQueryCustomer(UUID customerId);

  @Query(value="INSERT INTO customers (username, phone, email, passcode, role) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
  Optional<User>createCustomerByQuery(User user);
}
