select * from customers inner join orders on customers.id = orders.customer_id;
select * from customers left join orders on customers.id = orders.customer_id;
select * from customers right join orders on customers.id = orders.customer_id;
select * from products right outer join product_reviews on products.id = product_reviews.product_id;
select customers.name, Orders.*, Products.name from customers 
			left join orders on customers.id = orders.customer_id 
				join order_items on orders.id = order_items.order_id
				join products on order_items.product_id =  products.id;
                
                

select *
from customers C
join orders O on C.id = O.customer_id
join return_requests RR on O.id = RR.order_id
join order_items OI on O.id = OI.order_id
join order_payments OP on O.id = OP.order_id
join product_reviews PR on OI.product_id = PR.product_id
join service_feedback SF on O.id = SF.order_id 
join deliveries DL on O.id = DL.order_id
join notifications N on C.id = N.customer_id
join drivers D on DL.driver_id = D.id;
