package com.example.sda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testOrderHistory {

//	public orderHistory() {
//        this.orderId = ++orderCount;
//    }
//
//    // Getters
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public double getTotalOrderPrice() {
//        return totalOrderPrice;
//    }
//
//    public void setTotalOrderPrice(double totalOrderPrice) {
//        this.totalOrderPrice = totalOrderPrice;
//    }
//
//    public int getCustomerId() {
//        return customerId;
//    }
	
	
	@Test
	void testSetTotalOrderPrice() {
		orderHistory orderHistory = new orderHistory();
		orderHistory.setTotalOrderPrice(10.0);
		assertEquals(10.0, orderHistory.getTotalOrderPrice());
	}
	
	 //public double getTotalOrderPrice() {
//       return totalOrderPrice;
//   }
	
	@Test
	void testgetTotalOrderPrice() {
		orderHistory orderHistory = new orderHistory();
		assertEquals(0.0, orderHistory.getTotalOrderPrice());
	}
	
	@Test
	void testSetCustomerId() {
		orderHistory orderHistory = new orderHistory();
		orderHistory.setCustomerId(1);
		assertEquals(1, orderHistory.getCustomerId());
	}
	
	@Test
	void testGetCustomerId() {
		orderHistory orderHistory = new orderHistory();
		assertEquals(0, orderHistory.getCustomerId());
	}

	@Test
	void testGetCart() {
		orderHistory orderHistory = new orderHistory();
		Cart cart = new Cart();
		orderHistory.setCart(cart);
		assertEquals(cart, orderHistory.getCart());
	}


	@Test
	void testSetOrderDate() {
		orderHistory orderHistory = new orderHistory();
		orderHistory.setOrderDate("orderDate");
		assertEquals("orderDate", orderHistory.getOrderDate());
	}
	
	@Test
	void testGetOrderID() {
		orderHistory orderHistory = new orderHistory();
		assertEquals(2, orderHistory.getOrderId());
	}
}
