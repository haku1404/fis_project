package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Product;
import vn.fis.training.ordermanagement.repository.ProductRepository;
import vn.fis.training.ordermanagement.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProductById(Long ProductId) {
        productRepository.deleteById(ProductId);
    }

    @Override
    public List<Product> findAll() {
        List products = new ArrayList();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    @Override
    public Product findById(Long ProductId) {
        return productRepository.findById(ProductId).get();
    }
}
