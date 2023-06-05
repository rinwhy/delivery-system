create database Delivery_System;
Use Delivery_System;

 create table Customers (
customer_id int primary key not null auto_increment,
customer_name varchar(100) not null,
address varchar(100) not null,
email varchar(100) not null unique
);

create table Products(
product_id int primary key not null unique auto_increment, 
product_name varchar(45) not null,
product_description varchar(100) not null,
price decimal(8,2) not null,
stock_quantity int not null
);

create table Orders(
order_id int primary key not null auto_increment,
order_date datetime not null,
delivery_date datetime,
order_status varchar(10) not null,
customer_id int not null,
foreign key(customer_id) references Customers(customer_id)
);

create table Order_Payments(
payment_id int primary key not null auto_increment,
payment_method varchar(45) not null,
total_amount decimal(8,2) not null,
order_id int not null,
foreign key(order_id) references Orders(order_id)
);

create table Return_Requests(
return_request_id int primary key not null auto_increment,
return_reason varchar(45),
return_status varchar(45) not null,
order_id int not null,
foreign key(order_id) references Orders(order_id)
);

create table Order_Items(
order_item_id int primary key not null auto_increment,
quantity int not null,
order_id int not null,
product_id int not null,
foreign key(order_id) references Orders(order_id),
foreign key(product_id) references Products(product_id)
);

create table Product_Reviews(
review_id int primary key not null auto_increment,
rating int not null,
comment_review varchar(100),
time_stamp timestamp not null,
product_id int not null,
customer_id int not null,
foreign key(product_id) references Products(product_id),
foreign key(customer_id) references Customers(customer_id)
);

create table Service_Feedback(
feedback_id int primary key not null auto_increment,
delivery_rating int,
service_rating int,
comments varchar(100),
time_stamp timestamp not null,
order_id int not null,
customer_id int not null,
foreign key(order_id) references Orders(order_id),
foreign key(customer_id) references Customers(customer_id)
);

create table Vehicles(
vehicle_id int primary key not null auto_increment,
vehicle_make varchar(45) not null,
vehicle_model varchar(45) not null,
capacity int not null,
in_service tinyint not null
);

create table Drivers(
driver_id int primary key not null auto_increment,
driver_name varchar(100) not null,
email varchar(100) not null unique,
vehicle_id int not null,
foreign key(vehicle_id) references Vehicles(vehicle_id)
);

create table Deliveries(
delivery_id int primary key not null auto_increment,
expected_delivery_date date not null,
delivery_status tinyint not null,
driver_id int not null,
order_id int not null,
foreign key(order_id) references Orders(order_id),
foreign key(driver_id) references Drivers(driver_id)
);

create table Notifications(
notification_id int primary key not null auto_increment,
message varchar(150) not null,
time_stamp timestamp not null,
customer_id int not null,
delivery_id int not null, 
foreign key(customer_id) references Customers(customer_id),
foreign key(delivery_id) references Deliveries(delivery_id)
);
