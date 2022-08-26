package com.app.randomusersproejctdem;
import com.app.randomusersproejctdem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class RandomUsersClient {
	@Autowired
	public UsersRepository repository;

	@Autowired
	RestTemplate restTemplate;

	public String apiUrl="https://randomuser.me/api/";

    @Scheduled(fixedRate =200000)
    public void doSomething() {
    	String url = apiUrl;// + "?results=" + numberOfUsers;
		RandomUsersResponse quote = restTemplate.getForObject(
				url, RandomUsersResponse.class);
		System.out.println(quote.toString());
		
		repository.saveAll(quote.results);
    }

}
