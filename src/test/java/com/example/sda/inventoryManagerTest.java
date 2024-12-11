package com.example.sda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class inventoryManagerTest {
	
	//test addProduct
	@Test
    void testAddProduct() {
        inventoryManager inventoryManager = new inventoryManager("Test", "test@gmail.com", "password", "Inventory Manager");
        Product product = inventoryManager.addProduct("productURL", "name", 10.0, 10, "category", "description");
        assertNotNull(product);
        assertEquals("productURL", product.getProductURL());
        assertEquals("name", product.getName());
        assertEquals(10.0, product.getPrice());
        assertEquals(10, product.getQuantity());
        assertEquals("category", product.getCategory());
        assertEquals("description", product.getDescription()); 
	}
	
	//test addProduct with invalid price
	@Test
    void testAddProductInvalidPrice() {
        inventoryManager inventoryManager = new inventoryManager("Test", "test@gmail.com", "password", "Inventory Manager");
        Product product = inventoryManager.addProduct("productURL", "name", -10.0, 10, "category", "description");
        assertNull(product);
        
	}
	
	//test addProduct with invalid quantity
	@Test
    void testAddProductInvalidQuantity() {
        inventoryManager inventoryManager = new inventoryManager("Test", "test@gmail.com", "password", "Inventory Manager");
        Product product = inventoryManager.addProduct("productURL", "name", 10.0, -10, "category", "description");
        assertNull(product);
	}
	
	//test addProduct with invalid price and quantity
	@Test
    void testAddProductInvalidPriceAndQuantity() {
        inventoryManager inventoryManager = new inventoryManager("Test", "test@gmail.com", "password", "Inventory Manager");
        Product product = inventoryManager.addProduct("productURL", "name", -10.0, -10, "category", "description");
        assertNull(product);
	}


	@Test
    void testUpdateStock() {
        inventoryManager inventoryManager = new inventoryManager("Test", "test@gamil.com", "password", "Inventory Manager");
        Product product = new Product("productURL", "name", 10.0, 10, "category", "description");
        inventoryManager.updateStock(product, 20);
        assertEquals(20, product.getQuantity());
            
	}
	
	@Test
    void testUpdateStockInvalidQuantity() {
        inventoryManager inventoryManager = new inventoryManager("Test", "test@gmial.com", "password", "Inventory Manager");
        Product product = new Product("productURL", "name", 10.0, 10, "category", "description");
        inventoryManager.updateStock(product, -20);
	}
	
}
