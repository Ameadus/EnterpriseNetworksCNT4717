/*
 * Alexander Meade
 * Project Three: Two-Tier Client-Server Application Development With MySQL and JDBC
 *  Due 3/4/18
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DisplayBikes 
{
   // launch the application
   public static void main( String args[] ){
	 //using a properties file  
	    Properties properties = new Properties();
	    FileInputStream filein = null;
	    MysqlDataSource dataSource = null;
	    //read properties file
	    DisplayQueryResults.main(args);     
                      
   } // end main
}  // end class DisplayBikes
