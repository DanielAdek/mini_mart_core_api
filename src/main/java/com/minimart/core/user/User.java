package com.minimart.core.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;

@Data // this is from lombok and it provides all getter and setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class User {
  @Id
  @Column(name = "customerid")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID customerId;

  private String username;

  private String email;

  private String phone;

  private String passcode;

  @Enumerated(EnumType.STRING)
  @Column(name="role", columnDefinition = "varchar(20)")
  private UserRole role;

  @CreationTimestamp
  @Column(name = "createdat")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updatedat")
  private LocalDateTime updatedAt;
}
