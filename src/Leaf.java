
public class Leaf {


	public static void f(int n,int t)
	{
		if(n<=1) System.out.println("leaf");

		else
		{
			if(t>n)
			{
				f(n/2,t);
			}
			else
			{
				f(n/2,t);
			}

		}

	}
	public static void main(String[] args) 
	{
		int  n=16,t=15;
		f(n,t);
	}
}
