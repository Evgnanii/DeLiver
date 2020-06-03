package by.st.deliver.core.servicesImpl.exceptions;

public class OrderAlreadyReleasedException extends RuntimeException {
    public OrderAlreadyReleasedException(String message) {
        super(message);
    }
}
