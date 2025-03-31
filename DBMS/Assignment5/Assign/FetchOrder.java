import java.sql.*;
import java.util.*;
public class FetchOrder {
    public static List<Orders> fetchOrders(int userId) throws SQLException, ClassNotFoundException {
        List<Orders> list = new ArrayList<>();
        try(Connection conn = Solution.getConnection();){
            PreparedStatement stat = conn.prepareStatement(Queries.fetch);
            stat.setInt(1, userId);

            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                Orders o = new Orders(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                System.out.println(o);
                list.add(o);
            }
            
        }
        return list;
    }

}
