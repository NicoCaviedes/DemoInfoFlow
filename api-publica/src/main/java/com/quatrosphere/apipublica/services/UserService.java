package com.quatrosphere.apipublica.services;

import com.quatrosphere.apipublica.models.user.UserModel;
import com.quatrosphere.apipublica.repositories.BaseRepository;
import com.quatrosphere.apipublica.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserModel>{

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        super(repository);
    }

    public UserModel findByEmail(String email){
        return repository.findByEmail_User(email);
    }
}
