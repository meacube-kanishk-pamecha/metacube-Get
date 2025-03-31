import java.sql.*;
public class DeleteProduct {
    public static void deleteUnusedProducts(Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        int deleted = st.executeUpdate(Queries.delete_product);
        System.out.println("Products deleted: " + deleted);
        st.close();
    }
}