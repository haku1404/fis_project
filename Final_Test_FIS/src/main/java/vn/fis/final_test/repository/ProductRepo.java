package vn.fis.final_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.final_test.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
