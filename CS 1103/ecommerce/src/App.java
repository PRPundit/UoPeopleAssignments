import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product(1, "Laptop", 1200.00);
        Product product2 = new Product(2, "Smartphone", 800.00);
        Product product3 = new Product(3, "Headphones", 150.00);

        // Create a customer
        Customer customer = new Customer(1, "Adonyas Getachew");

        // Customer browses products and adds them to the shopping cart
        customer.addProductToCart(product1);
        customer.addProductToCart(product2);
        customer.addProductToCart(product3);

        // Calculate the total cost of the shopping cart
        double totalCost = customer.calculateTotalCost();
        System.out.println("Total cost: $" + totalCost);

        // Place an order
        List<Product> cartProducts = new ArrayList<>(customer.getShoppingCart());
        Order order = new Order(1, customer, cartProducts);

        // Display information about the order
        System.out.println(order);

        // Display customer and product information
        System.out.println(customer);
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
    }
}
