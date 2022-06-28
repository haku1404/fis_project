package vn.fis.final_test.exception;

import static vn.fis.final_test.constant.Constant.CUSTOMER_NOT_FOUND;

public class CustomerNotFoundException extends ApplicationException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
    @Override
    public String getErrorCode() {
        return CUSTOMER_NOT_FOUND;
    }
}
