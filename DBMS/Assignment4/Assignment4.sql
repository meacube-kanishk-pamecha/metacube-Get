select * from ordert;


drop function if exists no_of_order;

delimiter //
CREATE FUNCTION no_of_order(month_num int , year_num int) RETURNS INT deterministic
BEGIN 
declare num int;
 SELECT COUNT(*) into num  FROM ORDERT 
 WHERE month(ORDERDATE) = month_num AND YEAR(ORDERDATE) = year_num;
 return num;
 END
 //
 DELIMITER ;
 select * from ordert;
SELECT no_of_order(03,2025) as orderCount;


drop function if exists max_order;


delimiter //
CREATE FUNCTION max_order(year_num int) RETURNS INT deterministic
BEGIN 
declare num int;
  SELECT month(ORDERDATE) num   FROM ORDERT 
 WHERE  YEAR(ORDERDATE) = year_num 
 group by month(ORDERDATE)
 order by count(*)desc
 limit 1;
 return num;
 END
 //
 DELIMITER ;
 ;
 SELECT max_order(2025) as maxOrders ;
 
 -- Assignment 2 
 use assignment;



select* from orderitem;
 
 drop procedure if exists procedure_order;
delimiter //
CREATE PROCEDURE procedure_order(month_sale int , year_sale int)
begin
select productId, productName ,avg(o.amount) as AverageSale  from orderitem o
join product p on p.proid = o.productid
join ordert t on t.orderid = o.orderid 
where month(orderdate) =month_sale and  year(orderdate) = year_sale
group by productId;
end //

delimiter ;
call procedure_order(2,2025);

 drop procedure if exists procedure_orderDetails;
delimiter //
CREATE PROCEDURE procedure_orderDetails(startDate date , endDate date)

begin
if startdate> endDate then
  set startDate = date_format(endDate ,'%y-%m-01');
 end if;
SELECT *  FROM orderitem o
JOIN product p ON p.proid = o.productid
JOIN ordert t ON t.orderid = o.orderid 
WHERE orderdate >=DATE(startdate) AND  orderdate <= DATE(enddate);
END //

delimiter ;
CALL procedure_orderDetails('2025-02-10','2025-03-03');


-- indexing on the row 
CREATE INDEX idx_OrderId
ON ordert (orderId, UserId);

CREATE INDEX idx_Category
ON category (CategoryId);

ALTER TABLE table_name
DROP INDEX  idx_OrderId ;