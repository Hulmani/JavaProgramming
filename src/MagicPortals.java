import java.util.LinkedList;
import java.util.Scanner;


public class MagicPortals {

	public static int minSteps(int[][] M,int n,int a1,int b1,int a2,int b2)
	{
		int ia1=a1;

		LinkedList<Integer> A =new LinkedList<Integer>();
		LinkedList<Integer> B =new LinkedList<Integer>();
		boolean aReached=false;
		boolean bReached=false;

		for(int i=1;i<=n;i++)
		{

			if(M[a1][i]==1)   // Add the traversal paths from a1 
			{
				A.addLast(i);
			}
			if(M[b1][i]==1)  // Add the traversal paths from b1 
			{
				B.addLast(i);
			}
		}
		
		
		for(int s:A)
		{
			if(!aReached)
			{
				System.out.println("Moved a1 from "+a1 +" to"+s);
				a1=s;
				count++;
				if(a1==a2) aReached=true;
			}

			for(int d:B)
			{
				if(d!=ia1)   // ia1 - same portal  i.e cannot travel simultaneously
				{
					if(!bReached)
					{
						System.out.println("Moved b1 from "+b1 +" to"+d);
						b1=d;
						count++;

						if(b1==b2) bReached=true;
				}
					
					if(aReached==true && bReached==true)
						return count;
					
					minSteps(M,n,a1, b1,a2,b2);
					
				}

			}
		}

		return count;
	}
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		//		int n=scan.nextInt();
		//		int m=scan.nextInt();
		//		int a1=scan.nextInt();
		//		int b1=scan.nextInt();
		//		int a2=scan.nextInt();
		//		int b2=scan.nextInt();
		int n=4;
		int m=5;
		int a1=1;
		int b1=2;
		int a2=2;
		int b2=1;
		//int M[][]=new int[n+1][n+1];
		//		for(int i=0;i<m;i++)
		//		{
		//			int s=scan.nextInt();
		//			int d=scan.nextInt();
		//			M[s][d]=1;
		//			//M[d][s]=1;
		//
		//		}
		int[][] M={
				{ 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 1},
				{0 ,0, 0, 1, 0},
				{0 ,0, 0, 0, 1}, 
				{0, 0, 0, 0, 1}};

		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				System.out.print(M[i][j]+ " ");

			}

			System.out.println();
		}

	}
}
