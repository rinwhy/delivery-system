package com.solvd.delivery.service.mybatisimpl;

import com.solvd.delivery.bin.Product;
import com.solvd.delivery.service.IProductService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private static final Logger LOGGER = LogManager.getLogger(ProductService.class);

    @Override
    public Product getProductByID(int id) {
        if (id > 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    return session.selectOne("myBatis.ProductMapper.getByID", id);
                }
            } catch (IOException e) {
                LOGGER.warn("IOException, error creating the sql session" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid ID provided! ");
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                return session.selectList("myBatis.ProductMapper.getAll");
            }
        } catch (IOException e) {
            LOGGER.warn("IOException, error creating the sql session" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addProductToDB(Product product) {
        if (product.getName() != null &&
                product.getDescription() != null &&
                product.getPrice() > 0 &&
                product.getStock() >= 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    int rowsAffected = session.insert("myBatis.ProductMapper.insert", product);
                    session.commit();
                    LOGGER.info("Rows Affected " + rowsAffected + "\n");
                }
            } catch (IOException e) {
                LOGGER.warn("Error inserting product to database\n");
                LOGGER.warn("IOException, error creating the sql session\n" + e.getMessage());
                e.printStackTrace();
            }
        } else
            LOGGER.warn("Error inserting product to database");
    }

    @Override
    public void removeProductByID(int id) {
        if (id > 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    int rowsAffected = session.delete("myBatis.ProductMapper.delete", id);
                    session.commit();
                    LOGGER.info("Rows Affected " + rowsAffected + "\n");
                }
            } catch (IOException e) {
                LOGGER.warn("Error removing product from database\n");
                LOGGER.warn("IOException, error creating the sql session\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid Product ID provided! ");
    }

    @Override
    public void updateProductPrice(int id, double price) {
        if (id > 0 && price > 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    Map<Object, Object> map = new HashMap<>();
                    map.put("id", id);
                    map.put("price", price);

                    int rowsAffected = session.update("myBatis.ProductMapper.updatePrice", map);
                    session.commit();
                    LOGGER.info("Rows Affected " + rowsAffected + "\n");

                }
            } catch (IOException e) {
                LOGGER.warn("Error updating product price\n");
                LOGGER.warn("IOException, error creating the sql session\n" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateProductStock(int id, int stock) {
        if (id > 0 && stock >= 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    Map<Object, Object> map = new HashMap<>();
                    map.put("id", id);
                    map.put("stock", stock);

                    int rowsAffected = session.update("myBatis.ProductMapper.updateStock", map);
                    session.commit();
                    LOGGER.info("Rows Affected " + rowsAffected + "\n");
                }
            } catch (IOException e) {
                LOGGER.warn("Error updating product stock\n");
                LOGGER.warn("IOException, error creating the sql session\n" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
