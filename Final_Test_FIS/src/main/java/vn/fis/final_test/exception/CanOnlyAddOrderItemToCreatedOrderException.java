package vn.fis.final_test.exception;

public class CanOnlyAddOrderItemToCreatedOrderException extends Exception {
    public CanOnlyAddOrderItemToCreatedOrderException(String message) {
        super(message);
    }
}
