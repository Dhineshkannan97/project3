package rollback;
import rollback.data.Data;
import rollback.service.InseretDataService;
import rollback.service.DataInputService;
import java.util.List;
public class DataPersist {
    private final DataInputService service;
    private final InseretDataService  in;
    public DataPersist(InseretDataService in, DataInputService service) {
      this.in =in;
      this.service=service;
    }
    public void saveData() {
        List<Data> values = service.getValues();
        in.insertData(values);
    }
}
