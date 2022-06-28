package vn.fis.final_test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.fis.final_test.exception.*;

import static vn.fis.final_test.constant.Constant.*;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {
            OrderNotFoundException.class
    })
    protected ResponseEntity<ErrorMessage> handleOrderNotFoundException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.builder().code(ORDER_NOT_FOUND).message(exception.getMessage()).build());
    }
    @ExceptionHandler(value = {
            OrderItemNotFoundException.class
    })
    protected ResponseEntity<ErrorMessage> handleOrderItemNotFoundException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.builder().code(ORDER_ITEM_NOT_FOUND).message(exception.getMessage()).build());
    }
    @ExceptionHandler(value = {
            CustomerNotFoundException.class
    })
    protected ResponseEntity<ErrorMessage> handleCustomerNotFoundException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.builder().code(CUSTOMER_NOT_FOUND).message(exception.getMessage()).build());
    }
    @ExceptionHandler(value = {
            ProductNotFoundException.class
    })
    protected ResponseEntity<ErrorMessage> handleInvalidCustomerException(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder().code(PRODUCT_NOT_FOUND).message(exception.getMessage()).build());
    }

    @ExceptionHandler(value = {
            Exception.class
    })
    protected ResponseEntity<ErrorMessage> handleSystemError(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorMessage.builder().code(INTERNAL_SERVER_ERROR).message(exception.getMessage()).build());
    }
}
