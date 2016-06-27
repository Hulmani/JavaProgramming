//STEP 1. Import required packages
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MySqlBooksRetrieval {
	// JDBC driver name and database URL
	

	public static void main(String[] args)  {
		
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs=null;
		int i=0;
		String sql="";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//STEP 3: Open a connection
		System.out.println("Connecting to database...");

			conn = MySQLDatabaseConnect.getSqlConnection();

			System.out.println(conn.toString());
			//STEP 4: Execute a query
			try {
				stmt = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	

		


		try{
			
				
				//System.out.println("Creating statement...");

				
				
				 sql = "SELECT * from books";
				rs = stmt.executeQuery(sql);
//
				//STEP 5: Extract data from result set
				      while(rs.next()){
				      //   Retrieve by column name
				    	 i++;
				    	 if(i>26) break;
				         String id  = rs.getString("ISBN");
				         String age = rs.getString("Book_Title");
				         String first = rs.getString("Book_Author");
				         String last = rs.getString("Publication_Year");
				         String py = rs.getString("Publisher");
				       //  Display values
				         String s = rs.getString("Image_URL_S");
				         String m = rs.getString("Image_URL_m");
				         String l = rs.getString("Image_URL_l");
				         
				         
				         System.out.print("ID:" + id);
				         System.out.print(",Title: " + age);
				         System.out.print(",Author: " + first);
				         System.out.print(",Publication_Year: " + last);
				         System.out.print(",Publisher: " + py);
				         System.out.print(", Image_URL_S: " + s);
				         System.out.print(", Image_URL_m: " + m);
				         System.out.println(", Image_URL_l: " + l);
				        // System.out.println(", Last: " + last);
				      }

				

				// STEP 6: Clean-up environment

			}


			catch(SQLException se){
				//Handle errors for JDBC
				//System.out.println(i);
				
				se.printStackTrace();
			}
			catch(Exception e){
				// Handle errors for Class.forName
				e.printStackTrace();
			}
//			finally{
//				//finally block used to close resources
//				try{
//					if(stmt!=null)
//						stmt.close();
//				}catch(SQLException se2){
//				}// nothing we can do
//				try{
//					if(conn!=null)
//						conn.close();
//				}catch(SQLException se){
//					se.printStackTrace();
//				}//end finally try
//			}//end try
		
		
		
		
		
		try {
			//rs.close();
			System.out.println("closinng statement");
			stmt.close();
			conn.close();
			//System.exit(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		for(String m:errors)
//		{
//			System.out.println(m);
//		}
		System.out.println("Goodbye! "+i );
	}//end main
}//end FirstExample