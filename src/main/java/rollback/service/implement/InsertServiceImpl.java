package rollback.service.implement;

import rollback.data.Data;
import rollback.service.InseretDataService;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class InsertServiceImpl implements InseretDataService {
    @Override
    public void insertData(List<Data> data) {
//
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("myconf.properties")) {
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
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}




