package com.quatrosphere.apipublica.repositories;

import com.quatrosphere.apipublica.models.user.UserModel;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends BaseRepository<UserModel>{

    @Query(value = "SELECT * FROM inventario_comercios WHERE email_user=?1", nativeQuery = true)
    public UserModel findByEmail_User(String email);
}
