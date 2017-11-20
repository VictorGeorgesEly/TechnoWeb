package jdbcDataBase;

public class DBColumnNumeric extends DBColumn{
	   protected int digits=0;
	   protected String auto_increment=null;
	   protected String colSize=null;

	   public DBColumnNumeric(final String colName, final SQLType colType,final String isNullable,final String colSize,final String auto_increment,String digits){
	      super(colName,colType,isNullable,colSize,auto_increment);
	      this.digits=Integer.parseInt(digits);
	      this.auto_increment=auto_increment;
	      this.colSize=colSize;
	   }
	   @Override
	   public String toSQL(){
	      final StringBuffer sb = new StringBuffer();
	      sb.append(String.format("%s %s (%s) %s %s", colName, sqlType,this.colSize,this.auto_increment,this.digits));

	      return sb.toString();
	   }
}
