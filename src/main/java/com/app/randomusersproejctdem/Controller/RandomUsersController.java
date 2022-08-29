package com.app.randomusersproejctdem.Controller;

import com.app.randomusersproejctdem.Entity.Location;
import com.app.randomusersproejctdem.Entity.Users;
import com.app.randomusersproejctdem.RandomUsersResponse;
import com.app.randomusersproejctdem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


//@Component

@CrossOrigin(origins = "*")
@RestController
public class RandomUsersController {
    @Autowired
    public UsersRepository repository;

    @Autowired
    RestTemplate restTemplate;

    public String apiUrl = "https://randomuser.me/api/";

    @Scheduled(fixedRate = 200000)
    public void doSomething() {
        String url = apiUrl + "?results=" + "10";
        RandomUsersResponse quote = restTemplate.getForObject(
                url, RandomUsersResponse.class);
        System.out.println(quote.toString());

        repository.saveAll(quote.results);
    }

    @GetMapping("/users/{id}")
    public Optional<Users> findById(@PathVariable(value ="id" ) long id) {
        return repository.findById(id);
    }
/*
    @GetMapping(path ="/users/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> findByLocation(@PathVariable(value = "location") String location) {
        Users note = repository.findByLocation(location.country);
        return ResponseEntity.ok().body(note);
    }


 */

    @GetMapping("/users")
    public Iterable<Users> findAllUsers() {
        return repository.findAll();
    }

}
