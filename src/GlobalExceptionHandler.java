package src;/*
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    // You can add more @ExceptionHandler methods for other exception types
    // For a generic catch-all, you can handle Exception.class
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGenericException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred.");
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

// Example custom error message class
class ErrorMessage {
    private int statusCode;
    private String message;

    public ErrorMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    // Getters
    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}

// Example custom exception
class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}*/
