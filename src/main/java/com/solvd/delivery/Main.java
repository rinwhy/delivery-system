package com.solvd.delivery;

import com.solvd.delivery.bin.*;
import com.solvd.delivery.service.impl.JsonService;
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

        //region XML

        XMLService xmlService = new XMLService();
        // output files
        File customersXML = new File("src/main/resources/xml/jaxB_customers.xml");
        File ordersXML = new File("src/main/resources/xml/jaxB_orders.xml");

        // Stax validating XML with schema
        xmlService.validateXML("src/main/resources/xml/customers.xml", "src/main/resources/xml/customers.xsd");
        xmlService.readCustomerXMLStax(new File("src/main/resources/xml/customers.xml"));


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



        // marshalling and unmarshalling customers
        xmlService.marshallToXMLJaxB(customersJaxB, customersXML);
        IJaxB<Customer> unmarshalled = xmlService.unmarshallFromXMLJaxB(CustomersJaxB.class, customersXML);
        unmarshalled.getList().forEach(customer -> LOGGER.info(customer.toString() + "\n"));


        // marshalling and unmarshalling orders
        xmlService.marshallToXMLJaxB(orderjaxB, ordersXML);
        IJaxB<Order> unmarshalled2 = xmlService.unmarshallFromXMLJaxB(OrdersJaxB.class, ordersXML);
        unmarshalled2.getList().forEach(order -> LOGGER.info(order.toString() + "\n") );

        //endregion


        //region JSON
        JsonService jsonService = new JsonService();
        File jsonFile = new File("src/main/resources/json/deliveries.json");

        //serializing an delivery
        Customer customer3 = new Customer(3, "Johanis Crabbington", "Unknown", "randomguy@gmail.com");
        Order order3 = new Order(3, Date.valueOf("2023-02-03"), Date.valueOf("2023-02-13"), customer3);
        Vehicle vehicle = new Vehicle(1, "Ford",  "E-Transit 2023", 300, true );
        Driver driver = new Driver(1, "Johnny Drover", "driver@gmail.com", vehicle);
        Delivery delivery = new Delivery(1, Date.valueOf("2023-02-13"), "In-Transit", driver, order3);

        jsonService.serializeObjectToJson(delivery, jsonFile);

        //de-serializing a JSON into an object
        Delivery deliveryObj = jsonService.deserializeJsonToObject(Delivery.class, jsonFile);
        LOGGER.info(deliveryObj);


        //endregion
    }

}
