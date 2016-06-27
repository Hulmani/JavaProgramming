import java.util.Arrays;


public class SubArrays {

	static int  count=0;
	
	
	public static void main(String[] args)
	{
		int a[]={1,-2,4,-5,1};

		int l=a.length;
		int b[][]=new int[l][];
		for(int j=0;j<l;j++)
		{
			b[j]= Arrays.copyOfRange(a,j,l);
			
			//calculateSubarray();
			
//			for(int i=0;i<b[j].length;i++)
//				System.out.print(b[j][i]+",");
//				
			
			System.out.println(count);
		
			
			
			
			
		}


	}
}
