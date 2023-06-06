package com.solvd.delivery.db.mysql.dao;

import com.solvd.delivery.db.interfacesDao.IProductDAO;
import com.solvd.delivery.db.model.Customer;
import com.solvd.delivery.db.model.Product;
import com.solvd.delivery.db.mysql.connection.ConnectionPool;
import com.solvd.delivery.db.serviceLayer.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    public static final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);

    @Override
    public Product getProductByID(int id) {

        Connection connection = ConnectionPool.getConnection();
        Product product = new Product();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Products WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                product.setId(results.getInt("id"));
                product.setName(results.getString("name"));
                product.setDescription(results.getString("description"));
                product.setPrice(results.getDouble("price"));
                product.setStock(results.getInt("stock"));
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {

        Connection connection = ConnectionPool.getConnection();
        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Products");
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                Product product = new Product();
                product.setId(results.getInt("id"));
                product.setName(results.getString("name"));
                product.setDescription(results.getString("description"));
                product.setPrice(results.getDouble("price"));
                product.setStock(results.getInt("stock"));
                productList.add(product);
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }

        return productList;
    }


    @Override
    public void addProduct(Product product) {
        Connection connection = ConnectionPool.getConnection();
        String statement = "insert into Products(name, description, price, stock) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
    }

    @Override
    public void deleteProductByID(int id) {
        Connection connection = ConnectionPool.getConnection();
        String statement = "DELETE FROM Products WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
    }

    @Override
    public void updateProductPrice(int id, double price) {
        Connection connection = ConnectionPool.getConnection();
        String statement = "UPDATE Products SET price = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
    }

    @Override
    public void updateProductStock(int id, int stock) {
        Connection connection = ConnectionPool.getConnection();
        String statement = "UPDATE Products SET stock = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, stock);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        }
    }

}
