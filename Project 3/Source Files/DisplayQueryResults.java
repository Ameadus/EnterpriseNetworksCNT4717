/*
 * Alexander Meade
 * Project Three: Two-Tier Client-Server Application Development With MySQL and JDBC
 *  Due 3/4/18
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Font;

	public class DisplayQueryResults extends JFrame 
	{
	   // default query retrieves all data from bikes table
	   static final String DEFAULT_QUERY = "SELECT * FROM riders";
	   
	   private ResultSetTableModel tableModel;
	   JTable resultTable = new JTable( tableModel );
	   private JTextArea queryArea;
	   private JPasswordField passwordField;
	   private JTextField textField;
	   JComboBox dbCombo;
	   JLabel connectionField;
	   JScrollPane displayQuery;
	   //private boolean conTest = ResultSetTableModel.checkConnection();
	   
	   // create ResultSetTableModel and GUI
	   public DisplayQueryResults() 
	   {   
	      super( "SQL Client GUI - (MUL - Spring 2018)");
	      setForeground(Color.LIGHT_GRAY);
	      setBackground(Color.LIGHT_GRAY);
	      getContentPane().setLayout(null);
	         	         
	         	         String[] drivers = {"com.mysql.jdbc.Driver" , "oracle.jdbc.driver.OracleDriver"
	         	         , "com.ibm.db2.jdbc.netDB2Driver" , "com.jdbc.odbc.jdbcOdbcDriver"};
	         	         
	         	         String[] URLS = {"jdbc:mysql://localhost:3306/project3" , "jdbc:mysql://localhost:3306/bikedb"};
	         	         

	         	          	         // set up JTextArea in which user types queries
	         	          			//	queryArea = new JTextArea( 3, 100);
	         	          	         queryArea = new JTextArea( "", 3, 100 );
	         	          	         queryArea.setBounds(373, 31, 383, 139);
	         	          	         getContentPane().add(queryArea);
	         	          	         queryArea.setWrapStyleWord( true );
	         	          	         queryArea.setLineWrap( true );
	         	          	         
	         	          	         // set up JButton for submitting queries
	         	          	         JButton executeSQL = new JButton( "Execute SQL Command" );
	         	          	         executeSQL.setBounds(605, 184, 169, 23);
	         	          	         getContentPane().add(executeSQL);
	         	          	         executeSQL.setBackground(Color.GREEN);
	         	          	         executeSQL.setForeground(Color.BLACK);
	         	          	         
	         	          	         JButton clearSQL = new JButton("Clear SQL Command ");
	         	          	         clearSQL.addActionListener(new ActionListener() {
	         	          	         	public void actionPerformed(ActionEvent arg0) {
	         	          	         	queryArea.setText(null);	
	         	          	         	}
	         	          	         });
	         	          	         clearSQL.setForeground(Color.RED);
	         	          	         clearSQL.setBackground(Color.WHITE);
	         	          	         clearSQL.setBounds(426, 184, 169, 23);
	         	          	         getContentPane().add(clearSQL);
	         	          	        
	         	          	         //connect button 
	         	          	         JButton connectDB = new JButton("Connect to Database");
	         	          	         connectDB.addActionListener(new ActionListener() {
	         	          	         	public void actionPerformed(ActionEvent arg0) {
	         	          	         		
	         	          	    
	         		         try {
								tableModel = new ResultSetTableModel( (String) dbCombo.getItemAt(dbCombo.getSelectedIndex()), textField.getText(), passwordField.getPassword() );
								connectionField.setText((String) dbCombo.getItemAt(dbCombo.getSelectedIndex()));
							} catch ( ClassNotFoundException classNotFound ) 
	         			      {
						         JOptionPane.showMessageDialog( null, 
						            "MySQL driver not found", "Driver not found",
						            JOptionPane.ERROR_MESSAGE );
						         
						         System.exit( 1 ); // terminate application
						      } // end catch
						      catch ( SQLException sqlException ) 
						      {
						         JOptionPane.showMessageDialog( null, sqlException.getMessage(), 
						            "Database error", JOptionPane.ERROR_MESSAGE );
						               
						         // ensure database connection is closed
						         tableModel.disconnectFromDatabase();
						         
						         System.exit( 1 );   // terminate application
						      } // end catch	         	          	         	
	         	          	         	}
	         	          	});
	         	          	      
	         	          	         connectDB.setForeground(Color.YELLOW);
	         	          	         connectDB.setBackground(Color.BLUE);
	         	          	         connectDB.setBounds(238, 184, 178, 23);
	         	          	         getContentPane().add(connectDB);
	         	          	         
	         	          	         JButton clearResults = new JButton("Clear Result Windows");
	         	          	         clearResults.addActionListener(new ActionListener() {
	         	          	         	public void actionPerformed(ActionEvent arg0) {
	         	          	         	remove(displayQuery);
	         	          	         	displayQuery = new JScrollPane();
	         	          	         	displayQuery.setBounds(17, 214, 713, 307);
	         	          	         	add(displayQuery);
	         	          	         	displayQuery.repaint();
	         	          	         	tableModel.fireTableStructureChanged();
	         	          	         	}
	         	          	         });
	         	          	         clearResults.setForeground(Color.BLACK);
	         	          	         clearResults.setBackground(Color.YELLOW);
	         	          	         clearResults.setBounds(551, 527, 205, 23);
	         	          	         getContentPane().add(clearResults);
	         	          	         
	         	          	         //combo boxes 
	         	          	         JComboBox driverCombo = new JComboBox(drivers);
	         	          	         driverCombo.setBounds(99, 30, 220, 22);
	         	          	         getContentPane().add(driverCombo);
	         	          	         dbCombo = new JComboBox(URLS);
	         	          	         dbCombo.setBounds(98, 62, 221, 22);
	         	          	         getContentPane().add(dbCombo);
	         	          	         
	         	          	         JLabel lblEnterDatabaseInformation = new JLabel("Enter Database Information");
	         	          	         lblEnterDatabaseInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
	         	          	         lblEnterDatabaseInformation.setForeground(Color.BLUE);
	         	          	         lblEnterDatabaseInformation.setBounds(16, 9, 221, 14);
	         	          	         getContentPane().add(lblEnterDatabaseInformation);
	         	          	         
	         	          	         JLabel lblEnterAnSql = new JLabel("Enter An SQL Command ");
	         	          	         lblEnterAnSql.setFont(new Font("Tahoma", Font.BOLD, 14));
	         	          	         lblEnterAnSql.setForeground(Color.BLUE);
	         	          	         lblEnterAnSql.setBounds(372, 7, 257, 14);
	         	          	         getContentPane().add(lblEnterAnSql);
	         	          	         
	         	          	         JLabel lblJdbcDriver = new JLabel("JDBC Driver");
	         	          	         lblJdbcDriver.setFont(new Font("Tahoma", Font.BOLD, 11));
	         	          	         lblJdbcDriver.setBounds(10, 37, 71, 14);
	         	          	         getContentPane().add(lblJdbcDriver);
	         	          	         
	         	          	         JLabel lblDatabaseUrl = new JLabel("Database URL");
	         	          	         lblDatabaseUrl.setFont(new Font("Tahoma", Font.BOLD, 11));
	         	          	         lblDatabaseUrl.setBounds(11, 66, 85, 14);
	         	          	         getContentPane().add(lblDatabaseUrl);
	         	          	         
	         	          	         JLabel lblUsername = new JLabel("Username");
	         	          	         lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
	         	          	         lblUsername.setBounds(13, 99, 71, 14);
	         	          	         getContentPane().add(lblUsername);
	         	          	         
	         	          	         JLabel lblPassword = new JLabel("Password");
	         	          	         lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
	         	          	         lblPassword.setBackground(Color.LIGHT_GRAY);
	         	          	         lblPassword.setBounds(13, 126, 66, 24);
	         	          	         getContentPane().add(lblPassword);
	         	          	         
	         	          	         passwordField = new JPasswordField();
	         	          	         passwordField.setBounds(98, 132, 221, 23);
	         	          	         getContentPane().add(passwordField);
	         	          	         
	         	          	         connectionField = new JLabel("No Connection");
	         	          	         JPanel idc = new JPanel();
	         	          	         idc.setBackground(Color.BLACK);
	         	          	         idc.add(connectionField);
	         	          	         connectionField.setForeground(Color.RED);
	         	          	         idc.setBounds(10, 184, 218, 23);
	         	          	         getContentPane().add(idc);
	         	          	         
	         	          	         
	         	          	         textField = new JTextField();
	         	          	         textField.setBounds(99, 96, 220, 20);
	         	          	         getContentPane().add(textField);
	         	          	         textField.setColumns(10);
	         	         
	        
	     

	         // create event listener for submitButton
	         executeSQL.addActionListener( 
	         
	            new ActionListener() 
	            {
	               // pass query to table model
	               public void actionPerformed( ActionEvent event )
	               {
	            	if (queryArea.getText().contains("select") || queryArea.getText().contains("Select") || queryArea.getText().contains("SELECT") ) {
	            	// perform a new query
		                  try 
		                  {
		                     tableModel.setQuery( queryArea.getText() );
		                  // create JTable delegate for tableModel 
	         		         JTable resultTable = new JTable( tableModel );
	         		         getContentPane().setLayout(null);
	         		         displayQuery = new JScrollPane(resultTable);
	         		         displayQuery.setBounds(17, 214, 713, 307);
	         		         getContentPane().add( displayQuery );
		                  } // end try
		                  catch ( SQLException sqlException ) 
		                  {
		                     JOptionPane.showMessageDialog( null, 
		                        sqlException.getMessage(), "Database error", 
		                        JOptionPane.ERROR_MESSAGE );
		                     
		                     // try to recover from invalid user query 
		                     // by executing default query
		                     try 
		                     {
		                        tableModel.setQuery( DEFAULT_QUERY );
		                        queryArea.setText( DEFAULT_QUERY );
		                     } // end try
		                     catch ( SQLException sqlException2 ) 
		                     {
		                        JOptionPane.showMessageDialog( null, 
		                           sqlException2.getMessage(), "Database error", 
		                           JOptionPane.ERROR_MESSAGE );
		                     }
		                  }
	            	}     
	            		else {        
		                        // ensure database connection is closed
		                        //tableModel.disconnectFromDatabase();
		                        try {
		  	            		  tableModel.setUpdate(queryArea.getText());
		  	            	  }
	                  
	  	            	  catch( SQLException sqlException3) {
	  	            		  JOptionPane.showMessageDialog( null, 
	  	  	                        sqlException3.getMessage(), "Database error", 
	  	  	                        JOptionPane.ERROR_MESSAGE );
	  	            	  }
	            	}
	                        //System.exit( 1 ); // terminate application
	                     } // end inner catch                   
	            }  // end ActionListener inner class          
	         ); // end call to addActionListener

	         setSize( 800, 600 ); // set window size
	         setVisible( true ); // display window  
	      
	      
	   
	      
	      // dispose of window when user quits application (this overrides
	      // the default of HIDE_ON_CLOSE)
	      setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	      
	      // ensure database connection is closed when user quits application
	      addWindowListener(
	      
	         new WindowAdapter() 
	         {
	            // disconnect from database and exit when window has closed
	            public void windowClosed( WindowEvent event )
	            {
	               tableModel.disconnectFromDatabase();
	               System.exit( 0 );
	            } // end method windowClosed
	         } // end WindowAdapter inner class
	      ); // end call to addWindowListener
	   } // end DisplayQueryResults constructor
	   
	   // execute application
	   public static void main( String args[] ) 
	   {
	      new DisplayQueryResults();     
	   } // end main
	} // end class DisplayQueryResults
