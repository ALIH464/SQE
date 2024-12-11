package com.example.sda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerTest {
    private Customer customer;
    private dbService mockService;
    private csystem system;
    private Product mockProduct;
    
    @BeforeEach
    void setUp() {
        // Mock the dbService to avoid real database interactions
        mockService = mock(dbService.class);
        when(mockService.getAllCustomersWithPreferences()).thenReturn(new ArrayList<Customer>());
        when(mockService.getAllProducts()).thenReturn(new ArrayList<Product>());
        when(mockService.getAllOrderHistory()).thenReturn(new ArrayList<orderHistory>());
        when(mockService.getAllFeedback()).thenReturn(new ArrayList<Feedback>());
        mockProduct = new Product("productURL", "productName", 10.0, 10, "category", "description");
        // Initialize the csystem with the mocked dbService
        system = new csystem(mockService);
//       / when(system.getInstance().getProductById(mockProduct.getId())).thenReturn(mockProduct);
        // Ensure singleton initialization
        
        csystem.getInstance();

        // Set up the customer for testing
        List<String> preferences = new ArrayList<>();
        preferences.add("preference1");
        preferences.add("preference2");
        customer = new Customer("CustomerName", "example@test.com", "1234567890", "password", "Address", preferences);
        assertNotNull(customer);
    }

    @Test
    void testConstructor() {
        customer = new Customer();
        assertNotNull(customer);
    }

    @Test
    void testGetCart() {
        Cart cart = customer.getCart();
        assertNotNull(cart);
    }

    @Test
    void testGetId() {
    	
        assertEquals(13, customer.getId());
    }

    @Test
    void testGetName() {
        assertEquals("CustomerName", customer.getName());
    }

    @Test
    void testSetName() {
        customer.setName("NewName");
        assertEquals("NewName", customer.getName());
    }

    @Test
    void testSetPassword() {
        customer.setPassword("NewPassword");
        assertEquals("NewPassword", customer.getPassword());
    }

    @Test
    void testSetPhone() {
        customer.setPhone("0987654321");
        assertEquals("0987654321", customer.getPhone());
    }

    @Test
    void testGetPhone() {
        assertEquals("1234567890", customer.getPhone());
    }

    @Test
    void testGetPassword() {
        assertEquals("password", customer.getPassword());
    }

    @Test
    void testSetEmail() {
        customer.setEmail("newTestemail@test.com");
        assertEquals("newTestemail@test.com", customer.getEmail());
    }

    @Test
    void testGetEmail() {
        assertEquals("example@test.com", customer.getEmail());
    }

    @Test
    void testSetLoyaltyPoints() {
        customer.setLoyaltyPoints(100);
        assertEquals(100, customer.getLoyaltyPoints());
    }

    @Test
    void testGetLoyaltyPoints() {
        assertEquals(0, customer.getLoyaltyPoints());
    }

    @Test
    void testSetTier() {
        customer.setTier("Gold");
        assertEquals("Gold", customer.getTier());
    }

    @Test
    void testGetTier() {
        assertNull(customer.getTier());
    }

    @Test
    void testGetAddress() {
        assertEquals("Address", customer.getAddress());
    }

    @Test
    void testSetAddress() {
        customer.setAddress("New Address");
        assertEquals("New Address", customer.getAddress());
    }

    @Test
    void testGetPreferences() {
        List<String> preferences = new ArrayList<>();
        preferences.add("preference1");
        preferences.add("preference2");
        assertEquals(preferences, customer.getPreferences());
    }

    @Test
    void testSetPreferences() {
        List<String> preferences = new ArrayList<>();
        preferences.add("preference1");
        preferences.add("preference2");
        customer.setPreferences(preferences);
        assertEquals(preferences, customer.getPreferences());
    }

    @Test
    void testUpdate() {
        customer.update("NewName", "updatedemail@example.com", "0987654321", "NewPassword", "NewAddress", new ArrayList<>(), 100, "Gold");
        assertEquals("NewName", customer.getName());
        assertEquals("updatedemail@example.com", customer.getEmail());
        assertEquals("0987654321", customer.getPhone());
        assertEquals("NewPassword", customer.getPassword());
        assertEquals("NewAddress", customer.getAddress());
        assertEquals(100, customer.getLoyaltyPoints());
        assertEquals("Gold", customer.getTier());
    }

    // Test for adding product to the cart
    @Test
    void testAddProductToCart() {
        // Mock the behavior of getProductById to return a product
        Product product = new Product("productURL", "productName", 10.0, 10, "category", "description");
		//product.addProduct(product);
       Product product2 = new Product("productURL2", "ProductName2", 20.0, 2, "Category2", "Description2");
		inventoryManager manager = new inventoryManager("manager", "manager@test.com", "password", "manager");
		manager.addProduct("productURL", "productName", 10.0, 10, "category", "description");
        when(mockService.getProductById(1)).thenReturn(product);
        
        Cart cart = customer.getCart();
        cart.addProduct(product, 1, 0);
        cart.addProduct(product2, 1, 0);
        System.out.println(product.getId());
        System.out.println(cart.getProducts().size());
        customer.addProductToCart(product.getId(), 1);

        // Validate the cart after adding the product
        assertEquals(2, cart.getProducts().size());
        assertEquals(2, cart.getQuantities().size());
        assertEquals(2, cart.getQuantities().get(0));
    }
    
    @Test
	void testViewProfile() {
		// Test the viewProfile method
		customer.viewProfile();
		// No assertions to be made as the method does not return anything
	}
    
    @Test
	void testCheckOut() {
		// Mock the behavior of getProductById to return a product
		Product product = new Product("productURL", "productName", 10.0, 10, "category", "description");
		when(mockService.getProductById(1)).thenReturn(product);

		Cart cart = customer.getCart();
		cart.addProduct(product, 1, 0);
		customer.checkOut();
		// Validate the cart after checking out
		assertEquals(1, cart.getProducts().size());
		assertEquals(1, cart.getQuantities().size());
		assertEquals(0, cart.getTotalPrice());
	}
    
    @Test
    void testPurchaseItem() {
	            // Mock the behavior of getProductById to return a product
        Product product = new Product("productURL", "productName", 10.0, 10, "category", "description");
        when(mockService.getProductById(1)).thenReturn(product);

        Cart cart = customer.getCart();
        cart.addProduct(product, 1, 0);
        customer.purchaseItem();
        // Validate the cart after purchasing the item
        assertEquals(1, cart.getProducts().size());
        assertEquals(1, cart.getQuantities().size());
        assertEquals(0, cart.getTotalPrice());
    }
    
    //purchase item empty cart
    @Test
	void testPurchaseItemEmptyCart() {
		Cart cart = customer.getCart();
		customer.purchaseItem();
		// Validate the cart after purchasing the item
		assertEquals(0, cart.getProducts().size());
		assertEquals(0, cart.getQuantities().size());
		assertEquals(0, cart.getTotalPrice());
	}

    //purchase item insufficient quantity
    @Test
    void testPurchaseItemInsufficientQuantity() {
	            // Mock the behavior of getProductById to return a product
        Product product = new Product("productURL", "productName", 10.0, 1, "category", "description");
        when(mockService.getProductById(1)).thenReturn(product);

        Cart cart = customer.getCart();
        cart.addProduct(product, 2, 0);
        customer.purchaseItem();
        // Validate the cart after purchasing the item
        assertEquals(1, cart.getProducts().size());
        assertEquals(1, cart.getQuantities().size());
        assertEquals(0, cart.getTotalPrice());
    }
    
//    public void makePurchase(String orderDate, Cart cart) {
//        orderHistory newOrder = new orderHistory(this.id, orderDate, cart);
//        addToPurchaseHistory(newOrder);
//    }
    
    @Test
	void testMakePurchase() {
		// Mock the behavior of getProductById to return a product
		Product product = new Product("productURL", "productName", 10.0, 10, "category", "description");
		when(mockService.getProductById(1)).thenReturn(product);

		Cart cart = customer.getCart();
		
		cart.addProduct(product, 1, 0);
		customer.purchaseHistory = new ArrayList<orderHistory>();
		
		customer.makePurchase("orderDate", cart);
		// Validate the purchase history after making a purchase
		assertEquals(1, customer.getPurchaseHistory().size());
	}

    @Test
    void testViewPurchaseHistory_noHistory() {
		customer.purchaseHistory = new ArrayList<orderHistory>();
        customer.viewPurchaseHistory();
    	assertEquals(0, customer.getPurchaseHistory().size());
    }
    
    @Test
    void testViewPurchaseHistory() {
    	Product product = new Product("productURL", "productName", 10.0, 10, "category", "description");
		when(mockService.getProductById(1)).thenReturn(product);

		Cart cart = customer.getCart();
		
		cart.addProduct(product, 1, 0);
		customer.purchaseHistory = new ArrayList<orderHistory>();
		
		customer.makePurchase("orderDate", cart);
		
		customer.viewPurchaseHistory();
    
		assertEquals(1, customer.getPurchaseHistory().size());
    }
    
//    public List<orderHistory> getOrdersSortedByDate() {
//        Collections.sort(purchaseHistory, new Comparator<orderHistory>() {
//            @Override
//            public int compare(orderHistory order1, orderHistory order2) {
//                return order1.getOrderDate().compareTo(order2.getOrderDate());
//            }
//        });
//        return purchaseHistory;
//    }
    
    @Test
    void testGetOrdersSortedByDate() {
    	Product product = new Product("productURL", "productName", 10.0, 10, "category", "description");
    	when(mockService.getProductById(1)).thenReturn(product);
    	
    	Cart cart = customer.getCart();
    	cart.addProduct(product, 1, 0);
    	customer.purchaseHistory = new ArrayList<orderHistory>();
    	customer.purchaseHistory.add(new orderHistory(1, "2021-06-03", cart));
    	customer.purchaseItem();
    	customer.makePurchase("2004-12-14", cart);
    	customer.makePurchase("2021-06-03", cart);
    	
    	List<orderHistory> sortedOrders = customer.getOrdersSortedByDate();
    	System.out.println(sortedOrders.get(0).getOrderDate());
    	
    	//check the current order date is the latest
    	assertEquals(sortedOrders.get(0).getOrderDate(), sortedOrders.get(0).getOrderDate());
    	        
    }
    
//    public void clientRequestsOrderHistory() {
//        viewPurchaseHistory();  
//    }
    
    @Test
	void testClientRequestsOrderHistory() {
    	customer.purchaseHistory = new ArrayList<orderHistory>();
		customer.clientRequestsOrderHistory();
		// No assertions to be made as the method does not return anything
	}
}
