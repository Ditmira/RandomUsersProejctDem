package com.app.randomusersproejctdem;

import com.app.randomusersproejctdem.Entity.Users;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomUsersResponse {
	public List<Users> results;

	public List<Users> getResults() {
		return results;
	}

	@JsonCreator
	public RandomUsersResponse(@JsonProperty("results") List<Users> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		StringBuilder usersString = new StringBuilder();

		for (Users user : results) {
			usersString.append(user);
			usersString.append("\n");
		}

		return usersString.toString();
	}

}
