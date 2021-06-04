package com.miti.data.mapper;

import com.miti.data.model.User;
import com.miti.server.api.request.UserRequest;
import com.miti.server.api.response.UserResponse;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface UserMapper {

  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "role", constant = "USER"),
    @Mapping(target = "status", ignore = true),
    @Mapping(target = "registrationDate", expression = "java(LocalDateTime.now())"),
    @Mapping(target = "lastAuthDate", expression = "java(LocalDateTime.now())")
  })
  User userRequestToUserModel(UserRequest user);

  @Mapping(target = "jwtToken", ignore = true)
  UserResponse userModelToUserResponse(User user);
}
