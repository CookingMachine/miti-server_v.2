package com.miti.server.controller;

import com.miti.data.model.User;
import com.miti.server.api.UserApi;
import com.miti.server.api.request.UserRequest;
import com.miti.server.api.response.UserResponse;
import com.miti.server.service.UserService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/user")
public class UserController implements UserApi {

  private final UserService userService;

  @Override
  public ResponseEntity<UserResponse> addUser(UserRequest user) {
    return userService.addUser(user);
  }

  @Override
  public ResponseEntity<User> getUserById(UUID id) {
    return userService.getUserById(id);
  }

  @Override
  public ResponseEntity<User> getUserByLogin(String login) {
    return userService.getUserByLogin(login);
  }

  @Override
  public ResponseEntity<User> getUserByUsername(String username) {
    return userService.getUserByUsername(username);
  }

  @Override
  public ResponseEntity<User> getUserByEmail(String email) {
    return userService.getUserByEmail(email);
  }

  @Override
  public ResponseEntity<List<User>> getAllUsers() {
    return userService.getAllUsers();
  }

  @Override
  public ResponseEntity<List<User>> getUsersByRole(String role) {
    return userService.getUserByRole(role);
  }

  @Override
  public ResponseEntity<List<User>> getUsersByStatus(String status) {
    return userService.getUserByStatus(status);
  }
}
