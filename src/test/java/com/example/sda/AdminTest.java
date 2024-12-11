package com.example.sda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class AdminTest {
    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin("AdminName", "admin@example.com", "password", "AdminRole") {};
    }

    @Test
    void testGetId() {
        assertEquals(6, admin.getId());
    }

    @Test
    void testGetName() {
        assertEquals("AdminName", admin.getName());
    }

    @Test
    void testGetEmail() {
        assertEquals("admin@example.com", admin.getEmail());
    }

    @Test
    void testGetPassword() {
        assertEquals("password", admin.getPassword());
    }

    @Test
    void testGetRole() {
        assertEquals("AdminRole", admin.getRole());
    }

    @Test
    void testSetName() {
        admin.setName("NewName");
        assertEquals("NewName", admin.getName());
    }

    @Test
    void testSetEmail() {
        admin.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", admin.getEmail());
    }

    @Test
    void testSetPassword() {
        admin.setPassword("newpassword");
        assertEquals("newpassword", admin.getPassword());
    }

    @Test
    void testSetRole() {
        admin.setRole("NewRole");
        assertEquals("NewRole", admin.getRole());
    }

    @Test
    void testAddCustomer() {
        Customer customer = admin.addCustomer("CustomerName", "customer@example.com", "1234567890", "password", "Address", new ArrayList<>());
        assertNull(customer);
    }

    @Test
    void testUpdateProfile() {
        Customer customer = new Customer("CustomerName", "customer@example.com", "1234567890", "password", "Address", new ArrayList<>());
        admin.updateProfile(customer, "NewName", "newemail@example.com", "0987654321", "newpassword", "NewAddress", new ArrayList<>());
        assertEquals("CustomerName", customer.getName()); // No changes expected
    }

    @Test
    void testSettingTier() {
        Customer customer = new Customer("CustomerName", "customer@example.com", "1234567890", "password", "Address", new ArrayList<>());
        assertFalse(admin.settingTier(customer));
    }

    @Test
    void testViewProfile() {
        Customer customer = new Customer("CustomerName", "customer@example.com", "1234567890", "password", "Address", new ArrayList<>());
        assertNull(admin.viewProfile(customer));
    }

    @Test
    void testAddProduct() {
        Product product = admin.addProduct("productURL", "ProductName", 100.0, 10, "Category", "Description");
        assertNull(product);
    }

    @Test
    void testUpdateStock() {
        Product product = new Product("productURL", "ProductName", 100.0, 10, "Category", "Description");
        admin.updateStock(product, 20);
        assertEquals(10, product.getQuantity()); // No changes expected
    }

    @Test
    void testGenerateProductRecommendations() {
        Customer customer = new Customer("CustomerName", "customer@example.com", "1234567890", "password", "Address", new ArrayList<>());
        List<Product> recommendations = admin.generateProductRecommendations(customer);
        assertTrue(recommendations.isEmpty());
    }

    @Test
    void testMonitorChurn() {
        List<orderHistory> churn = admin.monitorchurn();
        assertNull(churn);
    }

    @Test
    void testTrackPurchaseHistory() {
        Customer customer = new Customer("CustomerName", "customer@example.com", "1234567890", "password", "Address", new ArrayList<>());
        List<orderHistory> history = admin.trackPurchaseHistory(customer);
        assertTrue(history.isEmpty());
    }

    @Test
    void testCollectFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        List<Feedback> collectedFeedback = admin.collectFeedback(feedbackList);
        assertTrue(collectedFeedback.isEmpty());
    }
}
