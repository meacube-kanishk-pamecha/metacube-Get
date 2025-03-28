import java.sql.*;

class Solution {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/assignment";
        String userName = "root";
        String password = "root";
        String query = "INSERT INTO Image (ImageID,ProductId,Link) VALUES (?,?,?)";
        String query1 = "Select NameUser from users";
        try {
            System.out.println("Hello");
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, userName, password);
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Object[][] data = {
                    { 50, 1, "https://linkKanishk" },
                    { 51, 1, "https://linkKanishk" },
                    { 52, 1, "https://linkKanishk" },
                    { 53, 1, "https://linkKanishk" },
                    { 54, 1, "https://linkKanishk" },
                    { 55, 1, "https://linkKanishk" },
                    { 56, 1, "https://linkKanishk" }
                    
            };
            PreparedStatement pd = c.prepareStatement(query);
            for (Object[] row : data) {
                pd.setInt(1, (int) row[0]); // id
                pd.setInt(2, (int) row[1]);
                pd.setString(3, (String) row[2]);
                pd.addBatch();
            }
            int[] batchResults = pd.executeBatch();

            for (int result : batchResults) {
                System.out.println(result);
            }
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            String queryOrderFetch = "select t.Orderid , t.amount ,t.orderDate from ordert t inner join\n" + //
                    "orderitem O on O.Orderid = t.Orderid where statusOrder ='SHIPED' and t.userid = 2 ORDER BY t.ORDERDATE";

            rs = st.executeQuery(queryOrderFetch);
            
            while (rs.next()) {
                System.out.println(rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
            }

            String deletQuery = " with inactivepro as ( SELECT Proid FROM PRODUCT INNER JOIN ORDERITEM O ON O.ProductId = Proid)\n"
                    + //
                    " delete from product where proid not in(select proid from inactivepro)";
                   int x =  st.executeUpdate(deletQuery);
                   System.out.println(x);
         
            st.close();
            c.close();
            System.out.println("Connection closed.");
        }

        catch (Exception e) {
            System.out.println(e.getMessage() + e + " hello ");
        }
    }
}