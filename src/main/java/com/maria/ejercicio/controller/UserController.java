package com.maria.ejercicio.controller;

import com.maria.ejercicio.model.User;
import com.maria.ejercicio.model.UserDocu;
import com.maria.ejercicio.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> retrieveUsers(){
        return ResponseEntity.ok().body(userService.retrieveAll());
    }

    @GetMapping("users/docs")
    public ResponseEntity<Iterable<UserDocu>> retrieveAll(){
        return ResponseEntity.ok().body(userService.retrieveAllInfo());
    }

    //Join
    @GetMapping("users/{id}")
    public ResponseEntity<User> retrieve(@PathVariable("id") Long id){
        User user = userService.retrieve(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public ResponseEntity<User> postInfo(@RequestBody User user){ 
        User newUser = userService.create(user);
        return ResponseEntity.ok().body(newUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
      userService.delete(id);
      return ResponseEntity.noContent().build();   
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateInfo(@RequestBody User user, @PathVariable("id") Long id){ 
        User updateUser = userService.update(user, id);
        return ResponseEntity.ok().body(updateUser);
    }
}

