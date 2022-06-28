package vn.fis.final_test.exception;

public class OrderItemNotFoundException extends ApplicationException{

    public OrderItemNotFoundException(String message) {
        super(message);
    }
    @Override
    public String getErrorCode() {
        return null;
    }
}
