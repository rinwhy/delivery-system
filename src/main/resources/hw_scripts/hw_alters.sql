alter table Customers auto_increment=1;
alter table Products modify price decimal(8,2);
alter table Notifications modify message varchar(150);
alter table vehicles add column vehicle_model varchar(45) not null;
alter table vehicles modify column vehicle_model varchar(45) after vehicle_make;
alter table deliveries drop column current_location;