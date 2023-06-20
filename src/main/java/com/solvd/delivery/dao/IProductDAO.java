package com.solvd.delivery.dao;

import com.solvd.delivery.bin.Product;

import java.util.List;

public interface IProductDAO extends DAO<Product> {

    void updateProductPrice(int id, double price);

    void updateProductStock(int id, int stock);

}
