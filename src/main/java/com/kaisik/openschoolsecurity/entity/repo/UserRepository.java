package com.kaisik.openschoolsecurity.entity.repo;

import com.kaisik.openschoolsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Репозиторий для юзера
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUserId(UUID id);
    Optional<User> findByEmail(String email);
}