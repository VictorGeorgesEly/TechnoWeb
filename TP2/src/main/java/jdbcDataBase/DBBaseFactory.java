package jdbcDataBase;

public class DBBaseFactory {
	 private DBBaseFactory()
	    {
	    }
	    //Notes: the method below is not a constructor, it is merely a instance method;
	    public static DBBase DBBaseFactory(final String dbName)
	    {
	        return new DBBase(dbName);
	    }
}
