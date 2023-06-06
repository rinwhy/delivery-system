package com.solvd.delivery.db.serviceLayer;

import com.solvd.delivery.db.interfacesDao.IProductDAO;
import com.solvd.delivery.db.model.Product;
import com.solvd.delivery.db.mysql.dao.ProductDAO;

import java.util.List;

public class ProductService {

    IProductDAO productDAO = new ProductDAO();

    public Product getProductByID(int id) {
        return productDAO.getProductByID(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    public void deleteProductByID(int id) {
        productDAO.deleteProductByID(id);
    }

    public void updateProductPrice(int id, double price) {
        productDAO.updateProductPrice(id, price);
    }

    public void updateProductStock(int id, int stock) {
        productDAO.updateProductStock(id, stock);
    }


}
