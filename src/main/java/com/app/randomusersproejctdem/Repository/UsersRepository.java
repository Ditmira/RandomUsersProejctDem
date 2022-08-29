package com.app.randomusersproejctdem.Repository;

import com.app.randomusersproejctdem.Entity.Location;
import com.app.randomusersproejctdem.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="*")
@RepositoryRestResource
public interface UsersRepository extends CrudRepository<Users, Long> {
	List<Users> findByLocation(String location);
}
