package rollback;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScannerUserInputTest {
    @Test
    void testScan() throws SQLException {
        ScannerUserInput testObj = new ScannerUserInput();
        List<Data> values = testObj.getValues();
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM yahoo;");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            int age = resultSet.getInt("age");
            double salary = resultSet.getDouble("salary");
        for(Data dt : values) {
            assertEquals(name, dt.name);
            assertEquals(address, dt.address);
            assertEquals(age, dt.age);
            assertEquals(salary, dt.salary);
        }
        }
        conn.close();
    }
}