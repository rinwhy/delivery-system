package com.solvd.delivery.service.mybatisimpl;

import com.solvd.delivery.bin.Order;
import com.solvd.delivery.service.IOrderService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService implements IOrderService {

    private static final Logger LOGGER = LogManager.getLogger(OrderService.class);

    @Override
    public List<Order> getOrdersJoinCustomers() {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                return session.selectList("myBatis.OrderMapper.orderJoinCustomers");
            }
        } catch (IOException e) {
            LOGGER.warn("IOException, error creating the sql session" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order getOrderByID(int id) {
        if (id > 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    return session.selectOne("myBatis.OrderMapper.getByID", id);
                }
            } catch (IOException e) {
                LOGGER.warn("IOException, error creating the sql session" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("ID is invalid");
        return null;
    }

    @Override
    public List<Order> getAllOrdersByCustomersID(int id) {
        if (id > 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    return session.selectList("myBatis.OrderMapper.getAllByID", id);
                }
            } catch (IOException e) {
                LOGGER.warn("IOException, error creating the sql session" + e.getMessage());
                e.printStackTrace();
            }
        } else LOGGER.warn("ID is invalid");
        return null;
    }

    @Override
    public void updateDeliveryDate(int id, Date date) {

        if (id > 0) {
            try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    Map<Object, Object> map = new HashMap<>();
                    map.put("id", id);
                    map.put("date", date);

                    int rowsAffected = session.update("myBatis.OrderMapper.updateDeliveryDate", map);
                    session.commit();
                    LOGGER.info("Rows Affected " + rowsAffected + "\n");
                }
            } catch (IOException e) {
                LOGGER.warn("Error updating delivery date\n");
                LOGGER.warn("IOException, error creating the sql session\n" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
