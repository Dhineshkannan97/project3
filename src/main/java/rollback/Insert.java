package rollback;

import java.sql.*;
import java.util.List;
public class Insert {
    public void insertData(List<Data> data) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
        Statement stmt = conn.createStatement();
        for (Data detail : data)
            try {
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                stmt.executeQuery("SELECT * FROM yahoo;");
                String sql = "INSERT INTO yahoo (NAME,AGE,ADDRESS,SALARY) "
                        + "VALUES ( '" + detail.name + "'," + detail.age + ", '" + detail.address + "'," + detail.salary + " );";
                stmt.executeUpdate(sql);
                conn.commit();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                conn.rollback();
            } finally {
                conn.setAutoCommit(true);
                stmt.close();
                conn.close();
            }

    }
}




