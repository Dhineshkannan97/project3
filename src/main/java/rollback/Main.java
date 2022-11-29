package rollback;

import rollback.data.Data;
import rollback.scanner.ScannerUserInput;
import rollback.sql.Insert;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        ScannerUserInput input = new ScannerUserInput();
        Insert in =new Insert();
        List<Data> values = input.getValues();
        in.insertData(values);
    }
}
