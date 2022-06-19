package vn.fis.training.ordermanagement.service;


import vn.fis.training.ordermanagement.domain.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProductById(Long ProductId);

    List<Product> findAll();

    Product findById(Long ProductId);
}
