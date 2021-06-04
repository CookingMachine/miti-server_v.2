package com.miti.server.api;

import com.miti.data.model.User;
import com.miti.server.api.request.UserRequest;
import com.miti.server.api.response.UserResponse;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

  @PostMapping(path = "")
  ResponseEntity<UserResponse> addUser(@RequestBody UserRequest user);

  @GetMapping(path = "/{id}")
  ResponseEntity<User> getUserById(@PathVariable UUID id);

  @GetMapping(path = "/login/{login}")
  ResponseEntity<User> getUserByLogin(@PathVariable String login);

  @GetMapping(path = "/username/{username}")
  ResponseEntity<User> getUserByUsername(@PathVariable String username);

  @GetMapping(path = "/email/{email}")
  ResponseEntity<User> getUserByEmail(@PathVariable String email);

  @GetMapping(path = "")
  ResponseEntity<List<User>> getAllUsers();

  @GetMapping(path = "/role/{role}")
  ResponseEntity<List<User>> getUsersByRole(@PathVariable String role);

  @GetMapping(path = "/status/{status}")
  ResponseEntity<List<User>> getUsersByStatus(@PathVariable String status);
}
