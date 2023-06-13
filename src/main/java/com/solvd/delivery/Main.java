package com.solvd.delivery;

import com.solvd.delivery.bin.Customer;
import com.solvd.delivery.bin.Order;
import com.solvd.delivery.service.impl.XMLService;
import com.solvd.delivery.utils.jaxB.CustomersJaxB;
import com.solvd.delivery.utils.jaxB.IJaxB;
import com.solvd.delivery.utils.jaxB.OrdersJaxB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {


        XMLService xmlService = new XMLService();
//
//        // Stax validating XML with schema
//        xmlService.validateXML("src/main/resources/xml/customers.xml", "src/main/resources/xml/customers.xsd");
//        xmlService.readCustomerXMLStax(new File("src/main/resources/xml/customers.xml"));
//
//
        // some customer data to marshall
        IJaxB<Customer> customersJaxB = new CustomersJaxB();
        Customer customer1 = new Customer(1, "Wimbledon CumberBatch", "London", "BennySnatch@gmail.com");
        Customer customer2 = new Customer(2, "another guy ", "ny", "random@gmail.com");
        List<Customer> list = new ArrayList<>();
        list.add(customer1);
        list.add(customer2);
        customersJaxB.setList(list);

        // some order data to marshall
        IJaxB<Order> orderjaxB = new OrdersJaxB();
        Order order1 = new Order(1, Date.valueOf("2023-02-03"), Date.valueOf("2023-02-13"), customer1);
        Order order2 = new Order(2, Date.valueOf("2023-03-09"), Date.valueOf("2023-03-15"), customer2);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderjaxB.setList(orderList);

        // output files
        File customersXML = new File("src/main/resources/xml/jaxB_customers.xml");
        File ordersXML = new File("src/main/resources/xml/jaxB_orders.xml");

        // marshalling and unmarshalling customers
        xmlService.marshallToXMLJaxB(customersJaxB, customersXML);
        IJaxB unmarshalled = xmlService.unmarshallFromXMLJaxB(CustomersJaxB.class, customersXML);
        unmarshalled.getList().forEach(customer -> LOGGER.info(customer.toString() + "\n"));


        // marshalling and unmarshalling orders
        xmlService.marshallToXMLJaxB(orderjaxB, ordersXML);
        IJaxB unmarshalled2 = xmlService.unmarshallFromXMLJaxB(OrdersJaxB.class, ordersXML);
        unmarshalled2.getList().forEach(order -> LOGGER.info(order.toString() + "\n") );

    }

}
