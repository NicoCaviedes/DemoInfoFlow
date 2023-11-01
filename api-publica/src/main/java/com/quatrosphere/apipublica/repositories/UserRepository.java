package com.quatrosphere.apipublica.repositories;

import com.quatrosphere.apipublica.models.user.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends BaseRepository<UserModel>{

    @Query(value = "SELECT * FROM usuario WHERE email_user= :email", nativeQuery = true)
    public UserModel findByEmailUser(@Param("email") String email);
}
