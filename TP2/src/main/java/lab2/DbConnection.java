package lab2;

import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    private static Logger log = Logger.getLogger(DbConnection.class);
    private static Properties p = new Properties();

    private static Connection connection = null;

    private DbConnection() {}

    static Connection getInstance() {
        try {
            p.load(DbConnection.class.getResourceAsStream("/app.properties"));
        } catch (FileNotFoundException fnfe) {
            log.error(fnfe);
        } catch (IOException ioe) {
            log.error(ioe);
        }
        return getInstance(p.getProperty("lab2.db.url"), p.getProperty("lab2.jdbc.driver"), p.getProperty("lab2.db.username"), p.getProperty("lab2.db.password"));
    }

    private static Connection getInstance(String url, String driver, String user, String pass) {

        connection = null;

        try{
            Class.forName(driver);
            String password = pass.equals(" ") ? "" : pass;

            log.info("Connecting to database : " + url + " as : " + user);
            connection = DriverManager.getConnection(url,user,password);
            log.info("Connection : SUCCESS !");

        } catch(SQLException se) {
            log.error("SQLException : " + se);

        } catch(ClassNotFoundException cnfe) {
            log.error("ClassNotFoundException : " + cnfe);

        } catch(Exception e) {
            log.error("Exception : " + e);
        }

        return connection;
    }
}
