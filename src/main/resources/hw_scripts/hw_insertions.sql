insert into Customers(customer_name, address, contact_details)
values
	('John Doe', '123 New York', 'johndoe@gmail.com'),
	('Janey Doe', '123 New York', 'janey_doe@gmail.com'),
    ('Mary Poppin', '756 New York', 'marryPoppin@gmail.com'),
	('Bruce Manson' , 'Maryland' , 'Brucewayne@gmail.com');
    

insert into Products(product_name, product_description, price, stock_quantity)
values
	('Duracell AA Batteries', 'Duracell Coppertop AA batteries are made to power everyday devices', 19.99 , 150),
    ('Insulated Water Bottle', '40 fluid ounce, Insulated stainless steel water bottle, 100% BPA free', 15.99, 300);


insert into Vehicles(vehicle_make, vehicle_model, capacity, in_service)
values
	('Ford', 'E-Transit 2023', 300, 1);


insert into Drivers(driver_name, contact_details, vehicle_id) 
values
	('Wes Finch', 'wesFinch@yahoo.com', 1);


insert into Orders (order_date, delivery_date, order_status, customer_id)
values 
    ('2023-05-18', '2023-05-21', 'delivered', 3),
	('2023-05-25', null, 'in-transit', 1),
    ('2023-05-27', null, 'processing', 2);

insert into Order_payments(payment_method, total_amount, order_id)
values
	('Credit Card', 47.97, 1),
    ('Debit Card', 15.99, 2),
    ('PayPal', 55.97,3);
    
insert into Order_Items(order_id, quantity, product_id)
values
	(1, 3, 2),
	(2, 1, 2),
    (3, 2, 1),
    (3, 1, 2);


insert into Deliveries (expected_delivery_date, delivery_status, driver_id, order_id)
values
    ('2023-05-21', 1, 1, 1),
	('2023-05-30', 0, 1, 2),
    ('2023-06-01', 0, 1, 3);


insert into notifications(message, time_stamp, customer_id, delivery_id)
values 
	('Your order was shipped, now in-transit', '2023-05-20', 3, 1),
	('Your order was delivered', '2023-05-21', 3, 1),
	('Your order was shipped, now in-transit', '2023-05-28', 1, 2);


insert into Product_reviews(rating, comment_review, time_stamp, product_id, customer_id)
values
	(3, 'One of the bottles was missing the straw', '2023-05-21', 2, 3);


insert into Service_Feedback (delivery_rating, service_rating, comments, time_stamp, order_id, customer_id)
values 
	(5, 4, 'Shipping was fast, arrived on time', '2023-05-22', 1, 3);
