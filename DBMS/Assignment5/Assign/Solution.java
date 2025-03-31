import java.sql.*;
class Solution {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/assignment";
        String userName = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection ct = DriverManager.getConnection(url, userName, password);
            Object[][] imageData = {
                    { 21, 1, "https://linkKanishk" },
                    { 11, 1, "https://linkKanishk" },
                    { 10, 1, "https://linkKanishk" },
                    { 20, 1, "https://linkKanishk" },
                    { 30, 1, "https://linkKanishk" },
                    { 47, 1, "https://linkKanishk" },
                    { 88, 1, "https://linkKanishk" }
            };
            // Image.insertImages(ct, imageData);
            FetchOrder.fetchOrders(ct, 2);
            DeleteProduct.deleteUnusedProducts(ct);
            ParentCategory.fetchParentCategories(ct);
            ct.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}