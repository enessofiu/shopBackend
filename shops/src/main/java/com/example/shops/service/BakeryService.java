package com.example.shops.service;

import com.example.shops.model.Bakery;
import com.example.shops.model.Product;
import com.example.shops.repository.BakeryRepository;
import com.example.shops.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BakeryService {

    @Autowired
    private BakeryRepository bakeryRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Bakery> getAllBakeries() {
        return bakeryRepository.findAll();
    }

    public Bakery getBakeryById(int id) {
        return bakeryRepository.findById(id).orElse(null);
    }

    public Bakery saveBakery(Bakery bakery) {
        return bakeryRepository.save(bakery);
    }

    public Bakery updateBakery(Bakery bakery) {
        if (bakeryRepository.existsById(bakery.getId())) {
            return bakeryRepository.save(bakery);
        }
        return null;
    }

    public void deleteBakery(int id) {
        bakeryRepository.deleteById(id);
    }

    public void deleteBakeryProduct(int bakeryId, int productId) {
        Bakery bakery = bakeryRepository.findById(bakeryId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);

        bakery.getProducts().remove(product);
        bakeryRepository.save(bakery);

    }
}
