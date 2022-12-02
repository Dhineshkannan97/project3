package rollback;

import rollback.service.DataInputService;
import rollback.service.InseretDataService;
import rollback.service.implement.DataInputServiceImpl;
import rollback.service.implement.InsertServiceImpl;

public class Main {
    public static void main(String[] args) {
        DataInputService service1 = new DataInputServiceImpl();
        InseretDataService in = new InsertServiceImpl();
        DataPersist data = new DataPersist(in, service1);
        data.saveData();
    }
}
