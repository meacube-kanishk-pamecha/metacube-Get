import java.sql.*;
public class Image {
    public static void insertImages(Connection conn, Object[][] data) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Queries.insert_image);
        for (Object[] row : data) {
            ps.setInt(1, (int) row[0]);
            ps.setInt(2, (int) row[1]);
            ps.setString(3, (String) row[2]);
            ps.addBatch();
        }
        int[] batchResults = ps.executeBatch();
        for (int result : batchResults) {
            System.out.println("Inserted: " + result);
        }
        ps.close();
    }
}
