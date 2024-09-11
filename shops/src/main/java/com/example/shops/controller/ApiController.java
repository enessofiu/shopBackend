package com.example.shops.controller;

import com.example.shops.model.Bakery;
import com.example.shops.model.Product;
import com.example.shops.model.Shop;
import com.example.shops.model.Sweetshop;
import com.example.shops.service.BakeryService;
import com.example.shops.service.ProductService;
import com.example.shops.service.ShopService;
import com.example.shops.service.SweetshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping// Base path for all requests
public class ApiController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private BakeryService bakeryService;

    @Autowired
    private SweetshopService sweetshopService;

    @Autowired
    private ProductService productService;



    @GetMapping("/shops")
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/shop/{id}")
    public Shop getShopById(@PathVariable int id) {
        return shopService.getShopById(id);
    }

    @PostMapping("/shop")
    public Shop addShop(@RequestBody Shop shop) {
        return shopService.saveShop(shop);
    }

    @PutMapping("/shop/{id}")
    public Shop updateShop(@PathVariable int id, @RequestBody Shop shop) {
        shop.setId(id);
        return shopService.updateShop(shop);
    }

    @DeleteMapping("/shop/{id}")
    public void deleteShop(@PathVariable int id) {
        shopService.deleteShop(id);
    }



    @GetMapping("/bakeries")
    public List<Bakery> getAllBakeries() {
        return bakeryService.getAllBakeries();
    }

    @GetMapping("/bakery/{id}")
    public Bakery getBakeryById(@PathVariable int id) {
        return bakeryService.getBakeryById(id);
    }

    @PostMapping("/bakery")
    public Bakery addBakery(@RequestBody Bakery bakery) {
        return bakeryService.saveBakery(bakery);
    }

    @PutMapping("/bakery/{id}")
    public Bakery updateBakery(@PathVariable int id, @RequestBody Bakery bakery) {
        bakery.setId(id);
        return bakeryService.updateBakery(bakery);
    }

    @DeleteMapping("/bakery/{id}")
    public void deleteBakery(@PathVariable int id) {
        bakeryService.deleteBakery(id);
    }

    @DeleteMapping("/bakery/{bakeryId}/{productId}")
    public void deleteBakeryProduct(@PathVariable int bakeryId, @PathVariable int productId){

        bakeryService.deleteBakeryProduct(bakeryId, productId);
    }



    @GetMapping("/sweetshops")
    public List<Sweetshop> getAllSweetshops() {
        return sweetshopService.getAllSweetshops();
    }

    @GetMapping("/sweetshop/{id}")
    public Sweetshop getSweetshopById(@PathVariable int id) {
        return sweetshopService.getSweetshopById(id);
    }

    @PostMapping("/sweetshop")
    public Sweetshop addSweetshop(@RequestBody Sweetshop sweetshop) {
        return sweetshopService.saveSweetshop(sweetshop);
    }

    @PutMapping("/sweetshop/{id}")
    public Sweetshop updateSweetshop(@PathVariable int id, @RequestBody Sweetshop sweetshop) {
        sweetshop.setId(id);
        return sweetshopService.updateSweetshop(sweetshop);
    }

    @DeleteMapping("/sweetshop/{id}")
    public void deleteSweetshop(@PathVariable int id) {
        sweetshopService.deleteSweetshop(id);
    }

    @DeleteMapping("/sweetshop/{sweetshopId}/{productId}")
    public void deleteSweetshopProduct(@PathVariable int sweetshopId, @PathVariable int productId) {
        sweetshopService.deleteSweetshopProduct(sweetshopId, productId);
    }



    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
