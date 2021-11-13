package com.moaciramaro.workshopmongo.services;

import com.moaciramaro.workshopmongo.domain.User;
import com.moaciramaro.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
