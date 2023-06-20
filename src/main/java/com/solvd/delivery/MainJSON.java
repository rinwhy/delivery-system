package com.solvd.delivery;

import com.solvd.delivery.bin.Customer;
import com.solvd.delivery.bin.Order;
import com.solvd.delivery.bin.Vehicle;
import com.solvd.delivery.bin.Delivery;
import com.solvd.delivery.bin.Driver;


import com.solvd.delivery.service.impl.JsonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.sql.Date;

public class MainJSON {

    private static final Logger LOGGER = LogManager.getLogger(MainJSON.class);

    public static void main(String[] args) {

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

    }
}
