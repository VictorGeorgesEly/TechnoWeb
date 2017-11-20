package jdbcDataBase;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;


public class DBBase
{
    public List<DBTable> tables = new LinkedList();
    public String dbName = null;
    public ResultSet rs=null;

    
	protected DBBase(final String dbName)
    {
        this.dbName = dbName;
    }
	
	//init Tables
	public void initTables(){

	}
	
    public String toSQL()
    {
        final StringBuffer sb = new StringBuffer();
        sb.append("CREATE DATABASE " + this.dbName);
        sb.append(System.getProperty("line.separator"));
        for (DBTable table : tables)
        {
            sb.append(table.toSQL());
            //table belongs to the instances of DBTables thus, table.toSQL(), calls the BDTable instances' method;
        }
        return sb.toString();
    }

}
