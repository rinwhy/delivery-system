drop database Delivery_System;
create database Delivery_System;
Use Delivery_System;

 create table Customers (
id int primary key not null auto_increment,
name varchar(100) not null,
address varchar(100) not null,
email varchar(100) not null unique
);

create table Products(
id int primary key not null unique auto_increment, 
name varchar(45) not null,
description varchar(100) not null,
price decimal(8,2) not null,
stock int not null
);

create table Orders(
id int primary key not null auto_increment,
order_date datetime not null,
delivery_date datetime,
customer_id int not null,
foreign key(customer_id) references Customers(id)
);

create table Order_Payments(
id int primary key not null auto_increment,
payment_method varchar(45) not null,
total_amount decimal(8,2) not null,
order_id int not null,
foreign key(order_id) references Orders(id)
);

create table Return_Requests(
id int primary key not null auto_increment,
reason varchar(45),
status varchar(45) not null,
order_id int not null,
foreign key(order_id) references Orders(id)
);

create table Order_Items(
id int primary key not null auto_increment,
quantity int not null,
order_id int not null,
product_id int not null,
foreign key(order_id) references Orders(id),
foreign key(product_id) references Products(id)
);

create table Product_Reviews(
id int primary key not null auto_increment,
rating int not null,
comment_review varchar(100),
time_stamp timestamp not null,
product_id int not null,
customer_id int not null,
foreign key(product_id) references Products(id),
foreign key(customer_id) references Customers(id)
);

create table Service_Feedback(
id int primary key not null auto_increment,
delivery_rating int,
service_rating int,
comment varchar(200),
time_stamp timestamp not null,
order_id int not null,
customer_id int not null,
foreign key(order_id) references Orders(id),
foreign key(customer_id) references Customers(id)
);

create table Vehicles(
id int primary key not null auto_increment,
make varchar(45) not null,
model varchar(45) not null,
capacity int not null,
in_service tinyint not null
);

create table Drivers(
id int primary key not null auto_increment,
name varchar(100) not null,
email varchar(100) not null unique,
vehicle_id int not null,
foreign key(vehicle_id) references Vehicles(id)
);

create table Deliveries(
id int primary key not null auto_increment,
expected_delivery_date date not null,
status varchar(45) not null,
driver_id int not null,
order_id int not null,
foreign key(order_id) references Orders(id),
foreign key(driver_id) references Drivers(id)
);

create table Notifications(
id int primary key not null auto_increment,
message varchar(150) not null,
time_stamp timestamp not null,
customer_id int not null,
delivery_id int not null, 
foreign key(customer_id) references Customers(id),
foreign key(delivery_id) references Deliveries(id)
);
