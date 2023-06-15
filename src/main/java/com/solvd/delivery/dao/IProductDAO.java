package com.solvd.delivery.dao;

import com.solvd.delivery.bin.Product;

public interface IProductDAO extends DAO<Product> {

    void updateProductPrice(double price, int id);

    void updateProductStock(int stock, int id);

}
