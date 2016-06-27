
public class SumAfterBefore {

	public static void main(String[] args)
	{
		int a[]={-1,3,-4,5,1,-6,2,1};
		int prev[]=new int[a.length];
		int after[]=new int[a.length];
		prev[0]=0;

		for(int i=1;i<a.length;i++)
		{
			prev[i]=a[i-1]+prev[i-1];
			System.out.println(i+" "+prev[i]);
		}
		after[a.length-1]=0;


		for(int i=a.length-1;i>0;i--)
		{
			after[i-1]=a[i]+after[i];
			System.out.println(i+" "+after[i-1]);
		}

		for(int i=1;i<prev.length;i++)
			if(prev[i]==after[i])
			{
				System.out.println(i);
			}
	}
}


