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
  @Query(value = "DELETE FROM customers c WHERE c.customer_id = ?1", nativeQuery = true)
  void deleteByQueryCustomer(UUID cusomerId);

  @Query(value = "SELECT * FROM customers c WHERE c.email = ?1", nativeQuery = true)
  User findByEmailQueryCustomer(String email); 

  @Query(nativeQuery = true, value="SELECT * FROM customers c WHERE c.customer_id = :customerId")
  User findByQueryCustomer(@Param("customerId") UUID customerId);

  @Query(value="INSERT INTO customers (first_name, last_name, phone, email, password, role) VALUES (?1, ?2, ?3, ?4, ?5, ?6) returning *", nativeQuery = true)
  User createCustomerByQuery(String first_name, String last_name, String phone, String email, String password, String role);

  @Modifying
  @Transactional
  @Query(
    nativeQuery = true,
    value = "UPDATE customers SET first_name = :firstName, last_name = :lastName, email = :email, phone = :phone WHERE customer_id = :customerId"
  )
  void updateByQueryCustomer(
    @Param("firstName") String firstName,
    @Param("lastName") String lastName,
    @Param("email") String email,
    @Param("phone") String phone,
    @Param("customerId") UUID customerId
  );
}
