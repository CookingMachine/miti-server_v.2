package com.miti.server.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {

  private String login;

  private String username;

  private String password;

  private String email;
}
