package vn.fis.final_test.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.fis.final_test.model.Product;
import vn.fis.final_test.service.ProductService;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long productId) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long productId) {

    }
}
