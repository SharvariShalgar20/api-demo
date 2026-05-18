package com.sharvari.crudDemo.service;

import com.sharvari.crudDemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private final Map<Long, Product> store = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ProductService() {
        save(new Product(null, "Laptop",      "High-performance laptop", 75000.0, 10));
        save(new Product(null, "Headphones",  "Noise-cancelling headphones", 3500.0, 25));
        save(new Product(null, "Mechanical Keyboard", "RGB backlit keyboard", 2200.0, 15));
    }

    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Product save(Product product) {
        long id = idCounter.getAndIncrement();
        product.setId(id);
        store.put(id, product);
        return product;
    }

    public Optional<Product> update(Long id, Product updated) {
        if (!store.containsKey(id)) return Optional.empty();
        updated.setId(id);
        store.put(id, updated);
        return Optional.of(updated);
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }

}
