package com.solvd.delivery.bin;

public class Product extends BaseTable{

    private String name;
    private String description;
    private double price;
    private int stock;

    public int getId() {
        return super.id;
    }

    public void setId(int id) {
        super.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return "Product {" +
                "id=" + super.id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=$" + price +
                ", stock=" + stock +
                '}';
    }
}
