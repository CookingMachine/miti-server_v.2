package com.miti.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.miti.data.enums.Role;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "usr")
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private UUID id;

  @Column(name = "login", unique = true)
  private String login;

  @Column(name = "password")
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;

  @Column(name = "username")
  private String username;

  @Column(name = "email", unique = true)
  private String email;

  @Enumerated
  @Column(name = "role")
  private Role role;

  @Column(name = "status")
  private boolean status;

  @Column(name = "registration_date")
  private LocalDateTime registrationDate;

  @Column(name = "last_auth_date")
  private LocalDateTime lastAuthDate;

  public User (String login, String password, String username, String email, Role role) {
    this.login = login;
    this.password = password;
    this.username = username;
    this.email = email;
    this.role = role;

    this.status = false;
    this.registrationDate = LocalDateTime.now();
    this.lastAuthDate = LocalDateTime.now();
  }
}
