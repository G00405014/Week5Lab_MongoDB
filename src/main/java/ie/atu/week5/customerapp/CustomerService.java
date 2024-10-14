package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Business logic for fetching all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Business logic for fetching a customer by ID
    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    // Business logic for creating a customer
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Business logic for deleting a customer by ID
    public boolean deleteCustomerById(String id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
