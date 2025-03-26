use assignment;

CREATE TABLE state (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20)
);
 CREATE TABLE city (
    id INT PRIMARY KEY AUTO_INCREMENT,
    stateid INT,
    name VARCHAR(20),
    CONSTRAINT FOREIGN KEY (stateid)
	REFERENCES state (id)
);
  CREATE TABLE zipCode (
    zipCode INT PRIMARY KEY,
    cityid INT,
    CONSTRAINT FOREIGN KEY (cityid)
	REFERENCES city (id)
);
  insert into state (name) values ("Rajasthan");
    insert into city (stateid ,name) values (1,"Jaipur"),(3,"Jodhpur");
    INSERT INTO zipCode (zipCode , cityid ) VALUES(303032,3);
    
SELECT Z.zipcode, C.name, S.name
FROM ZipCode Z 
JOIN City C ON Z.CityId = C.Id 
JOIN State S ON C.StateId = S.Id 
ORDER BY S.Name , C.Name;

    -- Display Count of products as per below price range:
    SELECT  
    CASE
        WHEN Price BETWEEN 0 AND 20000 THEN '0-2000'
        WHEN Price BETWEEN 20000 AND 25000 THEN '2000-25000'
        ELSE 'above 25000'
    END AS price_range,
    COUNT(*) AS count
    FROM product p
    GROUP BY price_range;
      
      
	SELECT c.ProId, c.ProductName, COUNT(P.CategoryId) AS count 
    FROM pro_category p 
    join product c on c.ProId = p.ProductId  
	GROUP BY c.ProId
	HAVING Count > 1;
    

-- Display top 20 Products which are ordered most in last 60 days along with numbers.
    SELECT 
    P.ProductName, COUNT(O.ProductId) AS COUNT
FROM orderitem O
LEFT JOIN product P ON O.ProductId = P.ProId
JOIN OrderT OT ON O.OrderId = OT.OrderId
WHERE OT.OrderDate >= (CURRENT_DATE - INTERVAL 60 DAY)
GROUP BY P.ProductName
ORDER BY COUNT
LIMIT 20; 
     
	-- Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
    SELECT MONTH(o.OrderDate) AS month_no, SUM(o.amount)
		FROM orderT o 
        GROUP BY month_no;
     

-- Display Shopper’s information along with number of orders he/she placed during last 30 days
SELECT *
FROM users 
JOIN ordert ON Users.UserId = users.userId
WHERE orderDate >= (CURRENT_DATE - INTERVAL 30 day);

select * from ordert;

-- Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT  O.UserId, U.NameUser, SUM(O.AMOUNT)
FROM ORDERT O JOIN
USERS U ON O.UserId = U.UserId
WHERE O.orderDate >= (CURRENT_DATE - INTERVAL 30 DAY)
GROUP BY O.userid
LIMIT 10; 

-- Display top 10 Items which were cancelled most
SELECT p.productName, COUNT(o.orderItemId) AS canceled
FROM orderItem o 
JOIN product p ON o.productId = p.ProId
WHERE o.statusOrder = 'CANCELED'
GROUP BY p.productname
ORDER BY canceled
LIMIT 10;


CREATE VIEW OrderView AS
SELECT O.OrderId, P.ProductName, P.Price, U.NameUser,  O.OrderDate, OI.StatusOrder
FROM OrderT O
JOIN Users U ON O.UserId = U.UserId
JOIN OrderItem OI ON O.OrderId = OI.OrderId
JOIN Product P ON OI.ProductId = P.ProId
WHERE O.OrderDate >= (CURRENT_DATE - INTERVAL 60 day)
ORDER BY O.OrderDate DESC;

-- Use the above view to display the Products(Items) which are in ‘shipped’ state
SELECT * FROM OrderView WHERE StatusOrder = 'SHIPED';

-- Use the above view to display the top 5 most selling products.
SELECT ProductName, COUNT(OrderId) AS OrderCount
FROM OrderView
GROUP BY ProductName
ORDER BY OrderCount DESC
LIMIT 5;

-- Mark the products as Inactive which are not ordered in last 90 days.
-- SELECT p.ProductName FROM product p 
-- EXCEPT
-- (select  p.ProductName from  product p join orderitem ot on ProId =  ProductId join Ordert O on O.OrderId = ot.OrderId   WHERE O.OrderDate >= (CURRENT_DATE - INTERVAL 90 day)) ;

UPDATE Product 
SET Stock = 0 
WHERE ProId NOT IN (
    SELECT DISTINCT ProductId FROM OrderItem 
    JOIN OrderT ON OrderItem.OrderId = OrderT.OrderId
    WHERE OrderT.OrderDate >= (CURRENT_DATE - INTERVAL 90 DAY)
);
select * from product;