package com.example.sda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ProductTest {
	
	@Test
	void testConstructor() {
		Product product = new Product("productURL", "name", 10.0, 10, "category", "description");
		assertEquals("productURL", product.getProductURL());
		assertEquals("name", product.getName());
		assertEquals(10.0, product.getPrice());
		assertEquals(10, product.getQuantity());
		assertEquals("category", product.getCategory());
		assertEquals("description", product.getDescription());
	}
	
	@Test 
	void testSimpleConstructor() {
		Product product = new Product();
		assertNotNull(product);
	}

	
	@Test
	void testSetId() {
		Product product = new Product();
		product.setId(1);
		assertEquals(1, product.getId());
	}
	

	@Test
	void testSetProductURL() {
		Product product = new Product();
		product.setProductURL("productURL");
		assertEquals("productURL", product.getProductURL());
	}
	
	@Test
	void testSetName() {
		Product product = new Product();
		product.setName("name");
		assertEquals("name", product.getName());
	}
	

	@Test
	void testSetCategory() {
		Product product = new Product();
		product.setCategory("category");
		assertEquals("category", product.getCategory());
	}

	
	@Test
	void testSetDescription() {
		Product product = new Product();
		product.setDescription("description");
		assertEquals("description", product.getDescription());
	}
	
}
