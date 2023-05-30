select count(*) as customer_count from Customers;																-- shows total amount of customers in db
select product_id, min(stock_quantity) as min_stock from products group by product_id limit 1;					-- shows what product has the lowest stock quantity
select product_id, avg(rating) as average_rating from Product_Reviews group by product_id;						-- shows the average rating for every product
select order_id, min(delivery_rating) as rating from service_feedback group by order_id; 						-- shows the lowest rating for a delivery made
select order_id, sum(quantity) as total_quantity from Order_Items group by order_id;							-- shows the total items in each order
select month(order_date) as order_month, count(*) from orders group by order_month;								-- shows how many orders were placed for each month 
select orders.customer_id, sum(order_items.quantity) as total_quantity from order_items join orders on order_items.order_id = orders.order_id group by orders.customer_id;						-- shows the amount items ordered by each of the customers

select product_name, min(price) as price from products group by product_name having price <= 16;		-- products that cost less than or equal to $16
select product_name, max(price) as price from products group by product_name having price >= 16;		-- products that cost more than or equal to $16 
select customer_id, count(*) as order_count from orders group by customer_id having count(*) > 0;		-- costumers that have placed more than 0 orders
select product_id, avg(rating) from product_reviews group by product_id having avg(rating) >= 3;		-- products that have aleast a 3 star rating
select delivery_id, delivery_status, count(*) from deliveries group by delivery_id having delivery_status = 1;		-- the deliveries that have been completed     
select customer_id, count(*) as notifications from notifications group by customer_id having notifications>1;		-- show customers that have recived more than 1 notification	
select driver_id, COUNT(*) as total_deliveries from Deliveries group by driver_id having total_deliveries > 2;		-- show drivers that have made more than 2 deliveries