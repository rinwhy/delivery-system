package com.solvd.delivery.service.mybatisimpl;

import com.solvd.delivery.bin.Customer;
import com.solvd.delivery.service.ICustomerService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CustomerService implements ICustomerService {

    private static final Logger LOGGER = LogManager.getLogger(CustomerService.class);

    @Override
    public Customer getCustomerByID(int id) {
        if (id > 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    return session.selectOne("myBatis.CustomerMapper.getByID", id);
                }
            } catch (IOException e) {
                LOGGER.warn("IOException, error creating the sql session" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid ID provided! ");
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                return session.selectList("myBatis.CustomerMapper.getAll");
            }
        } catch (IOException e) {
            LOGGER.warn("IOException, error creating the sql session" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addCustomerToDB(Customer customer) {
        if (customer.getName() != null &&
                customer.getAddress() != null &&
                customer.getEmail() != null) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    int rowsAffected =  session.insert("myBatis.CustomerMapper.insert", customer);
                    session.commit();
                    LOGGER.info("Successfully added to database, rows Affected " + rowsAffected);
                }
            } catch (IOException e) {
                LOGGER.warn("Error inserting customer to database\n");
                LOGGER.warn("IOException, error creating the sql session\n" + e.getMessage());
                e.printStackTrace();
            }
        } else
            LOGGER.warn("Error inserting customer to database");
    }


    @Override
    public void removeCustomerFromDB(Customer customer) {
        if (customer.getId() > 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    int rowsAffected =  session.delete("myBatis.CustomerMapper.delete", customer);
                    session.commit();
                    LOGGER.info("Successfully removed from database, rows Affected " + rowsAffected);
                }
            } catch (IOException e) {
                LOGGER.warn("Error removing customer from database\n");
                LOGGER.warn("IOException, error creating the sql session\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid Customer ID provided! ");
    }

    @Override
    public void removeCustomerFromDB(int id) {
        if (id > 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    int rowsAffected = session.delete("myBatis.CustomerMapper.delete", id);
                    session.commit();
                    LOGGER.info("Successfully removed from database, rows Affected " + rowsAffected);
                }
            } catch (IOException e) {
                LOGGER.warn("Error removing customer from database\n");
                LOGGER.warn("IOException, error creating the sql session\n" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("Invalid Customer ID provided! ");

    }
}
