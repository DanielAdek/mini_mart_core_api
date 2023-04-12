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
}
