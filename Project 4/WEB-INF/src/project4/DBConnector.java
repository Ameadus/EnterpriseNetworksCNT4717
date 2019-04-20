/* Alexander Meade
CNT 4714 Spring 2018 
A Three-Tier Distributed Web-Based Application
*/

package project4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnector
{
  private Connection connection = null;
  
  public boolean isConnected()
  {
    if (this.connection == null) {
      return false;
    }
    try
    {
      return !this.connection.isClosed();
    }
    catch (SQLException ex) {}
    return false;
  }
  
  public void connect(String driver, String url, String user, String password)
    throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
  {
    //Class.forName(driver).newInstance();
    this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project4", "root", "root");
  }
  
  public ResultSet executeQuery(String command)
    throws SQLException
  {
    Statement statement = this.connection.createStatement(1004, 1007);
    return statement.executeQuery(command);
  }
  
  public int executeUpdate(String command)
    throws SQLException
  {
    Statement statement = this.connection.createStatement();
    int result = statement.executeUpdate(command);
    statement.close();
    
    return result;
  }
  
  public void disconnect()
  {
    if (this.connection != null) {
      try
      {
        this.connection.close();
      }
      catch (SQLException ex)
      {
        Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, "Failed to close connection", ex);
      }
    }
  }
}
