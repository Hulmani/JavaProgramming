import java.util.Scanner;


public class RedGreenBlue {


	public static void compute(int n)
	{

		int max_red=n/2;
		int max_green=n/3;
		int max_blue=n/4;
		int j=0;
		int total_ways=0,t=0;
		for(int i=max_red;i>0;i--)
		{
			j=n-(i*2);
			t=i+j;
			System.out.println("i= "+i+"j= "+j+" Total="+t);
			if(j==0) total_ways++;
			else
				total_ways+=i+j;
		}
		System.out.println("---------------------------");
		total_ways=(int) (total_ways%(Math.pow(10, 9)+7));
		for(int i=max_green;i>0;i--)
		{
			j=n-(i*3);
			t=i+j;
			System.out.println("i= "+i+"j= "+j+" Total="+t);
			if(j==0) total_ways++;
			else
				total_ways+=i+j;
		}
		System.out.println("---------------------------");
		total_ways=(int) (total_ways%(Math.pow(10, 9)+7));
		for(int i=max_blue;i>0;i--)
		{
			j=n-(i*4);
			t=i+j;
			System.out.println("i= "+i+"j= "+j+" Total="+t);
			if(j==0) total_ways++;
			else
				total_ways+=i+j;
		}
		System.out.println("---------------------------"+Math.pow(10, 9)+7);

		total_ways=(int) (total_ways%(Math.pow(10, 9)+7));
		System.out.println("Toatlways "+total_ways);
	}
	public static void main(String[] args)
	{

		Scanner scan=new Scanner(System.in);
		int sum=Integer.parseInt(scan.next());
		compute(sum);

	}
}
