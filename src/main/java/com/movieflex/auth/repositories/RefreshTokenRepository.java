package com.movieflex.auth.repositories;

import com.movieflex.auth.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;


public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
    void deleteByExpirationBefore(Instant expiration);
}
