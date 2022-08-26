package com.app.randomusersproejctdem.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity

public final class Name {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;
	@JsonIgnore
	public long getId() {
		return id;
	}
	@JsonIgnore
	public void setId(long id) {
		this.id = id;
	}
	public String title;
	public String first;
	public String last;
/*
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}
*/
	@OneToOne(mappedBy = "name")
    private Users user;

public Name() {}

	@JsonCreator
	public Name(@JsonProperty("title") String title, @JsonProperty("first") String first,
			@JsonProperty("last") String last) {
		this.title = title;
		this.first = first;
		this.last = last;
	}

    @Override
    public String toString() {
    	return this.title + " " + this.first + " " + this.last;
    }
}