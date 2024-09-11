package com.example.shops.service;

import com.example.shops.model.Product;
import com.example.shops.model.Sweetshop;
import com.example.shops.repository.ProductRepository;
import com.example.shops.repository.SweetshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetshopService {

    @Autowired
    private SweetshopRepository sweetshopRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Sweetshop> getAllSweetshops() {
        return sweetshopRepository.findAll();
    }

    public Sweetshop getSweetshopById(int id) {
        return sweetshopRepository.findById(id).orElse(null);
    }

    public Sweetshop saveSweetshop(Sweetshop sweetshop) {
        return sweetshopRepository.save(sweetshop);
    }

    public Sweetshop updateSweetshop(Sweetshop sweetshop) {
        if (sweetshopRepository.existsById(sweetshop.getId())) {
            return sweetshopRepository.save(sweetshop);
        }
        return null;
    }

    public void deleteSweetshop(int id) {
        sweetshopRepository.deleteById(id);
    }

    public void deleteSweetshopProduct(int sweetshopId, int productId) {
        Sweetshop sweetshop = sweetshopRepository.findById(sweetshopId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);

        sweetshop.getProducts().remove(product);

        sweetshopRepository.save(sweetshop);

    }
}
