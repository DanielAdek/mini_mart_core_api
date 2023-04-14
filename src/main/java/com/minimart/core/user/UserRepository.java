package com.minimart.core.user;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User, UUID> {
  Optional<User>findByEmail(String email);
  
  @Query(value = "SELECT * FROM customers", nativeQuery = true)
  Optional<List<User>>findByQueryCustomers();

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM customers c WHERE c.customerid = ?1", nativeQuery = true)
  void deleteByQueryCustomer(UUID cusomerId); 

  @Query(nativeQuery = true, value="SELECT * FROM customers c WHERE c.customerid = :customerId")
  User findByQueryCustomer(@Param("customerId") UUID customerId);

  @Query(value="INSERT INTO customers (username, phone, email, passcode, role) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
  Optional<User>createCustomerByQuery(User user);

  @Modifying
  @Transactional
  @Query(
    nativeQuery = true,
    value = "UPDATE customers SET username = :username, email = :email, phone = :phone WHERE customerid = :customerId"
  )
  void updateByQueryCustomer(
    @Param("username") String username,
    @Param("email") String email,
    @Param("phone") String phone,
    @Param("customerId") UUID customerId
  );
}
