package vn.fis.final_test.exception;

import static vn.fis.final_test.constant.Constant.ORDER_NOT_FOUND;

public class OrderNotFoundException extends ApplicationException{
    public OrderNotFoundException(String message) {
        super(message);
    }
    @Override
    public String getErrorCode() {
        return ORDER_NOT_FOUND;
    }
}
