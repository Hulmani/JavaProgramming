

import java.sql.*;


public class MySQLDatabaseConnect {

		// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		static final String DB_URL = "jdbc:mysql://localhost/BookStore";

		//  Database credentials
		static final String USER = "root";
		static final String PASS = "";


		 java.sql.Connection conn = null;
		// Statement stmt = null;

		public static  java.sql.Connection getSqlConnection(){
			java.sql.Connection conn = null;
			try{
				 
					
				//STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				//STEP 3: Open a connection
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
			}
			catch(Exception ex)
			{
				System.out.println("Error:"+ex);
				System.out.println("-------------------");
			}
			
			return conn;
		}

	
	}
