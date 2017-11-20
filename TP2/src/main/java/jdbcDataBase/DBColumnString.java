package jdbcDataBase;

public class DBColumnString extends DBColumn {
	protected  String size;

	  protected DBColumnString(final String name, final SQLType SQLType,final String isNullableBool,final String size,String increment)
	    {
	       super(name,SQLType,isNullableBool,size,increment);
	       this.size = size ;
	    }

	  @Override
	    public String toSQL()
	    {
	        final StringBuffer sb = new StringBuffer();
	        sb.append(String.format("%s %s (%s)",colName, sqlType, this.size));
	         //try one example: format (first_name,varchar,2000k)
	        return sb.toString();//then when we call this method, we get the result:actor.first_name string 2000
	    }
}
