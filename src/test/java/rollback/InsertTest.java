package rollback;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class InsertTest {

    @Test
    void testTable() throws SQLException {
        Data data = new Data("bharathi", 22, 3.627623e+06, "sivagangai");
       Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM yahoo;");
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            int age= resultSet.getInt("age");
            double salary = resultSet.getDouble("salary");
            if (name.equals(data.name)){
                assertEquals(name, data.name);
                assertEquals(address,data.address);
                assertEquals(age,data.age);
                assertEquals(salary,data.salary);
            }
        }

    }


}