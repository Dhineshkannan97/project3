package rollback.data;

public class Data {
    public int id;
    public String name;
    public int age;
    public double salary;
    public String address;

    public Data(String name, int age, double salary, String address) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }
    public Data(int id,String name, int age, double salary, String address) {
        this.id= id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }
}
