package ma.enset.inventory;

import ma.enset.inventory.entities.Product;
import ma.enset.inventory.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Computer").price(12000).quantity(20).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Printer").price(2000).quantity(12).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Smart phone").price(4000).quantity(16).build());
        };
    }
}
