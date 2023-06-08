package com.solvd.delivery.serviceLayer;

import com.solvd.delivery.dao.IProductDAO;
import com.solvd.delivery.bin.Product;
import com.solvd.delivery.dao.impl.ProductDAO;

import java.util.List;

public class ProductService {

    IProductDAO productDAO = new ProductDAO();

    public Product getProductByID(int id) {
        return productDAO.getByID(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    public void addProduct(Product product) {
        productDAO.insert(product);
    }

    public void deleteProductByID(int id) {
        productDAO.deleteByID(id);
    }

    public void updateProductPrice(int id, double price) {
        productDAO.updateProductPrice(price,id);
    }

    public void updateProductStock(int id, int stock) {
        productDAO.updateProductStock(id, stock);
    }


}
