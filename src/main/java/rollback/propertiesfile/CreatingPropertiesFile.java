package rollback.propertiesfile;

import rollback.data.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CreatingPropertiesFile {
    public CreatingPropertiesFile()  {
    }
    public void toFile() throws IOException, SQLException {
        List<Data> list=new ArrayList<>();
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM yahoo;");
        while(rs.next())
    {
        list.add(new Data( rs.getInt("id"), rs.getString("name"),rs.getInt("age"), rs.getFloat("salary"), rs.getString("address")));
    }
        Properties prop = new Properties();
        System.out.println(list);
        prop.put("list",list.toString());
        String loc = "C:\\Users\\Dhinesh Kannan\\Documents\\Streams\\project3\\src\\main\\resources\\rollback.txt";
        FileOutputStream out = new FileOutputStream(loc);
        prop.store(out,"file saved");
    }

}
