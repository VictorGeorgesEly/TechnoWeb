package lab2;

import org.apache.log4j.*;
import java.sql.*;

/** 
 * JDBC Request
 */
public class SimpleQuery {

	private static Logger log = Logger.getLogger(SimpleQuery.class);

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/sakila";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		Connection conn = null;
	   	Statement stmt = null;

	   	try{

	   		Class.forName(JDBC_DRIVER);

	    	log.info("Connecting to database : " + DB_URL + " as : " + USER);
	      	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      	log.info("Connection : SUCCESS !");

	      	log.info("Creating statement...");

	      	stmt = conn.createStatement();
	      	String sql = "SELECT last_name FROM actor";

	      	log.debug("Executing statement: " + sql);
	      	ResultSet rs = stmt.executeQuery(sql);

	      	while(rs.next()){

	         	String last = rs.getString("last_name");
	         	System.out.println("Last name: " + last);
	      	}
	      
	      	log.info("End of the request...");

	      	rs.close();
	      	stmt.close();
	      	conn.close();
	   	} catch(SQLException se){
	   		log.error("SQLException : " + se);

	   	} catch(Exception e){
	   		log.error("Exception : " + e);

		}
	}
}
