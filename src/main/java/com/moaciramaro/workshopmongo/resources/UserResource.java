package com.moaciramaro.workshopmongo.resources;

import com.moaciramaro.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User u1 = new User("1", "Moacir", "moacir@gmail.com");
        User u2 = new User("2", "amaro", "amaro@gmail.com");
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);

        return ResponseEntity.ok().body(list);
    }
}
