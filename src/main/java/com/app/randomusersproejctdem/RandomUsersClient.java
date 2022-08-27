package com.app.randomusersproejctdem;
import com.app.randomusersproejctdem.Entity.Location;
import com.app.randomusersproejctdem.Entity.Users;
import com.app.randomusersproejctdem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


//@Component

@CrossOrigin(origins ="*")
@RestController
public class RandomUsersClient {
	@Autowired
	public UsersRepository repository;

	@Autowired
	RestTemplate restTemplate;

	public String apiUrl="https://randomuser.me/api/";

    @Scheduled(fixedRate =200000)
    public void doSomething() {
    	String url = apiUrl+"?results=" + "100";
		RandomUsersResponse quote = restTemplate.getForObject(
				url, RandomUsersResponse.class);
		System.out.println(quote.toString());

		repository.saveAll(quote.results);
    }

	@GetMapping("/{id}")
	public Optional<Users> findById(@PathVariable long id) {
		return repository.findById(id);
	}
	@GetMapping("/location")
	public List<Users> findByLocation(@RequestParam Location location) {
		return repository.findByLocation(location);
	}
	@GetMapping("/users")
	public Iterable<Users> findAllUsers() {
		return repository.findAll();
	}

}
