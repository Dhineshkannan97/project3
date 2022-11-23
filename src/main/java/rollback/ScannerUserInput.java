package rollback;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ScannerUserInput {
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
    ArrayList<Data> values = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    Statement stmt = conn.createStatement();


    public ScannerUserInput() throws SQLException {
    }

    public void getValues() {
        boolean flag = true;
        while (flag) {
            System.out.println("enter your name ");
            String name = scan.next();
            System.out.println("enter your age");
//            int id = scan.nextInt();
            int age = scan.nextInt();
            System.out.println("enter your address");
            String address = scan.next();
            System.out.println("enter your salary");
            double salary = scan.nextDouble();
            values.add(new Data(name, age, salary, address));
            System.out.println(values);
            System.out.println("Do you wish to continue (true/false)");
            flag = scan.nextBoolean();
        }
    }

    public void addValues() throws SQLException {
        for (Data data : values) {
            conn.setAutoCommit(false);
            stmt.executeQuery("SELECT * FROM yahoo;");
            String sql = "update yahoo set name='" + data.name + "' where id=1;";
//            String sql = "UPDATE yahoo (ID,NAME,AGE,ADDRESS,SALARY) "
//                    + "VALUES (" + data.id + ", '" + data.name + "'," + data.age + ", '" + data.address + "'," +data.salary + " );";
            PreparedStatement p = conn.prepareStatement(sql);
            p.execute();
//            stmt.executeUpdate(sql1);
            conn.commit();
        }
        conn.rollback();
    }

    public static void main(String[] args) throws SQLException {
        ScannerUserInput input = new ScannerUserInput();
        input.getValues();
        input.addValues();
    }
}
