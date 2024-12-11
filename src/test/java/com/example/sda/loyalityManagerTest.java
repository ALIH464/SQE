package com.example.sda;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class loyalityManagerTest {

	@Test
	void testSettingTier() {
		loyaltyManager loyaltyManager = new loyaltyManager("name", "email", "password", "role");
		// Set up the customer for testing
        List<String> preferences = new ArrayList<>();
        preferences.add("preference1");
        preferences.add("preference2");
        Customer customer = new Customer("CustomerName", "example@test.com", "1234567890", "password", "Address", preferences);
		customer.setLoyaltyPoints(1000);
		assertTrue(loyaltyManager.settingTier(customer));
		assertEquals("Gold", customer.getTier());
		assertEquals(0, customer.getLoyaltyPoints());
	}
	
	@Test
	void testSettingTierLoyalPoints500() {
        loyaltyManager loyaltyManager = new loyaltyManager("name", "email", "password", "role");
        // Set up the customer for testing
        List<String> preferences = new ArrayList<>();
        preferences.add("preference1");
        preferences.add("preference2");
        Customer customer = new Customer("CustomerName", "example@test.com", "1234567890", "password", "Address", preferences);
        customer.setLoyaltyPoints(500);
        assertTrue(loyaltyManager.settingTier(customer));
        assertEquals("Silver", customer.getTier());
        assertEquals(0, customer.getLoyaltyPoints());
	}
	
    @Test
    void testSettingTierLoyalPoints100() {
        loyaltyManager loyaltyManager = new loyaltyManager("name", "email", "password", "role");
        // Set up the customer for testing
        List<String> preferences = new ArrayList<>();
        preferences.add("preference1");
        preferences.add("preference2");
        Customer customer = new Customer("CustomerName", "example@test.com", "1234567890", "password", "Address", preferences);
        customer.setLoyaltyPoints(100);
        assertTrue(loyaltyManager.settingTier(customer));
        assertEquals("Bronze", customer.getTier());
        assertEquals(0, customer.getLoyaltyPoints());
        
    }

    @Test
    void testSettingTierLoyalPoints0() {
        loyaltyManager loyaltyManager = new loyaltyManager("name", "email", "password", "role");
        // Set up the customer for testing
        List<String> preferences = new ArrayList<>();
        preferences.add("preference1");
        preferences.add("preference2");
        Customer customer = new Customer("CustomerName", "example@test.com", "1234567890", "password", "Address", preferences);
        customer.setLoyaltyPoints(0);
        assertFalse(loyaltyManager.settingTier(customer));
        //assertEquals("", customer.getTier());
        assertEquals(0, customer.getLoyaltyPoints());
    }
	
	

}
