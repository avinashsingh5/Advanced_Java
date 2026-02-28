package com.example.productApp.Controller;

import com.example.productApp.Model.Product;
import com.example.productApp.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService){
        this.productService = productService;
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // Get product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create product
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return productService.saveProduct(product);
    }

    // Update product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody Product product){

        return productService.getProductById(id).map(existing -> {
            product.setId(id);
            Product updated = productService.saveProduct(product);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        if(productService.getProductById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}