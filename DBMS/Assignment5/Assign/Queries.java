
class Queries {
     static String insert_image = "INSERT INTO Image (ImageID, ProductId, Link) VALUES (?,?,?)";
    
     static  String fetch = "SELECT t.Orderid, t.amount, t.orderDate FROM ordert t INNER JOIN \n"
            + "orderitem O ON O.Orderid = t.Orderid WHERE statusOrder ='SHIPED' AND t.userid = ? ORDER BY t.ORDERDATE";
    static  String delete_product = "WITH inactivepro AS (SELECT Proid FROM PRODUCT INNER JOIN ORDERITEM O ON O.ProductId = Proid) \n"
            + "DELETE FROM product WHERE proid NOT IN (SELECT proid FROM inactivepro)";
    static String fetch_parent = "SELECT c.categoryTitle, COUNT(sub.categoryId) FROM Category c LEFT JOIN Category sub ON c.categoryId = sub.parentId WHERE c.parentId IS NULL GROUP BY c.categoryTitle ORDER BY c.categoryTitle";
}


