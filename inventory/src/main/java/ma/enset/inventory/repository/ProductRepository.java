package ma.enset.inventory.repository;

import ma.enset.inventory.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
