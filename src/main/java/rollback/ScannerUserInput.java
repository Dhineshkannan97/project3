package rollback;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerUserInput {
    List<Data> data= new ArrayList<>();
    public  List<Data> getValues(){
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("enter your name");
            String name = scan.next();
            System.out.println("enter your age");
            int age = scan.nextInt();
            System.out.println("enter your address");
            String address = scan.next();
            System.out.println("enter your salary");
            double salary = scan.nextDouble();
            data.add(new Data( name, age, salary,address));
            System.out.println("Do you wish to continue (true/false)");
            flag = scan.nextBoolean();
        }
        scan.close();
        return data;
    }
}
