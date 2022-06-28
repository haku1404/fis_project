package vn.fis.final_test.exception;

import static vn.fis.final_test.constant.Constant.PRODUCT_NOT_FOUND;

public class ProductNotFoundException extends ApplicationException{
    public ProductNotFoundException(String message) {
        super(message);
    }
    @Override
    public String getErrorCode() {
        return PRODUCT_NOT_FOUND;
    }
}
