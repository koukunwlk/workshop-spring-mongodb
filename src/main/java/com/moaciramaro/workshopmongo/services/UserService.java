package com.moaciramaro.workshopmongo.services;

import com.moaciramaro.workshopmongo.domain.User;
import com.moaciramaro.workshopmongo.dto.UserDTO;
import com.moaciramaro.workshopmongo.repository.UserRepository;
import com.moaciramaro.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return  user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User newUser) {
        Optional<User> userInDb = repository.findById(newUser.getId());
        updateData(newUser, userInDb);
        return repository.save(userInDb.orElseThrow(() -> new ObjectNotFoundException("Failed on save")));
    }

    public void updateData(User newUser, Optional<User> userInDb) {
        userInDb.ifPresent(user -> user.setName(newUser.getName()));
        userInDb.ifPresent(user -> user.setEmail(newUser.getEmail()));
    }

    public User fromDTO(UserDTO userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
