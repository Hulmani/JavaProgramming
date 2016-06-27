import java.util.Scanner;


public class FibRange {

	public static double fib (double n)
	{
		
		if(n==0)return 0;
		if(n==1)
			return 1;
		
		else if(n==2)
			return 2;
		else
		return fib(n-2)+fib(n-1);
	}
	public static double  comp( double n,double o)
	{
		
		double j=0,k=0,i=1;
		double cur=1,prev=0;
		while(n>=cur)
		{
			prev=cur;
			i++;
			//cur=prev+cur;//
			cur=fib(i);
		}
		System.out.println(i);
		
		j=i;
		
		while(o>prev+cur)
		{
			prev=cur;
			cur=cur+prev;
			i++;
		}
		k=i;
		System.out.println(k);
		
		return k-j;
	}
	
	
	public static void main(String[] args) 
	{
		//System.out.println(fib(new Double()));
	//	System.out.println("Enter the first number");
		Scanner scan=new Scanner(System.in);
		double n=scan.nextDouble();
		double o=scan.nextDouble();

		if(n>o)
		{	double t=n;
		n=o;
		o=t;
		}
		System.out.println(comp(n,o));
		
	}
}
