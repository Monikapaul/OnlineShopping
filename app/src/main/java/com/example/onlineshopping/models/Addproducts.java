package com.example.onlineshopping.models;

public class Addproducts {
    String name;
    String description;
    String price;

    public Addproducts(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Addproducts() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

