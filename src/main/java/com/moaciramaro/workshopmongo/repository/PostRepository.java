package com.moaciramaro.workshopmongo.repository;

import com.moaciramaro.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}