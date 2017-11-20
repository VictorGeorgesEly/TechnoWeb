package jdbcDataBase;
import java.util.LinkedList;
import java.util.List;

public class DBTable {
	public List<DBColumn> columns = new LinkedList<DBColumn>();
    public String tableName=null;

    public DBTable(final String tableName)
   {
        this.tableName = tableName;
   }
    
   //init column
    public void initColumn(){
    	
    }
    
    public String toSQL()
    {
    	final StringBuffer sb = new StringBuffer();
    	
        sb.append("CREATE TABLE "+this.tableName +"( ");
        for (DBColumn column : columns)
        {
            sb.append(column.toSQL());
        }
        
        sb.append(");");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }
}
