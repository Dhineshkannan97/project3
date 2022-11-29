package rollback.sql;

import rollback.data.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Insert {
    public void insertData(List<Data> data) throws SQLException {
        try (InputStream input = new FileInputStream("C:\\Users\\Dhinesh Kannan\\Documents\\Streams\\project3\\src\\main\\resources\\db.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
            Statement stmt = conn.createStatement();
            conn.setAutoCommit(false);
            for (Data detail : data)
                try {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}




