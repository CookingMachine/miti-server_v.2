package com.miti.server.api.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

  private UUID id;

  private String login;

  private String username;

  private String email;

  private String jwtToken;
}
