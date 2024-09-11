package com.example.shops.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    private int id;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Bakery> bakeries;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Sweetshop> sweetshops;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bakery> getBakeries() {
        return bakeries;
    }

    public void setBakeries(List<Bakery> bakeries) {
        this.bakeries = bakeries;
    }

    public List<Sweetshop> getSweetshops() {
        return sweetshops;
    }

    public void setSweetshops(List<Sweetshop> sweetshops) {
        this.sweetshops = sweetshops;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
