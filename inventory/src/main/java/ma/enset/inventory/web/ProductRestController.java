package ma.enset.inventory.web;

import ma.enset.inventory.entities.Product;
import ma.enset.inventory.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class ProductRestController {
    private ProductRepository productRepository;
     public ProductRestController(ProductRepository productRepository) {
         this.productRepository = productRepository;
     }

     @GetMapping("/products")
     @PreAuthorize("hasAuthority('ADMIN')")
     public List<Product> productList(){
         return productRepository.findAll();
     }

    @GetMapping("/products/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Product productById(@PathVariable String id){
        return productRepository.findById(id).get();
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
         return authentication;
    }
}