
public class AddSub {
	public static int sum=0;
	public static int  divide(int[] a,int l,int r)
	{
		int n=l+r+1;
		int k=n/2-1;
		int m=k+1;
		
		if(l==r){
			
			return a[l];
		}
			
		else
		{
			
			int b=divide(a,l,k);
			int c=divide(a,m,r);
			sum= b+c;
		}
		return sum;
	}
	public static void main(String [] args)
	{
		int [] values= {15,6,7,8};
		
		System.out.println(divide(values,0,values.length-1));
		
	}
}
