import org.testng.annotations.Test;
import utilities.DBConnection;
import utilities.ReadProperties;

import java.sql.SQLException;

public class TestDBConnection {

    @Test
    public void learnSQLDB() throws SQLException, ClassNotFoundException {
        String username = "root";
        String passwrd = "Ranjit20@";
        String url = ReadProperties.readOrPropertiesfile().getProperty("dbUrl");

        DBConnection db = new DBConnection();
        db.getConnection(url,username,passwrd);

    }
}
