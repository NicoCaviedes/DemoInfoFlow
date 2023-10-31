package com.quatrosphere.apipublica.services;

import com.quatrosphere.apipublica.models.user.UserModel;
import com.quatrosphere.apipublica.repositories.BaseRepository;
import com.quatrosphere.apipublica.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserModel>{
    public UserService(UserRepository repository) {
        super(repository);
    }
}
