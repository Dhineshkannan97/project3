package rollback;

import java.sql.*;
import java.util.Scanner;

public class ScannerUserInput {
//    Update update = new Update();
    Insert in = new Insert();
    Data data = new Data();

    public ScannerUserInput() throws SQLException {
    }

    public void getValues() throws SQLException {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("enter your name ");
            String name = scan.next();
            System.out.println("enter your age");
            int age = scan.nextInt();
            System.out.println("enter your address");
            String address = scan.next();
            System.out.println("enter your salary");
            double salary = scan.nextDouble();
            data.name = name;
            data.age = age;
            data.salary = salary;
            data.address = address;
            in.insertData(data);
            System.out.println("Do you wish to continue (true/false)");
            flag = scan.nextBoolean();
        }
        scan.close();
    }
}
