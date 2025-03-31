import java.sql.*;
public class FetchOrder {
    public static void fetchOrders(Connection conn, int userId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Queries.fetch);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
        }
        rs.close();
        ps.close();
    }
}
