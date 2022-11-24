package rollback;
import java.sql.*;


public class Update {
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123456");
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM yahoo;");
    public Update() throws SQLException {
    }
    public void addValues(Data data) throws SQLException {
        conn.setAutoCommit(false);
        String sql = "update yahoo set name='" + data.name + "',age=" + data.age + " where id=" + data.id + ";";
        PreparedStatement p = conn.prepareStatement(sql);
        p.execute();
        conn.commit();
        conn.rollback();
    }
}
