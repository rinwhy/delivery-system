package com.solvd.delivery;

import com.solvd.delivery.bin.Customer;
import com.solvd.delivery.bin.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Date;

import com.solvd.delivery.service.mybatisimpl.CustomerService;
//import com.solvd.delivery.service.impl.CustomerService;

import com.solvd.delivery.service.mybatisimpl.ProductService;
//import com.solvd.delivery.service.impl.ProductService;

import com.solvd.delivery.service.mybatisimpl.OrderService;
//import com.solvd.delivery.service.impl.OrderService;


public class MainMyBatis {

    private static final Logger LOGGER = LogManager.getLogger(MainMyBatis.class);
    private static final CustomerService customerService = new CustomerService();
    private static final ProductService productService = new ProductService();
    private static final OrderService orderService = new OrderService();

    public static void main(String[] args) {

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



        //region products
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

        //endregion


        //region orders
        //show all orders made by customers
        orderService.getOrdersJoinCustomers().forEach(order -> LOGGER.info(order.toString() + "\n"));
        //get an order by the ID
        LOGGER.info(orderService.getOrderByID(1).toString());
        //update delivery date of an order
        orderService.updateDeliveryDate(1, Date.valueOf("2023-01-01"));
        //get all orders for a given customer
        orderService.getAllOrdersByCustomersID(3).forEach(order -> LOGGER.info(order.toString()));

        //endregion


    }

}
