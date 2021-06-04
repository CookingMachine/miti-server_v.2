package com.miti.data.repository;

import com.miti.data.enums.Role;
import com.miti.data.model.User;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  User getUserByLogin(String login);

  User getUserByUsername(String username);

  User getUserByEmail(String email);

  List<User> getUsersByRole(Role role);

  List<User> getUsersByStatus(boolean status);
}
