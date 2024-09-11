package com.example.shops.service;

import com.example.shops.model.Shop;
import com.example.shops.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Shop getShopById(int id) {
        return shopRepository.findById(id).orElse(null);
    }

    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public Shop updateShop(Shop shop) {
        if (shopRepository.existsById(shop.getId())) {
            return shopRepository.save(shop);
        }
        return null;
    }

    public void deleteShop(int id) {
        shopRepository.deleteById(id);
    }
}
