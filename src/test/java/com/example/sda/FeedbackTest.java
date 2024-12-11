package com.example.sda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FeedbackTest {

	@Test
	void testConstructor() {
		Feedback feedback = new Feedback(1, 1, "feedbackDescription");
		assertEquals(1, feedback.getCustomerId());
		assertEquals(1, feedback.getProductId());
		assertEquals("feedbackDescription", feedback.getFeedbackDescription());
	}
	
	@Test
	void testSimpleConstructor() {
		Feedback feedback = new Feedback();
		assertNotNull(feedback);
	}
	
	@Test
	void testSetCustomerId() {
		Feedback feedback = new Feedback();
		feedback.setCustomerId(1);
		assertEquals(1, feedback.getCustomerId());
	}
	
	@Test
	void testSetProductId() {
		Feedback feedback = new Feedback();
		feedback.setProductId(1);
		assertEquals(1, feedback.getProductId());
	}
	
	@Test
	void testSetFeedbackDescription() {
		Feedback feedback = new Feedback();
		feedback.setFeedbackDescription("feedbackDescription");
		assertEquals("feedbackDescription", feedback.getFeedbackDescription());
	}
	
	@Test
	void testGetId() {
		Feedback feedback = new Feedback();
		assertEquals(1, feedback.getId());
	}
	
	@Test
	void testGetCustomerId() {
		Feedback feedback = new Feedback();
		assertEquals(0, feedback.getCustomerId());
	}
	
	@Test
	void testGetProductId() {
		Feedback feedback = new Feedback();
		assertEquals(0, feedback.getProductId());
	}
	
	@Test
	void testGetFeedbackDescription() {
		Feedback feedback = new Feedback();
		assertEquals(null, feedback.getFeedbackDescription());
	}
	
	

}
