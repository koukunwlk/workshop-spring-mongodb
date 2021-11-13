package com.moaciramaro.workshopmongo.repository;

import com.moaciramaro.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
