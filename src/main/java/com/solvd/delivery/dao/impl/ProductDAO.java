package com.solvd.delivery.dao.impl;

import com.solvd.delivery.dao.IProductDAO;
import com.solvd.delivery.bin.Product;
import com.solvd.delivery.utils.ConnectionPool;
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
    private static final ConnectionPool cp = ConnectionPool.getInstance();

    private static final String GET_BY_ID = "SELECT * FROM Products WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM Products";
    private static final String INSERT = "INSERT INTO Products(name, description, price, stock) VALUES (?,?,?,?)";
    private static final String DELETE = "DELETE FROM Products WHERE id = ?";
    private static final String UPDATE = "UPDATE Products SET name= ?, description= ?, price= ?, stock= ? WHERE id= ?";
    private static final String UPDATE_PRICE = "UPDATE Products SET price = ? WHERE id = ?";
    private static final String UPDATE_STOCK = "UPDATE Products SET stock = ? WHERE id = ?";

    @Override
    public Product getByID(int id) {

        Connection connection = cp.requestConnection();
        Product product = new Product();

        try (PreparedStatement ps = connection.prepareStatement(GET_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet results = ps.executeQuery()) {
                while (results.next()) {
                    product.setId(results.getInt("id"));
                    product.setName(results.getString("name"));
                    product.setDescription(results.getString("description"));
                    product.setPrice(results.getDouble("price"));
                    product.setStock(results.getInt("stock"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
        return product;
    }

    @Override
    public List<Product> getAll() {

        Connection connection = cp.requestConnection();
        List<Product> productList = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL)) {
            try (ResultSet results = ps.executeQuery()) {
                while (results.next()) {
                    Product product = new Product();
                    product.setId(results.getInt("id"));
                    product.setName(results.getString("name"));
                    product.setDescription(results.getString("description"));
                    product.setPrice(results.getDouble("price"));
                    product.setStock(results.getInt("stock"));
                    productList.add(product);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
        return productList;
    }

    @Override
    public void insert(Product product) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int id) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

    @Override
    public void update(Product product, int id) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

    @Override
    public void updateProductPrice(int id, double price) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_PRICE)) {
            ps.setDouble(1, price);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

    @Override
    public void updateProductStock(int id, int stock) {

        Connection connection = cp.requestConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_STOCK)) {
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error:" + e.getMessage());
        } finally {
            cp.releaseConnection(connection);
        }
    }

}
