package com.example.sda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class factoryAdminTest {


//    public static Admin createAdmin(String name, String email, String password , String role) {
//        if (role.equals("Marketting Manager")) {
//            return new marketingManager(name, email, password, role);
//        } else if (role.equals("Inventory Manager")) {
//            return new inventoryManager(name, email, password, role);
//        } else if (role.equals("Store Manager")) {
//            return new storeManager(name, email, password, role);
//        }
//        else if (role.equals("Loyalty Program Manager")) {
//            return new loyaltyManager(name, email, password, role);
//        }
//        else {
//            return null;
//        }
//    }
	
	@Test
	void testCreateAdminMarketingManager() {
		Admin admin = factoryAdmin.createAdmin("name", "email", "password", "Marketting Manager");
		assertTrue(admin instanceof marketingManager);
	}
	
	@Test
	void testCreateAdminInventoryManager() {
		Admin admin = factoryAdmin.createAdmin("name", "email", "password", "Inventory Manager");
		assertTrue(admin instanceof inventoryManager);
	}
	
	@Test
	void testCreateAdminStoreManager() {
		Admin admin = factoryAdmin.createAdmin("name", "email", "password", "Store Manager");
		assertTrue(admin instanceof storeManager);
	}
	
	@Test
	void testCreateAdminLoyaltyManager() {
		Admin admin = factoryAdmin.createAdmin("name", "email", "password", "Loyalty Program Manager");
		assertTrue(admin instanceof loyaltyManager);
	}
	
	@Test
	void testCreateAdminInvalidRole() {
		Admin admin = factoryAdmin.createAdmin("name", "email", "password", "Invalid Role");
		assertNull(admin);
	}
	
}
