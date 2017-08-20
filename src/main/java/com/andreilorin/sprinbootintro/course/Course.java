package com.andreilorin.sprinbootintro.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.andreilorin.springbootintro.topic.Topic;

@Entity
public class Course {

	@Id
	@NotNull(message = "ID cannot be empty")
	private int id;
	
	@NotNull(message = "Name cannot be empty")
	@Size(min = 2, max = 10, message = "Name must have 2 to 10 characters")
	private String name;
	
	@Min(value = 5, message = "Has to have at least 5 credits")
	private double credits;
	
	@ManyToOne
	private Topic topic;
	
	public Course() {
		
	}
	
	public Course(int id, String name, double credits, int topicId) {
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.topic = new Topic(topicId, name, credits);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
