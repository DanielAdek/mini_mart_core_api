package com.minimart.core.user;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User implements UserDetails {
  @Id
  @Column(name = "customerid")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID customerId;

  @Column(name = "username")
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

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    String authority = role != null ? role.name() : UserRole.CUSTOMER.name();
    return List.of(new SimpleGrantedAuthority(authority));
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return passcode;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
