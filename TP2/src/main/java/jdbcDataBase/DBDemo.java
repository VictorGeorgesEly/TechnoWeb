package jdbcDataBase;
import java.nio.file.*;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBDemo {

	static String url="jdbc:mysql://localhost:8889/sakila";
	static String username="root";
	static String userpassword="root";
	static StringBuffer sb=new StringBuffer();
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	//database metadata info
	static Connection connection = null;
	static DatabaseMetaData metadata = null;
	
	//iniatilized tables;
	static ResultSet rs=null;
	static Set<String> tableNames=new HashSet<String>();
	
	public DBDemo(String url,String username,String userpassword){
		this.url=url;
		this.username=username;
		this.userpassword=userpassword;
	}
	
	static DatabaseMetaData getConnected() throws ClassNotFoundException{
			Class.forName(DRIVER);
			
		 try {
	            connection = DriverManager.getConnection(url,username,userpassword);
	           } catch (SQLException e) {
	            System.err.println("There was an error getting the connection: "
	                    + e.getMessage());
	           }
	     try {
	            metadata = connection.getMetaData();
				
	         } catch (SQLException e) {
	            System.err.println("There was an error getting the metadata: "
	                    + e.getMessage());
	         }
			
			return metadata;
	    }
	
	static Connection getConnection(){
		 try {
	            connection = DriverManager.getConnection(url,username,userpassword);
	           } catch (SQLException e) {
	            System.err.println("There was an error getting the connection: "
	                    + e.getMessage());
	           }
		 return connection;
	}
	 
	 
	public static void main(String[]args) throws SQLException, ClassNotFoundException{
    //database
		DBBase dataBase=DBBaseFactory.DBBaseFactory("sakila");
       
	//table:get the table names;
		rs=getConnected().getTables(null,null,"%",null);
		while(rs.next()){
			//get table name
			DBTable dbTable=DBTableFactory.DBTableFactory(rs.getString("TABLE_NAME"));
			dataBase.tables.add(dbTable);
			tableNames.add(rs.getString("TABLE_NAME"));
			//System.out.println("check this out"+rs.getString("TABLE_NAME"));
		}
		
		for(DBTable table:dataBase.tables){
		    ResultSet resultSet = getConnected().getColumns(null, null,table.tableName, null);
		    /*
		    System.out.println("table:"+table.tableName);
		    while (resultSet.next()) {
			      String name = resultSet.getString("COLUMN_NAME");
			      String type = resultSet.getString("TYPE_NAME");
			      int size = resultSet.getInt("COLUMN_SIZE");
			      System.out.println("Column name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
			    }
			*/
		    
		    while(resultSet.next()){
		    	DBColumn dbColumn=DBColumnFactory.DBColumnFactory(resultSet);
				table.columns.add(dbColumn);
		    }
		    
		}
		
		//output to sql script;
		sb.append("---UserName:"+metadata.getUserName());
		sb.append(System.getProperty("line.separator"));  
		sb.append("---ProductName:"+metadata.getDatabaseProductName());
		sb.append(System.getProperty("line.separator")); 
		String s=dataBase.toSQL();
		sb.append(s);
		System.out.println(sb.toString());

	    //writing sql to the file;
		Writer writer = null;
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("src/jdbcDataBase/SQLScriptFile.sql"), "utf-8"));
		    writer.write(sb.toString());
		} catch (IOException ex) {
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
   }
}
