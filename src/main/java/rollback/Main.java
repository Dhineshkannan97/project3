package rollback;

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
