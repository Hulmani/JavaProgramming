import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Jump2 {
	static boolean[] visited;


	static String jump(int[] a,int start ,int jump)
	{
		//visited[start]=true;
		if(start+jump >= a.length  ||  start+1 >= a.length )
		{
			//System.out.println("Position "+start +"\t End returned YES");
			return "YES";
		}



		if(a[start+1]==1 && a[start+jump]==1 )
		{
			if(start>0)
			{
			if(a[start-1]==1)
			{
			
			//System.out.println("0\t Position "+start +"\t all are 1 \t return no");
			return "No";
			}
			
			}
			else 
			{
				
					//System.out.println("0ther \t Position "+start +"\t all are 1 \t return no");
					return "No";
				
			}
		}

//		if(a[start-1]==1 && a[start+1]==1 && a[start+jump]==1)
//		{	//System.out.println("\t Position "+start +"\t all are 1 \t return no");
//		return "No";
//		}
		
		if(a[start+jump]==0 && !visited[start+jump])
		{
			//System.out.println("\t Position "+(start+jump) +"=0 visited");
			visited[start+jump]=true;
			return jump(a,start+jump,jump);

		}
		if( a[start+1]==0 && !visited[start+1])
		{
			//System.out.println("\t Position "+(start+1) +"=0 visited");
			visited[start+1]=true;
			return jump(a,start+1,jump);

		}
		if(start>0)
		{
		if(a[start-1]==0 && !visited[start-1])
		{
			//System.out.println("\t Position "+(start-1) +"=0 visited");
			visited[start-1]=true;
			return jump(a,start-1,jump);

		}
		}


		//System.out.println("Just returning");

		return 
				"No";

	}


	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int j=0;j<t;j++)
		{
			int n=scan.nextInt();
			visited=new boolean[n];  

			int m=scan.nextInt();
			int[] a =new int [n];

			for(int i=0;i<n;i++)
			{
				a[i]=scan.nextInt();
				visited[i]=false;
			}
			System.out.println(jump(a,0,m));
		}
	}
}