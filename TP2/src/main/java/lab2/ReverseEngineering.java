package lab2;

import org.apache.log4j.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GenerateScript {

    private static Logger log = Logger.getLogger(GenerateScript.class);

    static Connection connection = null;

    static DatabaseMetaData metadata = null;

    public static void main(String[] args) {

        connection = DbConnection.getInstance();

        try{

            log.info("Getting MetaData...");
            metadata = connection.getMetaData();

            ArrayList<String> tables = getTablesName();


            connection.close();
        } catch(SQLException se){
            log.error("SQLException : " + se);

        } catch(Exception e){
            log.error("Exception : " + e);

        }
    }

    private static ArrayList<String> getTablesName() throws SQLException {
        ResultSet rs = null;
        ArrayList<String> tables;

        rs = metadata.getTables(null, null, null, new String[] {"TABLE"});
        tables = new ArrayList<>();

        while(rs.next()) {
            tables.add(rs.getString("TABLE_NAME"));
        }

        log.debug("Nb Tables found : " + tables.size());
        rs.close();
        return tables;
    }

    private static ArrayList<String> getColumnsName(ArrayList<String> tables) throws SQLException {
        ResultSet rs = null;
        List<String[]> columns = new ArrayList<>();

        for(String currentTable : tables) {
            rs = metadata.getColumns(null, null, currentTable, null);

            while (rs.next()) {
                System.out.println(rs.getString("COLUMN_NAME") + " "

                        + rs.getString("TYPE_NAME") + " "

                        + rs.getString("COLUMN_SIZE"));
            }

        }


        log.debug("Nb Tables found : " + tables.size());
        rs.close();
        return tables;
    }
}
