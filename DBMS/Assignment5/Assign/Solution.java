import java.sql.*;
class Solution {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/assignment";
        String userName = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, userName, password);
            Object[][] imageData = {
                    { 50, 1, "https://linkKanishk" },
                    { 51, 1, "https://linkKanishk" },
                    { 52, 1, "https://linkKanishk" },
                    { 53, 1, "https://linkKanishk" },
                    { 54, 1, "https://linkKanishk" },
                    { 55, 1, "https://linkKanishk" },
                    { 56, 1, "https://linkKanishk" }
            };
            Image.insertImages(conn, imageData);
            FetchOrder.fetchOrders(conn, 2);
            DeleteProduct.deleteUnusedProducts(conn);
            ParentCategory.fetchParentCategories(conn);
            conn.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}