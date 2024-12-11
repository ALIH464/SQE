package com.example.sda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

// package com.example.sda;
// import java.util.*;

// public class Cart {
//     private List<Product> products;
//     private List<Integer> quantities;
//     private double totalPrice;

//     // Updated default constructor
//     public Cart() {
//         this.products = new ArrayList<>(); // Initialize the products list
//         this.quantities = new ArrayList<>(); // Initialize the quantities list
//         this.totalPrice = 0;
//     }

//     // Parameterized constructor (if needed)
//     public Cart(List<Product> products, List<Integer> quantities, double totalPrice) {
//         this.products = products;
//         this.quantities = quantities;
//         this.totalPrice = totalPrice;
//     }

//     // Add product to cart
//     public void addProduct(Product product, int quantity, double totalPrice) {
//         products.add(product);
//         quantities.add(quantity);
//         totalPrice += product.getPrice() * quantity; 
//     }

//     // Getters and Setters

//     public List<Product> getProducts() {
//         return products;
//     }

//     public void setProducts(List<Product> products) {
//         this.products = products;
//     }

//     public List<Integer> getQuantities() {
//         return quantities;
//     }

//     public void setQuantities(List<Integer> quantities) {
//         this.quantities = quantities;
//     }

//     public double getTotalPrice() {
//         return totalPrice;
//     }

//     public void setTotalPrice(double totalPrice) {
//         this.totalPrice = totalPrice;
//     }

//     // Optional clear method to empty the cart
//     public void clear() {
//         products.clear();
//         quantities.clear();
//         totalPrice = 0;
//     }
// }



public class CartTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
		List<Product> products = new ArrayList<>();
		List<Integer> quantities = new ArrayList<>();
		product1 = new Product("productURL1", "ProductName1", 10.0, 1, "Category1", "Description1");
		product2 = new Product("productURL2", "ProductName2", 20.0, 2, "Category2", "Description2");
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(cart.getProducts());
        assertNotNull(cart.getQuantities());
        assertEquals(0, cart.getTotalPrice());
    }

    @Test
    public void testParameterizedConstructor() {
        List<Product> products = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        product1.setPrice(10);
        products.add(product1);
        
        
        quantities.add(1);
        Cart cart = new Cart(products, quantities, 10.0);
        assertEquals(products, cart.getProducts());
        assertEquals(quantities, cart.getQuantities());
       
        assertEquals(10.0, cart.getTotalPrice());
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(product1, 2, product1.getPrice() * 2);
        assertEquals(1, cart.getProducts().size());
        assertEquals(2, cart.getQuantities().get(0));
        assertEquals(0, cart.getTotalPrice());
    }

    @Test
    public void testGetProducts() {
        cart.addProduct(product1, 1, cart.getTotalPrice());
        List<Product> products = cart.getProducts();
        assertEquals(1, products.size());
        assertEquals(product1, products.get(0));
    }

    @Test
    public void testSetProducts() {
        List<Product> products = new ArrayList<>();
        products.add(product1);
        cart.setProducts(products);
        assertEquals(products, cart.getProducts());
    }

    @Test
    public void testGetQuantities() {
        cart.addProduct(product1, 1, cart.getTotalPrice());
        List<Integer> quantities = cart.getQuantities();
        assertEquals(1, quantities.size());
        assertEquals(1, (int) quantities.get(0));
    }

    @Test
    public void testSetQuantities() {
        List<Integer> quantities = new ArrayList<>();
        quantities.add(1);
        cart.setQuantities(quantities);
        assertEquals(quantities, cart.getQuantities());
    }

    @Test
    public void testGetTotalPrice() {
        cart.addProduct(product1, 1, cart.getTotalPrice());
        assertEquals(0, cart.getTotalPrice());
    }

    @Test
    public void testSetTotalPrice() {
        cart.setTotalPrice(50.0);
        assertEquals(50.0, cart.getTotalPrice());
    }

    @Test
    public void testClear() {
        cart.addProduct(product1, 1, cart.getTotalPrice());
        cart.clear();
        assertEquals(0, cart.getProducts().size());
        assertEquals(0, cart.getQuantities().size());
        assertEquals(0, cart.getTotalPrice());
    }
    
}
