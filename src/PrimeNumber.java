
public class PrimeNumber {
	public static void main(String[] args)
	{
	
		
		int val= 67&3;
		System.out.println(val);
		val=1<<val;
		System.out.println(val);
		System.out.println('a'-'a');
		int n=0;
		boolean prime=true;
		if(n==1)
			prime =false;
		else if(n<1)
			System.out.println("A prime number should be a natural number 1"+3);

		else
		{
			for(int i=2;i<=Math.sqrt(n);i++)
		
		{
			if(n%i==0)
			{
				prime=false;

				break;
			}
		}
		System.out.println(prime);
		}
	}
}
