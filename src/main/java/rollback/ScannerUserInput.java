package rollback;

import java.sql.*;
import java.util.Scanner;

public class ScannerUserInput {
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
    //    ArrayList<Data> values = new ArrayList<>();
    static ScannerUserInput input;

    static {
        try {
            input = new ScannerUserInput();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static Data obj = new Data();
    Statement stmt = conn.createStatement();

    public ScannerUserInput() throws SQLException {
    }

    public static void getValues() throws SQLException {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the ID to update");
            int id = scan.nextInt();
            System.out.println("enter your name ");
            String name = scan.next();
            System.out.println("enter your age");
            int age = scan.nextInt();
            System.out.println("enter your address");
            String address = scan.next();
            System.out.println("enter your salary");
            double salary = scan.nextDouble();
//            values.add(new Data(name, age, salary, address));
//            obj(name, age, salary, address);
            obj.name = name;
            obj.age = age;
            obj.salary = salary;
            obj.address = address;
            obj.id = id;
            input.addValues();
            System.out.println("Do you wish to continue (true/false)");
            flag = scan.nextBoolean();
        }
        scan.close();
    }

    public void addValues() throws SQLException {
//        for (Data data : values) {
        conn.setAutoCommit(false);
        stmt.executeQuery("SELECT * FROM yahoo;");
        String sql = "update yahoo set name='" + obj.name + "',age=" + obj.age + " where id=" + obj.id + ";";
//            String sql = "UPDATE yahoo (ID,NAME,AGE,ADDRESS,SALARY) "
//                    + "VALUES (" + data.id + ", '" + data.name + "'," + data.age + ", '" + data.address + "'," +data.salary + " );";
        PreparedStatement p = conn.prepareStatement(sql);
        p.execute();
//            stmt.executeUpdate(sql1);
        conn.commit();
//        }
        conn.rollback();
    }

    public static void main(String[] args) throws SQLException {
        getValues();
    }
}
