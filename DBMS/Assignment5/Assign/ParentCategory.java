import java.sql.*;
public class ParentCategory {
    public static void fetchParentCategories(Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(Queries.fetch_parent);
        while (rs.next()) {
            System.out.println(rs.getString(1) + " : " + rs.getInt(2));
        }
        rs.close();
        st.close();
    }
}