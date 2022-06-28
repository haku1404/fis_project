package fis.test.FIS_Final_Test.repository;

import fis.test.FIS_Final_Test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
