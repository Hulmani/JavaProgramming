import java.util.Scanner;


public class PowerUnit {

	public static int unit(double n)
	{
		System.out.println(" jhgj"+n);
		int i=0;
		double p=n;
		if(n<=9)return (int)n;
		while(n<=9)
		{
			System.out.println(" jhgj"+n);
			p=p%10;
		}
		return (int)p;
	
	}
	public static int power(double n)
	{
		if(n==1)
		{
			//System.out.println(Math.ceil(n/2));
			return 1;
		}
		
		else
		{
			double a=Math.ceil(n/2);
			double b=n-a;
			double k=power(a);
			double p=power(b);
		return unit(k*p);
		}
		
	}
	
	public static void main(String[] args)
	{
		double n;
		while(true){
		System.out.println("Enter the number");
		Scanner scanner = new Scanner( System.in );
		n=scanner.nextDouble();
		System.out.println(unit(n));
		//System.out.println(power(n));
		}
	}
}
