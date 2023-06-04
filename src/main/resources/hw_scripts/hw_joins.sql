select * from customers inner join orders on customers.customer_id = orders.customer_id;
select * from customers left join orders on customers.customer_id = orders.customer_id;
select * from customers right join orders on customers.customer_id = orders.customer_id;
select * from products right outer join product_reviews on products.product_id = product_reviews.product_id;
select customers.customer_name, Orders.*, Products.product_name from customers 
			left join orders on customers.customer_id = orders.customer_id 
				join order_items on orders.order_id = order_items.order_id
				join products on order_items.product_id =  products.product_id;
                
                

select *
from customers C
join orders O on C.customer_id = O.customer_id
join return_requests RR on C.customer_id = RR.customer_id
join order_items OI on O.order_id = OI.order_id
join order_payments OP on O.order_id = OP.order_id
join product_reviews PR on OI.product_id = PR.product_id
join service_feedback SF on O.order_id = SF.order_id 
join deliveries DL on O.order_id = DL.order_id
join notifications N on C.customer_id = N.customer_id
join drivers D on DL.driver_id = D.driver_id;
