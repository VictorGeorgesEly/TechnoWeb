package jdbcDataBase;

public class DBColumn {
	 	public String colName;
	    public SQLType sqlType;
	    public String isNullable;
	    public String size;
	    public String increment;
	    

	    //class constructor
	    protected DBColumn(final String colName, final SQLType sqlType, final String isNullableBool,String size,String increment)
	    {
	        this.colName = colName;
	        this.sqlType = sqlType;
	        this.isNullable = isNullableBool;
	        this.size=size;
	        this.increment=increment;
	        
	    }
	    public enum SQLType {
	     
	      BLOB,
	      TEXT,
	      
	      CHAR,
	      VARCHAR,
	      
	      NUMERIC,
	      INTEGER,
	      DECIMAL,
	      MEDIUMINT,
	      TINYINT,
	      SMALLINT,
	      BIT,
	      FLOAT,
	      DOUBLE,
	      REAL,
	      INT,   
	      DATE,
	      DATETIME,
	      YEAR,
	      TIMESTAMP,
	      SET,
	      MEDIUM,
	      ENUM;
	    }

	    public String toSQL()
	    {
	        final StringBuffer sb = new StringBuffer();
	        sb.append(this.colName +" "+sqlType+" "+"("+size+")"+isNullable);
	        sb.append(System.getProperty("line.separator"));
	        return sb.toString();
	    }
}
