
public class Unknown {

	
	
	public static void unknown(int level,int[] a)
	{
		if(level==4)
			System.out.println(a[1]+" "+a[2]+" "+a[3]);
		else
		{
		a[level]=0;
		unknown(level+1,a);
		
		a[level]=1;
		unknown(level+1,a);
	}
	}
	
	public static void main(String [] args)
	{
		
		int a[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		unknown(1,a);
	}
}
