package com.solvd.delivery.service.impl;

import com.solvd.delivery.dao.IProductDAO;
import com.solvd.delivery.bin.Product;
import com.solvd.delivery.dao.impl.ProductDAO;
import com.solvd.delivery.service.IProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductService implements IProductService {

    private static final IProductDAO dao = new ProductDAO();
    private static final Logger LOGGER = LogManager.getLogger(ProductService.class);

    @Override
    public Product getProductByID(int id) {
        if (id > 0) {
            return dao.getByID(id);
        } else LOGGER.warn("Invalid ID provided! ");
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return dao.getAll();
    }

    @Override
    public void addProductToDB(Product product) {
        if (product.getName() != null &&
                product.getDescription() != null &&
                product.getPrice() > 0 &&
                product.getStock() >= 0) {
            dao.insert(product);
            LOGGER.info("Successfully added to database\n");
        } else
            LOGGER.warn("Error inserting product to database");
    }

    @Override
    public void removeProductByID(int id) {
        if (id > 0) {
            dao.deleteByID(id);
        } else LOGGER.warn("Invalid ID provided! ");
    }

    @Override
    public void updateProductPrice(int id, double price) {
        if (id > 0 && price > 0) {
            dao.updateProductPrice(id, price);
        }
        else LOGGER.warn("Invalid ID or price! ");
    }

    @Override
    public void updateProductStock(int id, int stock) {
        if (id > 0 && stock >= 0) {
            dao.updateProductStock(id, stock);
        }
        else LOGGER.warn("Invalid ID or stock! ");
    }

}
