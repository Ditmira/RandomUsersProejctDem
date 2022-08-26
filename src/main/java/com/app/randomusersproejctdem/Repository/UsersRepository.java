package com.app.randomusersproejctdem.Repository;

import com.app.randomusersproejctdem.Entity.Location;
import com.app.randomusersproejctdem.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:3000", "https://randomusers-ui.azurewebsites.net/"})
@RepositoryRestResource
public interface UsersRepository extends CrudRepository<Users, Long> {
	List<Users> findByGender(String gender);

	Users findById(long id);
	
	List<Users> findByLocation(Location location);
}
