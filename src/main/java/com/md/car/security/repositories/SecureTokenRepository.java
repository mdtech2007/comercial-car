package com.md.car.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.md.car.security.models.SecureToken;

public interface SecureTokenRepository extends JpaRepository<SecureToken, Long> {

    SecureToken findByToken(final String token);

    Long removeByToken(final String token);
}
