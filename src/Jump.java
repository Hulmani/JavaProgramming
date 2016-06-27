import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Jump {

    static String jump(int[] a,int start ,int jump)
        {
    if(start+jump >= a.length  ||  start+1 >= a.length )
        {
    	System.out.println("Position "+start +"\t End returned YES");
        return "YES";
    }
        
    else if(start==0 && a[start+1]==1 && a[start+jump]==1)
    {
    	System.out.println("0\t Position "+start +"\t all are 1 \t return no");
    	return "NO";
    }
    
    else  if(a[start-1]==1 && a[start+1]==1 && a[start+jump]==1)
    {
    	System.out.println("\t Position "+start +"\t all are 1 \t return no");
    	return "NO";
    } 
    
    else  if(a[start+jump]==0)
    {
    	System.out.println("\t Position "+(start+jump) +"=0 visited");
     	    return jump(a,start+jump,jump);
    }   
    
    else if(a[start+1]==0)
    {
    	System.out.println("\t Position "+(start+1) +"=0 visited");
        return jump(a,start+1,jump);
    }

    else if(start-1>0 && a[start-1]==0)
    {
    System.out.println("\t Position "+(start-1) +"=0 visited");
    return jump(a,start-1,jump);
    
    }
        
    else   {System.out.println("\tNo"); return "NO";
    }
        }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int j=0;j<t;j++)
        {
        int n=scan.nextInt();
        int m=scan.nextInt();
        int[] a =new int [n];
        for(int i=0;i<n;i++)
            {
            a[i]=scan.nextInt();
            
        }
        System.out.println(jump(a,0,m));
        }
    }
}