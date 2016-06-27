import java.io.*;
import java.util.*;
import java.text.*;

import java.util.regex.*;

public class Sol {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		while(true){

			Scanner scan=new Scanner(System.in);
			String actual=scan.nextLine();
			String expected=scan.nextLine();
			String[] a_date=actual.split(" ");
			String [] e_date=expected.split(" ");

			int diff_y=Integer.parseInt(a_date[2])-Integer.parseInt(e_date[2]);
			int diff_m=Integer.parseInt(a_date[1])-Integer.parseInt(e_date[1]);
			int diff_d=Integer.parseInt(a_date[0])-Integer.parseInt(e_date[0]);

			//System.out.println(diff_d+" "+diff_m+ " "+diff_y);
			boolean flag=false;
			if(diff_y!=0)
			{
				if(diff_y>0)
				{
					System.out.println(10000*diff_y);
					flag=true;
				}
			}
			if (diff_m!=0 && !flag)
			{
				if(diff_m>0 && diff_y>=0){
					System.out.println(500*diff_m);
					flag=true;
				}
			}
			if(diff_d!=0 && !flag)
			{
				if(diff_d>0 && diff_m>=0 && diff_y>=0)
				{
					flag=true;
					System.out.println(15*diff_d);
				}
			}
			
				if( !flag )
				{
				
					System.out.println(0);
				}
		}
	}
}