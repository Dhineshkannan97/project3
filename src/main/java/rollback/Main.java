package rollback;

import rollback.data.Data;
import rollback.propertiesfile.CreatingPropertiesFile;
import rollback.scanner.ScannerUserInput;
import rollback.sql.Insert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ScannerUserInput input = new ScannerUserInput();
        Insert in =new Insert();
        List<Data> values = input.getValues();
        in.insertData(values);
        CreatingPropertiesFile file = new CreatingPropertiesFile();
        file.toFile();
    }
}
