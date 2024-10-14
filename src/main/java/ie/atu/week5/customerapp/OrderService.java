package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Fetch all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Fetch orders by customer ID
    public List<Order> getOrdersByCustomerId(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    // Create a new order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Delete an order by ID
    public boolean deleteOrderById(String id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
