package com.app.randomusersproejctdem.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public final class Location {
	public String country;
	@ManyToOne(cascade = {CascadeType.ALL})
	public Users user;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;
/*
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public Users getUser(){
		return this.user;

	}
	public void setUser(Users user){
		this.user=user;
	}
*/
	@JsonCreator
	public Location(@JsonProperty("country") String country, @JsonProperty("user") Users user) {
		this.country = country;
		this.user =user;
	}
	public String toString(){
		StringBuilder locationString = new StringBuilder();
		locationString.append("Country: ").append(country.toString()).append(" Users: ").append(user.getId());
		return locationString.toString();
	}
	@JsonCreator
	public Location() {
	}

}