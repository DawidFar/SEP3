package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo){ this.repo = repo; }

    @GetMapping
    public List<Product> list(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public Product get(@PathVariable UUID id){ return repo.findById(id).orElseThrow(); }

    @PostMapping
    public Product create(@RequestBody Product p){ return repo.save(p); }

    @PutMapping("/{id}")
    public Product update(@PathVariable UUID id, @RequestBody Product p){ p.setId(id); return repo.save(p); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){ repo.deleteById(id); }
}
