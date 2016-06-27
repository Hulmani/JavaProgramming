//STEP 1. Import required packages
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MySqlBookUsersInsert {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/BookStore";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) throws FileNotFoundException {
		
		
		ArrayList<String> errors=new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs=null;
		int i=0;
		String line="",p="";
		Scanner scan=new Scanner(new File("/Users/manojhulmani/Dropbox/BookS/BX-Users.csv"),"iso-8859-1");
		scan.nextLine();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//STEP 3: Open a connection
		System.out.println("Connecting to database...");
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			System.out.println(conn.toString());
			//STEP 4: Execute a query
			System.out.println("Creating statement...");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(0);
		}
		String sql;


		while(scan.hasNextLine())
		{
			try{
				//STEP 2: Register JDBC driver
				stmt = conn.createStatement();	
				 line =scan.nextLine();
					i++;
				//	if(i>125) break;
				String  l="\"";
				 p=line.replace(l, "");

				String []o=p.split(";");

			if (o[2].equals("NULL")) o[2]=null;

				 sql="INSERT INTO book_user values (\""+o[0]+"\",\""+o[1]+"\","+o[2]+")";
				System.out.println(sql);
				
				System.out.println("Result:"+ stmt.execute(sql));
				


			}


			catch(SQLException se){
				//Handle errors for JDBC
				System.out.println(i);
				errors.add(p);
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
			//}//end try
		}
		
		
		
		
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
		
		for(String m:errors)
		{
			System.out.println(m);
		}
		System.out.println("Goodbye! "+i +"errors "+errors.size());
	}//end main
}//end FirstExample