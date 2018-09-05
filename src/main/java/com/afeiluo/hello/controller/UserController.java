package com.afeiluo.hello.controller;

import java.util.List;

import com.afeiluo.hello.exception.EmployeeNotFoundException;
import com.afeiluo.hello.model.user.User;
import com.afeiluo.hello.model.user.UserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User newEmployee(@RequestBody User newUser) {
        return repository.save(newUser);
    }


    @GetMapping("/users/{id}")
    User one(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(new Long(id)));
    }

    @PutMapping("/user/{id}")
    User replaceEmployee(@RequestBody User newUser, @PathVariable Integer id) {

        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}