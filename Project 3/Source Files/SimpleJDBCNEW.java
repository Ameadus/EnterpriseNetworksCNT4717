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
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;



public class SimpleJDBCNEW {
  public static void main(String[] args)
    throws SQLException, ClassNotFoundException {
	  
	//using a properties file  
    Properties properties = new Properties();
    FileInputStream filein = null;
    MysqlDataSource dataSource = null;
    //read properties file
    try {
    	filein = new FileInputStream("db.properties");
    	properties.load(filein);
    	dataSource = new MysqlDataSource();
    	dataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
    	dataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
    	dataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));	 	
    } catch (IOException e) {
    	e.printStackTrace();
    }
	
    //establish a connection to the dataSource - the database
	Connection connection = dataSource.getConnection();
    System.out.println("Database connected");
	 
	 DatabaseMetaData dbMetaData = connection.getMetaData();
	 System.out.println("JDBC Driver name " + dbMetaData.getDriverName() );
	 System.out.println("JDBC Driver version " + dbMetaData.getDriverVersion());
	 System.out.println("Driver Major version " +dbMetaData.getDriverMajorVersion());
	 System.out.println("Driver Minor version " +dbMetaData.getDriverMinorVersion() );

    // Create a statement
	Statement statement = connection.createStatement();
	
    // Execute a statement
    ResultSet resultSet = statement.executeQuery ("select bikename,cost,mileage from bikes");

    // Iterate through the result set and print the returned results
    while (resultSet.next())
      System.out.println(resultSet.getString("bikename") + "         \t" +
        resultSet.getString("cost") + "         \t" + resultSet.getString("mileage"));
		//the following print statement works exactly the same  
      //System.out.println(resultSet.getString(1) + "         \t" +
      //  resultSet.getString(2) + "         \t" + resultSet.getString(3));

    // Close the connection
    connection.close();
  }
}
