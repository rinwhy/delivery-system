package com.solvd.delivery.db.interfacesDao;

import com.solvd.delivery.db.model.Product;

import java.util.List;

public interface IProductDAO {

    Product getProductByID (int id);
    void addProduct(Product product);
    void deleteProductByID(int id);
    void updateProductPrice(int id, double price);

    void updateProductStock(int id, int stock);

    List<Product> getAllProducts();
}
