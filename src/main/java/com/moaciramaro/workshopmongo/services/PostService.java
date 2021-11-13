package com.moaciramaro.workshopmongo.services;

import com.moaciramaro.workshopmongo.domain.Post;
import com.moaciramaro.workshopmongo.domain.User;
import com.moaciramaro.workshopmongo.repository.PostRepository;
import com.moaciramaro.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return  post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }

}
