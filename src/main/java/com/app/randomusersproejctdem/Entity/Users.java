package com.app.randomusersproejctdem.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
public final class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	public String gender;
	
	@OneToOne(cascade = {CascadeType.ALL})
	public Name name;
	public String email;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	public Location location;

	@JsonIgnore
	public Long getId() {
		return this.id;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Location getLocation() {
		return location;
	}

	@Override
	public String toString() {
		StringBuilder userString = new StringBuilder();
		userString.append("Name: ").append(name.toString()).append(" Gender: ").append(gender).append(" Location: ").append(location.country);
		return userString.toString();
	}

	public Users() {
	}

	@JsonCreator
	public Users(@JsonProperty("gender") String gender, @JsonProperty("name") Name name,
				 @JsonProperty("email") String email, @JsonProperty("location") Location location) {
		//this.location = null;
		this.gender = gender;
		this.name = name;
		this.email = email;
		this.location = location;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users user = (Users) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(gender, user.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, gender);
    }

}