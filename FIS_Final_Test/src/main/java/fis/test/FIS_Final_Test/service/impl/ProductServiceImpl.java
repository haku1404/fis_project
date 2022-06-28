package fis.test.FIS_Final_Test.service.impl;

import fis.test.FIS_Final_Test.model.Product;
import fis.test.FIS_Final_Test.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
