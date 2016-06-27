import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solutio {

	public static void main(String[] args) {


		Scanner scan=new Scanner(System.in);
		String time=scan.nextLine();

		System.out.println(time.matches("(.*)AM"));
		int hh,mm,ss;
		String[] retval= time.split(":");
		String s=retval[2].charAt(0)+""+retval[2].charAt(1);
		String h="",m="";
		hh=Integer.parseInt(retval[0]);
		mm=Integer.parseInt(retval[1]);
		ss=Integer.parseInt(s);
		String output="";
		if(time.matches("(.*)AM"))
		{
			
			
			System.out.println(hh+" "+mm+ " "+ss);
			
			if(hh==12)
			{
				
				hh=0;
			}
			
			/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		}
		
		else
		{
			
			System.out.println(hh+" "+mm+ " "+ss);
			
			if(hh<12)
			{
				
				hh+=12;
			}
					
		}
		
		
		if(hh<10)
			h="0"+hh+"";
			else
				h=hh+"";
		
		output=h+":"+retval[1]+":"+s;

		System.out.println(output);	
	}
}