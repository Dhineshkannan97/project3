package rollback;

import java.sql.*;

public class Insert {
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
    Statement stmt = conn.createStatement();

    public Insert() throws SQLException {
    }

    public void insertData(Data data) throws SQLException {
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            stmt.executeQuery("SELECT * FROM yahoo;");
            String sql = "INSERT INTO yahoo (NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES ( '" + data.name + "'," + data.age + ", '" + data.address + "'," + data.salary + " );";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.commit();
//            stmt.close();
//            conn.close();
    }


}




