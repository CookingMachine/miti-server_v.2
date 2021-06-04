package com.miti.server.service;

import com.miti.data.enums.Role;
import com.miti.data.mapper.UserMapper;
import com.miti.data.model.User;
import com.miti.data.repository.UserRepository;
import com.miti.server.api.request.UserRequest;
import com.miti.server.api.response.UserResponse;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  public ResponseEntity<UserResponse> addUser(UserRequest userRequest) {
    User user = userRepository.save(userMapper.userRequestToUserModel(userRequest));
    return new ResponseEntity<>(userMapper.userModelToUserResponse(user), HttpStatus.OK);
  }

  public ResponseEntity<User> getUserById(UUID id) {
    return new ResponseEntity<>(userRepository.findById(id).orElseThrow(()
        -> new RuntimeException("User with id[" + id + "] - doesn't exist!")),
        HttpStatus.OK);
  }

  public ResponseEntity<User> getUserByLogin(String login) {
    return new ResponseEntity<>(userRepository.getUserByLogin(login), HttpStatus.OK);
  }

  public ResponseEntity<User> getUserByUsername(String username) {
    return new ResponseEntity<>(userRepository.getUserByUsername(username), HttpStatus.OK);
  }

  public ResponseEntity<User> getUserByEmail(String email) {
    return new ResponseEntity<>(userRepository.getUserByEmail(email), HttpStatus.OK);
  }

  public ResponseEntity<List<User>> getAllUsers() {
    return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
  }

  public ResponseEntity<List<User>> getUserByRole(String role) {
    return new ResponseEntity<>(userRepository.getUsersByRole(Role.valueOf(role)), HttpStatus.OK);
  }

  public ResponseEntity<List<User>> getUserByStatus(String status) {
    return new ResponseEntity<>(userRepository.getUsersByStatus(Boolean.parseBoolean(status)), HttpStatus.OK);
  }
}
