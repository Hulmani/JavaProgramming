import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        String[] a=str.split(":");
        int hh=Integer.parseInt(a[0]);
        int mm=Integer.parseInt(a[1]);
        String s=""+a[2].charAt(0) + a[2].charAt(1);
        int ss=Integer.parseInt(s);
        String time;
       // time=hh+":"+mm+":"+ss;
        //for(String b:a){
        	System.out.println(a[2]);
        	if(a[2].charAt(2)=='P')
        	{
        		//System.out.println("PM");
        		
        		if(hh<12)
        		{
        			hh+=12;
        		}
        		if(hh==12)
        		{
        			hh=0;
        		}
        	
        			//System.out.println(hh+":"+mm+":"+ss);
        	}
        	if(hh<9) 
        		System.out.println("0"+hh+":"+mm+":"+ss);
        		
        	if(ss<9) 
        		System.out.println(hh+":0"+mm+":"+ss);
        	
        	if(mm<9) 
        		System.out.println(hh+":"+mm+":"+ss);
        		
        	if(ss<9) 
        		System.out.println(hh+":"+mm+":0"+ss);
        		
        		
        }
    }
