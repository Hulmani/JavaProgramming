


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class min_students {


	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int testcases=Integer.parseInt(scan.next());
		int k=0;
		boolean flag=false;
		for(int i=0;i<testcases;i++)
		{
			int students=Integer.parseInt(scan.next());
			int min_students=Integer.parseInt(scan.next());
			k=0;
			//flag=false;
			for(int j=0;j<students;j++)
			{

				int came=Integer.parseInt(scan.next());
				if(came<=0) k++;   
			}	


			if(k>=min_students)
				System.out.println("No");			

			else
				System.out.println("Yes");



			/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		}
	}

}