package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-orders")
public class CustomerOrderController {

    private final CustomerService customerService;
    private final OrderService orderService;

    @Autowired
    public CustomerOrderController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createCustomerAndOrders(@RequestBody @Valid CustomerOrderRequest customerOrderRequest) {
        // Extract and save the customer
        Customer savedCustomer = customerService.createCustomer(customerOrderRequest.getCustomer());

        // Link the orders to the customer and save the orders
        List<Order> orders = customerOrderRequest.getOrders();
        for (Order order : orders) {
            order.setCustomerId(savedCustomer.getId()); // Link the customer ID to the order
            orderService.createOrder(order);            // Save the order
        }

        return ResponseEntity.ok("Customer and orders created successfully");
    }
}
