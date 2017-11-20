package jdbcDataBase;

public class DBTableFactory {
	public static DBTable DBTableFactory(final String tableName){
	      return new DBTable(tableName);
	   }
}
