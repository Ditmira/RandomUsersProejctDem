package com.app.randomusersproejctdem.Controller;
import com.app.randomusersproejctdem.Entity.Users;
import com.app.randomusersproejctdem.RandomUsersResponse;
import com.app.randomusersproejctdem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


//@Component

@CrossOrigin(origins ="*")
@RestController
public class RandomUsersController {
	@Autowired
	public UsersRepository repository;

	@Autowired
	RestTemplate restTemplate;

	public String apiUrl="https://randomuser.me/api/";

    @Scheduled(fixedRate =200000)
    public void doSomething() {
    	String url = apiUrl+"?results=" + "10";
		RandomUsersResponse quote = restTemplate.getForObject(
				url, RandomUsersResponse.class);
		System.out.println(quote.toString());

		repository.saveAll(quote.results);
    }

	@GetMapping("/users/{id}")
	public Optional<Users> findById(@RequestParam long id) {
		return repository.findById(id);
	}
	/*
	@GetMapping("/users/{location}")
	public List<Users> findByLocation(@RequestParam String location) {

		return repository.findByLocation(location);
	}

	 */
	@GetMapping("/users")
	public Iterable<Users> findAllUsers() {
		return repository.findAll();
	}

}
