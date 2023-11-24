package com.quatrosphere.authservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.quatrosphere.authservice.models.entities.UserEntity;

public interface UserRepository extends BaseRepository<UserEntity>{

    @Query(value = "SELECT * FROM client WHERE email_client = ?1", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);
    
}
