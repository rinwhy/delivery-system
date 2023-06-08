package com.solvd.delivery;

import com.solvd.delivery.bin.*;
import com.solvd.delivery.dao.IOrderDAO;
import com.solvd.delivery.dao.IVehicleDAO;
import com.solvd.delivery.dao.impl.*;

public class Main {

    public static void main(String[] args) {

        IOrderDAO orderDAO = new OrderDAO();


////        System.out.println(orderDAO.getByID(2));
//        Order order = new Order();
//        order.setOrderDate(Date.valueOf("2023-06-06"));
//        order.setDeliveryDate(Date.valueOf("2023-06-20"));
//        order.setCustomer(new CustomerDAO().getByID(2));

//        orderDAO.insert(order);

//        orderDAO.updateDeliveryDate(null, 3 );

//        for (Order o : orderDAO.getAllForCustomer(1)) {
//            System.out.println(o);
//        }


//        IProductDAO productDAO = new ProductDAO();
//
////        System.out.println(productDAO.getByID(1));
//
//        Product newProduct = new Product();
//        newProduct.setName("PS5");
//        newProduct.setDescription("Playstation 5, sony's latest console gaming system");
//        newProduct.setPrice(500);
//        newProduct.setStock(40);
////
//        productDAO.insert(newProduct);
//
//
//        for (Product product : productDAO.getAll()) {
//            System.out.println(product);
//        }

        IVehicleDAO vehicleDAO = new VehicleDAO();

//        System.out.println(vehicleDAO.getByID(1));
//
//        Vehicle nv = new Vehicle();
//        nv.setMake("efsajkfsda");
//        nv.setModel("dssdafg");
//        nv.setCapacity(50);
//        nv.setInService(true);

        vehicleDAO.deleteByID(4);
        vehicleDAO.deleteByID(5);
//vehicleDAO.deleteByID(2);


        for (Vehicle v : vehicleDAO.getAll()) {
            System.out.println(v);
        }


    }

}
