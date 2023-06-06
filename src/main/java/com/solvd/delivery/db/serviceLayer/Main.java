package com.solvd.delivery.db.serviceLayer;

import com.solvd.delivery.db.model.Customer;
import com.solvd.delivery.db.model.Driver;
import com.solvd.delivery.db.model.Product;
import com.solvd.delivery.db.model.Vehicle;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CustomerService cs = new CustomerService();
        DriverService ds = new DriverService();
        VehicleService vs = new VehicleService();
        ProductService ps = new ProductService();
        OrderService os = new OrderService();


        //Getting customer from id
//        Customer customer = new CustomerService().getCustomer(1);
//        System.out.println(customer);

        //Adding a new customer
//        Customer newCustomer =  new Customer();
//        newCustomer.setName("Robbie Park");
//        newCustomer.setAddress("FieldView 5674");
//        newCustomer.setEmail("Robbie32@yahoo.com");
//        cs.addCustomer(newCustomer);

        //deleting a customer
//        cs.deleteCustomerByID(5);

        //Getting all the customers in db
//         List<Customer> customerList = new CustomerService().getAllCustomers();
//        for (Customer customer : customerList) {
//            System.out.println(customer);
//        }






        //Adding a new driver
//        Driver newDriver = new Driver();
//        newDriver.setName("Jack Brown");
//        newDriver.setEmail("JackieBrownie@gmail.com");
//        newDriver.setVehicle(vs.getVehicleByID(1));
//        ds.addDriver(newDriver);

        //deleting driver by id
//        ds.deleteDriverByID(6);

        //Getting all drivers in db
//        List<Driver> driverList = ds.getAllDrivers();
//        for (Driver driver : driverList) {
//            System.out.println(driver);
//        }







        //Getting product by id
//        System.out.println(ps.getProductByID(2));

        //adding new product to table
//        Product newProduct = new Product();
//        newProduct.setName("PS5");
//        newProduct.setDescription("Sony's latest console game system.");
//        newProduct.setPrice(500.00);
//        newProduct.setStock(10);
//        ps.addProduct(newProduct);

        //Deleting a product
//        ps.deleteProductByID(3);

        //Updating the price of an existing product
//        ps.updateProductPrice(4, 250.00);
//        ps.updateProductStock(4, 5);

        //Getting all products in db
//        List<Product> list = ps.getAllProducts();
//        for (Product product : list) {
//            System.out.println(product);
//        }







        //Get order by UserId
//        System.out.println(os.getOrderByUserID(1));

        //Updating delivery date
//        os.updateDeliveryDate(1, Date.valueOf("2023-05-09"));

        //Getting Customer by the order id
//        System.out.println(os.getCustomerByOrderID(1));









        //get vehicle by id
//        System.out.println(vs.getVehicleByID(1));


    }

}
