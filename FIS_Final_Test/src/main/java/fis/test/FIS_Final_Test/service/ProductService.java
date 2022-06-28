package fis.test.FIS_Final_Test.service;


import fis.test.FIS_Final_Test.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long productId);
    Product update(Product product);

    void delete(Long productId);
}
