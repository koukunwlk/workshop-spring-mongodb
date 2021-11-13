package com.moaciramaro.workshopmongo.repository;

import com.moaciramaro.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    public List<Post> findByTitleContainingIgnoreCase(String text);
}