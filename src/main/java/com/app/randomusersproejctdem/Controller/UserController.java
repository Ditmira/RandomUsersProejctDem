package com.app.randomusersproejctdem.Controller;

import com.app.randomusersproejctdem.Entity.Location;
import com.app.randomusersproejctdem.Entity.Users;
import com.app.randomusersproejctdem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

//@Service
public class UserController {
    /*
    @Autowired
    UsersRepository repository;
    @GetMapping("/{id}")
    public Optional<Users> findById(@PathVariable long id) {
        return repository.findById(id);
    }
    @GetMapping("/location")
    public List<Users> findByLocation(@RequestParam Location location) {
        return repository.findByLocation(location);
    }

     */
}
