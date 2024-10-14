package ie.atu.week5.customerapp;

// Custom exception class for resource not found
public class ResourceNotFoundException extends RuntimeException {

    // Constructor to pass in a custom error message
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
