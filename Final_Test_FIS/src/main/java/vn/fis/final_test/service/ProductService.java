package vn.fis.final_test.service;

import vn.fis.final_test.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long productId);
    Product update(Product product);
    void delete(Long productId);
}
