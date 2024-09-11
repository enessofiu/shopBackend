package com.example.shops.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Bakery> bakeries;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Sweetshop> sweetshops;

    public Shop() {
    }

    public Shop(int id, String name) {
        this.id = id;
        this.name = name;
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
}
