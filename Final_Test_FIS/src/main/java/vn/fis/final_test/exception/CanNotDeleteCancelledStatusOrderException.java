package vn.fis.final_test.exception;

public class CanNotDeleteCancelledStatusOrderException extends Exception {
    public CanNotDeleteCancelledStatusOrderException(String message) {
        super(message);
    }
}
