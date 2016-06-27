import java.util.Scanner;


public class BronzeGoldPlatinum {
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		int[][]m={{2,3},  //bronze
				  {3,5}, //silver		
				  {4,6},  //gold
				  {1,2}}; //platinum
		int[] h= new int[4];
		System.out.println(m.length);
		int cur_diff=0,prev_diff=0;
		
		for(int i=m.length-1;i>=0;i--)
		{
		
			cur_diff= m[i][1]-m[i][0]+prev_diff;
				h[i]=cur_diff;
			prev_diff=cur_diff;
			
		}
		System.out.println("Bronze to Silver "+h[1] );
		System.out.println("Silver  to Gold "+h[2] );
		System.out.println("Gold to Platinum " + h[3]);
	}
}
