-- creating a database
CREATE DATABASE Assignment;

-- using the database
USE Assignment;

-- create a table 
CREATE TABLE Users(
 UserId INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
 NameUser VARCHAR(25));
 
CREATE TABLE Product(
 ProId INT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
 ProductName VARCHAR(50),
 Price INT, 
 TimeAdd TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 Stock INT ); 
 
CREATE TABLE Image (
 ImageId INT PRIMARY KEY,
 ProductId INT , 
 Link varchar(50),
 FOREIGN KEY (ProductId) REFERENCES Product(ProId));
 
CREATE TABLE OrderT(
OrderId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 UserId INT, 
 AMOUNT INT, 
 OrderDate Date,
FOREIGN KEY (UserId) REFERENCES Users(UserId));
 
CREATE TABLE OrderItem(
OrderItemId INT NOT NULL PRIMARY KEY AUTO_INCREMENT , 
OrderId INT, 
AMOUNT INT,
ProductId INT,
StatusOrder ENUM('SHIPED','CANCELED','PENDING'),
 FOREIGN KEY (OrderId) REFERENCES OrderT(OrderId), 
 FOREIGN KEY (ProductId) REFERENCES Product(ProId));
 
CREATE TABLE Category(
CategoryId INT NOT NULL PRIMARY KEY AUTO_INCREMENT , 
NameCate VARCHAR(30),
 ProductCategory INT , 
  FOREIGN KEY (ProductCategory) REFERENCES Category(CategoryId));
 
CREATE TABLE ShippingAddress(
ShippingAddressId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
UserId INT , Address VARCHAR(100), 
 FOREIGN KEY (UserId) REFERENCES Users(UserId));
 
 CREATE TABLE Pro_category(
 PCId INT PRIMARY KEY, 
 ProductId INT ,
 CategoryId INT,
 FOREIGN KEY (ProductId) REFERENCES Product(ProId),
 FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId));
 
-- droping table product  
DROP TABLE Product;

-- inserting the Users
INSERT INTO Users (NameUser) VALUES
 ('RAM'),
('Kanishk'),
('Maynk'),
('Raj');

-- Insert Products (Mobiles)
INSERT INTO Product (ProductName, Price, Stock) VALUES 
  ('Samsung Galaxy M14', 14999, 30),
  ('iPhone 13', 62999, 15),
  ('OnePlus Nord CE 3 Lite', 19999, 25),
  ('Redmi Note 12 Pro', 24999, 40),
  ('Realme Narzo 50', 12999, 35),
  ('Vivo Y21', 13999, 50),
  ('Samsung Galaxy S25', 14999, 30),
  ('iPhone 15', 62999, 15);

-- Insert Images for Mobiles
INSERT INTO Image (ImageId, ProductId, Link) VALUES
(1, 1, 'samsung_m14.jpg'),
(2, 2, 'iphone_13.jpg'),
(3, 3, 'oneplus_nord_ce3.jpg'),
(4, 4, 'redmi_note_12pro.jpg'),
(5, 5, 'realme_narzo_50.jpg'),
(6, 6, 'vivo_y21.jpg');

SELECT * from Category;
SELECT * from Product;

INSERT INTO Pro_category (PCId , ProductId ,CategoryId ) VALUES
(1, 1, 2),
(2, 2, 3),
(3, 3, 4),
(4, 4, 3),
(5, 5, 5),
(6, 6, 1);
-- Insert Orders
INSERT INTO OrderT (UserId, AMOUNT,OrderDate) VALUES
(2, 999,'2025-03-20'),
(1, 14999,'2025-02-24'),
(2, 62999,'2025-02-10'),
(2, 999,'2025-03-20'),
(3, 19999,'2025-03-24');

-- Insert Order Items
INSERT INTO OrderItem (OrderId, AMOUNT, ProductId, StatusOrder) VALUES
(4, 1, 1, 'PENDING'),
(4, 1, 1, 'SHIPED'),
(5, 1, 2, 'PENDING'),
(6, 1, 3, 'CANCELED');

-- Insert Categories (Mobile Category and Subcategories)
INSERT INTO Category (NameCate, ProductCategory) VALUES
('Electronics', NULL),
('Mobile Phones', 1),
('Smartphones', 2),
('5G Phones', 3),
('Budget Phones', 3);

-- Insert Shipping Addresses
INSERT INTO ShippingAddress (UserId, Address) VALUES
(1, '123, MG Road, Mumbai, Maharashtra'),
(2, '45, Rajpath Nagar, Ahmedabad, Gujarat'),
(3, '67, Connaught Place, New Delhi');

-- Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
select ProductName , Price 
 FROM  Product WHERE Stock > 0 
 ORDER BY TimeAdd ASC ;

-- Display the list of products which don't have any images.
SELECT ProductName , Price
FROM  Product
LEFT JOIN  Image
ON Product.ProId = Image.ProductId
WHERE Image.Link IS NULL;

-- Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT ProductName , Price , Stock
FROM  Product
WHERE Stock < 50;

 -- Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. 
 SELECT C1.CategoryId,C1.NameCate ,COALESCE(C2.NameCate, "Top Category") AS Parent_Category  FROM Category C1
 LEFT JOIN Category C2 ON C1.ProductCategory = C2.CategoryId  order by Parent_Category ,  C1.NameCate;
 
 -- Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
SELECT CategoryId, NameCate FROM Category
WHERE CategoryId NOT IN (SELECT DISTINCT ProductCategory FROM Category WHERE ProductCategory IS NOT NULL);

 -- Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT P.ProductName, P.Price
FROM Product P
JOIN Pro_category PC ON P.ProId = PC.ProductId
JOIN Category C ON PC.CategoryId = C.CategoryId
WHERE C.NameCate = 'Mobile Phones';


-- Display Recent 50 Orders placed (Id, Order Date, Order Total)
SELECT  OrderId, AMOUNT, OrderDate  
FROM OrderT  
ORDER BY OrderDate Desc
LIMIT 50 ;

-- Display 10 most expensive Orders.
SELECT  OrderId, AMOUNT, OrderDate  
FROM OrderT  
ORDER BY AMOUNT Desc
LIMIT 10 ;
-- Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
SELECT DISTINCT O.OrderId, O.OrderDate, O.AMOUNT
FROM OrderT O
JOIN OrderItem OI ON O.OrderId = OI.OrderId
WHERE O.OrderDate < (CURRENT_DATE - INTERVAL 10 DAY) 
AND OI.StatusOrder != 'SHIPED';


 -- Display list of shoppers which haven't ordered anything since last month.

 SELECT U.UserId, U.NameUser
FROM Users U
LEFT JOIN OrderT O ON U.UserId = O.UserId 
AND O.OrderDate >= (CURRENT_DATE - INTERVAL 1 MONTH)
WHERE O.OrderId IS NULL;

 
-- Display list of shopper along with orders placed by them in last 15 days. 
SELECT U.UserId, NameUser, OrderId, AMOUNT, OrderDate FROM Users U RIGHT JOIN OrderT O ON U.UserId = O.UserId 
WHERE OrderDate >(CURRENT_TIME-interval 15 DAY) ;

-- Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
Select OrderItemId, ProductId, StatusOrder from OrderItem oi WHERE  oi.OrderId = 4 AND StatusOrder ='SHIPED'  ;

-- Display list of order along with order placed date which fall between Rs 20 to Rs 50 price.
Select * from OrderT where Amount>2000 AND Amount<50000;

SELECT * FROM Category;