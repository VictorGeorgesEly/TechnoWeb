package jdbcDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcDataBase.DBColumn.SQLType;

public class DBColumnFactory {
	
    public static DBColumn DBColumnFactory(ResultSet columnRS) throws SQLException
    {
        String columnName = columnRS.getString("COLUMN_NAME");
        
        String datatype = columnRS.getString("DATA_TYPE");
        String typeName = columnRS.getString("TYPE_NAME");
        String columnSize = columnRS.getString("COLUMN_SIZE");
    
        String decimalDigits = columnRS.getString("DECIMAL_DIGITS");
        
        String isNullable = columnRS.getString("IS_NULLABLE");
        String isNullableBool = (isNullable == "YES") ? "NULL" : "NOT NULL";
        
        String isAutoIncrement = columnRS.getString("IS_AUTOINCREMENT");
        String isAutoIncrementBool = (isAutoIncrement == "YES") ? " AUTO_INCREMENT" : "";
        
        if(typeName.trim().toUpperCase().contains("SMALLINT UNSIGNED")){
        	typeName="SMALLINT";
        	DBColumn.SQLType colType = DBColumn.SQLType.valueOf(typeName);
        	return DBColumnFactory (columnName,colType,isNullableBool,columnSize,isAutoIncrementBool,decimalDigits);
        }else if(typeName.trim().toUpperCase().contains("MEDIUMINT UNSIGNED")){
        	typeName="MEDIUM";
        	DBColumn.SQLType colType = DBColumn.SQLType.valueOf(typeName);
        	return DBColumnFactory (columnName,colType,isNullableBool,columnSize,isAutoIncrementBool,decimalDigits);
        }else if(typeName.trim().toUpperCase().contains("TINYINT UNSIGNED")){
        	typeName="TINYINT";
        	DBColumn.SQLType colType = DBColumn.SQLType.valueOf(typeName);
        	return DBColumnFactory (columnName,colType,isNullableBool,columnSize,isAutoIncrementBool,decimalDigits);
        }else{
            DBColumn.SQLType colType = DBColumn.SQLType.valueOf(typeName);
            return DBColumnFactory (columnName,colType,isNullableBool,columnSize,isAutoIncrementBool,decimalDigits);
        }
    }
    
    public static DBColumn DBColumnFactory(String colName, DBColumn.SQLType colType, String isNullableBool,String colSize,String isAutoIncrementBool,String digits)
  	//public DBColumnNumeric(final String colName, final SQLType colType,final boolean isNullable,final int colSize, final int precision, final int radix){
      {
          switch (colType)
          {
          //SQL data type
	          case DECIMAL:
	          case NUMERIC:
	        	return new DBColumnNumeric(colName, colType, isNullableBool, colSize,isAutoIncrementBool, digits);

              case INT:
            	return new DBColumnString(colName, colType,isNullableBool,colSize,isAutoIncrementBool);  
            	 
              case BIT:
            	  
             //string data type
              case VARCHAR:
              case CHAR:
              case BLOB:
              case TEXT:
              case ENUM:
              case SET:
            	  
              //number data type
              case DOUBLE:
              case INTEGER:
              case MEDIUMINT:
              case TINYINT:
              case SMALLINT:
              case FLOAT:
              case REAL:
              case MEDIUM:
              case DATE:
              case DATETIME:
              case YEAR:
              case TIMESTAMP:
            	  
              default:
                  return new DBColumn(colName, colType, isNullableBool,colSize,isAutoIncrementBool);
                  
          }
      }
  }
