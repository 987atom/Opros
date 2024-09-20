package com.oprosWeb.web.repositories;

import com.oprosWeb.web.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    boolean existsByUsername(String username);
}
