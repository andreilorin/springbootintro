package com.andreilorin.springbootintro;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.andreilorin.springbootintro.topic.Topic;

public class CourseTest {

	private static Validator validator;
	
	@BeforeClass
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void nameIsNull() {
		Topic topic = new Topic(1, null, 5.00);
		
		Set<ConstraintViolation<Topic>> constraintViolations = validator.validate(topic);
		assertEquals( 1, constraintViolations.size() );
        assertEquals( "Name cannot be empty", constraintViolations.iterator().next().getMessage() );
	}
	
	@Test
	public void nameIsTooShort() {
		Topic topic = new Topic(1, "A", 10.00);
		
		Set<ConstraintViolation<Topic>> constraintViolations = validator.validate(topic);
		assertEquals( 1, constraintViolations.size() );
        assertEquals( "Name must have 2 to 10 characters", constraintViolations.iterator().next().getMessage() );
	}
	
	@Test
	public void nameIsTooLong() {
		Topic topic = new Topic(1, "AndreiLorin", 10.00);
		
		Set<ConstraintViolation<Topic>> constraintViolations = validator.validate(topic);
		assertEquals( 1, constraintViolations.size() );
        assertEquals( "Name must have 2 to 10 characters", constraintViolations.iterator().next().getMessage() );
	}
	
	@Test
	public void creditIsTooLow() {
		Topic topic = new Topic(1, "Lorin", 4.00);
		
		Set<ConstraintViolation<Topic>> constraintViolations = validator.validate(topic);
		assertEquals( 1, constraintViolations.size() );
        assertEquals( "Has to have at least 5 credits", constraintViolations.iterator().next().getMessage() );
	}
	
	
}
