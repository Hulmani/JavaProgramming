import java.util.Scanner;


public class BitwiseAnd {

	
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		
   int n=scan.nextInt();
   int q=scan.nextInt();
   int[] numbers=new int[n];
		for(int i=0;i<n;i++)
			numbers[i]=scan.nextInt();
		
		//scan(numbers);
		int l=numbers.length;
		int[][]seg=new int [l][l];
		for(int k=0;k<l;k++)
				seg[k][k]=numbers[k];
		buildAnd(seg,numbers);
		//print(seg);
		
		//System.out.println("Enter queries");
		for(int i=0;i<q;i++)
		{
			int left=scan.nextInt();
			int right=scan.nextInt();
			int x=scan.nextInt();
			//System.out.println("count");
			System.out.println(count(seg,left,right,x));
		}
		
	}

	

	private static int count(int[][] seg, int left, int right, int x) {
		
		int c=0;
		for(int i=left-1;i<right;i++)
			for(int j=i;j<right;j++)
			{
				//System.out.println(seg[i][j]);
				if(seg[i][j]<=x )
					c++;
			}
		return c;
					
	}




	private static void print(int[][] seg) {
		// TODO Auto-generated method stub
		int l=seg.length;
		for(int k=0;k<l;k++)
		{
			for(int j=0;j<l;j++)
				System.out.print(seg[k][j]+" ");
			System.out.println();
		}
	}

	private static void buildAnd(int[][] seg, int[] numbers) {
		// TODO Auto-generated method stub
		int i=0;
		int l=numbers.length;
		for(int k=0;k<l;k++)
		{
			i=0;
			for(int j=k+1;j<l;j++,i++)
			{
				seg[i][j]=seg[i][j-1] & seg[i+1][j];
				
			}
		}
		
	}
	
}

