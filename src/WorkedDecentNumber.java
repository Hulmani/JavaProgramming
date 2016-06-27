import java.util.Scanner;
import java.util.ArrayList;

public class WorkedDecentNumber {


	public static void print(int prod,int rem)
	{
		StringBuffer p=new StringBuffer("");
		System.out.println("5s"+prod+" 3s"+rem);

		for(int j=0;j<prod;j++) 
			p.append("5");
		//			System.out.print("5");

		System.out.flush();
		for(int k=0;k<rem;k++)
			p.append("3");

		System.out.println(p);
		//		return;
	}


	public static void deduce(int n)
	{
		//for n>=5
		//calculate no of 3s
		boolean exists=false;
		if(n%3==0)
		{
			print(n,0);
		}
		else
		{

			for(int i=1;i<n;i++){
				int noof5s= n-(5*i);
				//System.out.println("5s:"+noof5s +" 3s"+5*i);
				if(noof5s<0)
				{
					break;
				}
				if(noof5s%3==0 && (5*i)%5==0)
				{
					exists=true;
					print(noof5s,5*i);
					break;
				}
			}

			if(!exists)
				System.out.print("-1");
		}



	}
	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		int test_cases=Integer.parseInt(scan.next());
		for(int i=0;i<test_cases;i++)
		{
			int n=Integer.parseInt(scan.next());

			if(n==1 || n==2 || n==4)
			{
				System.out.println("-1");
			}
			if(n==3)
			{
				System.out.println("555");
			}


			if(n>=5){
				deduce(n);
				System.out.println();
			}
		}
	}
}
