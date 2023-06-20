package com.solvd.delivery;

import com.solvd.delivery.bin.Customer;
import com.solvd.delivery.bin.Product;
import com.solvd.delivery.bin.Order;
import com.solvd.delivery.bin.Vehicle;
import com.solvd.delivery.bin.Delivery;
import com.solvd.delivery.bin.Driver;

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

import com.solvd.delivery.service.mybatisimpl.CustomerService;
//import com.solvd.delivery.service.impl.CustomerService;

import com.solvd.delivery.service.mybatisimpl.ProductService;
//import com.solvd.delivery.service.impl.ProductService;

import com.solvd.delivery.service.mybatisimpl.OrderService;
//import com.solvd.delivery.service.impl.OrderService;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final CustomerService customerService = new CustomerService();
    private static final ProductService productService = new ProductService();
    private static final OrderService orderService = new OrderService();

    public static void main(String[] args) {

//region MyBatis
        //retrieve customer by ID
        Customer customer1 = customerService.getCustomerByID(3);
        LOGGER.info(customer1.toString());
        //adding new customer to DB
        Customer customer2 = new Customer("Tony Parker", "Texas", "Tonyparker@gmail.com");
        customerService.addCustomerToDB(customer2);
        //removing a customer from DB
        Customer customerToRemove = customerService.getCustomerByID(15);
        customerService.removeCustomerFromDB(customerToRemove);
        //showing all customers
        customerService.getAllCustomers().forEach(customer -> LOGGER.info(customer.toString() + "\n"));


        //retrieve product by ID
        Product product1 = productService.getProductByID(1);
        LOGGER.info(product1.toString());
        //inserting product to DB
        Product product2 = new Product("Apple Vision Pro", "Mixed reality headset developed by Apple", 3499, 100);
        productService.addProductToDB(product2);
        //removing product from DB
        productService.removeProductByID(12);
        //updating product price
        productService.updateProductPrice(11, 99999);
        //updating product stock
        productService.updateProductStock(11, 75);
        //get all products
        productService.getAllProducts().forEach(product -> LOGGER.info(product.toString() + "\n"));


        //show all orders made by customers
        orderService.getOrdersJoinCustomers().forEach(order -> LOGGER.info(order.toString() + "\n"));
        //get an order by the ID
        LOGGER.info(orderService.getOrderByID(1).toString());
        //update delivery date of an order
        orderService.updateDeliveryDate(1, Date.valueOf("2023-01-01"));
        //get all orders for a given customer
        orderService.getAllOrdersByCustomersID(3).forEach(order -> LOGGER.info(order.toString()));
//endregion



//region JSON
        JsonService jsonService = new JsonService();
        File jsonFile = new File("src/main/resources/json/deliveries.json");

        //serializing an delivery
        Customer customer3 = new Customer(3, "Johanis Crabbington", "Unknown", "randomguy@gmail.com");
        Order order3 = new Order(3, Date.valueOf("2023-02-03"), Date.valueOf("2023-02-13"), customer3);
        Vehicle vehicle = new Vehicle(1, "Ford", "E-Transit 2023", 300, true);
        Driver driver = new Driver(1, "Johnny Drover", "driver@gmail.com", vehicle);
        Delivery delivery = new Delivery(1, Date.valueOf("2023-02-13"), "In-Transit", driver, order3);
        jsonService.serializeObjectToJson(delivery, jsonFile);

        //de-serializing a JSON into an object
        Delivery deliveryObj = jsonService.deserializeJsonToObject(Delivery.class, jsonFile);
        LOGGER.info(deliveryObj);
//endregion


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
        Customer customer4 = new Customer(1, "Wimbledon CumberBatch", "London", "BennySnatch@gmail.com");
        Customer customer5 = new Customer(2, "another guy ", "ny", "random@gmail.com");
        List<Customer> list = new ArrayList<>();
        list.add(customer4);
        list.add(customer5);
        customersJaxB.setList(list);

        // some order data to marshall
        IJaxB<Order> orderjaxB = new OrdersJaxB();
        Order order1 = new Order(1, Date.valueOf("2023-02-03"), Date.valueOf("2023-02-13"), customer4);
        Order order2 = new Order(2, Date.valueOf("2023-03-09"), Date.valueOf("2023-03-15"), customer5);
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
        unmarshalled2.getList().forEach(order -> LOGGER.info(order.toString() + "\n"));
//endregion
    }

}
