package rollback;

import rollback.data.Data;
import rollback.depandancyinjection.InseretDataService;
import rollback.scanner.ScannerUserInput;
import rollback.sql.InsertServiceImpl;

import java.util.List;

public class Main {

    private static InseretDataService in;
    public Main(InseretDataService in) {
      this.in = in;
    }

    public void test(List<Data> data){
        in.insertData(data);
    }

    public static void main(String[] args) {
        ScannerUserInput input = new ScannerUserInput();
        List<Data> values = input.getValues();
//        InseretDataService in = new InsertServiceImpl();
        in.insertData(values);

    }
}
