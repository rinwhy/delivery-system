package com.solvd.delivery.service;

import com.solvd.delivery.bin.Product;

import java.util.List;

public interface IProductService {

    Product getProductByID(int id);

    List<Product> getAllProducts();

    void addProductToDB(Product product);

    void removeProductByID(int id);

    void updateProductPrice(int id, double price);

    void updateProductStock(int id, int stock);

}
