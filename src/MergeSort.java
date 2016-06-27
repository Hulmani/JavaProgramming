
public class MergeSort {

	static int[] mergeSort(int[] m,int l,int r)
	{
		int[] k=new int[m.length];
		if(l==r) {
			k[0]=m[l];
			return k;
		}
		int mid=(l+r)/2;
			
		
		System.out.println(l+" "+mid);
			
			int[] b=mergeSort(m,l,mid);

			//System.out.println("left "+(mid+1)+" right "+r);
			
			
			int[] c=mergeSort(m,mid+1,r);

			//System.out.println("b is "+b[0]+" c is "+c[0]);
			k=merge(b,c);
			//System.out.println("k is "+k[0]+" "+k[1]);
			return k;

		
		//return k;
	}
	
	static int [] merge(int[]b,int [] c)
	{
		int []m =new int[b.length+c.length];
		int k=0;
		boolean endB=false; 
		boolean endC=false;
		
		System.out.println();
		int i=0,j=0;
		while(true)
		{
			//System.out.println(i+" "+j);
			PrintArray.printArray(b);
			PrintArray.printArray(c);
			
			if(i==b.length)  
			{
				endB=true;
				break;
			}
			if(j==c.length) {
				endC=true;
				break;
			}

			
			if(b[i]<=c[j])
			{
				m[k++]=b[i];
				i++;
			}
			else
			{
				m[k++]=c[j];
				j++;
			}

		}
		if(endB)
		{
			for(;j<c.length;j++)
				m[k++]=c[j];

			//break;
		}
		if(endC)
		{
			for(;i<b.length;i++)
				m[k++]=b[i];
			//break;
		}
		PrintArray.printArray(m);
		return m;
	}
	public static void main(String[] args)
	{
		int []m={4,6,2,3,1,9,5,0};

		int[] b=mergeSort(m,0,m.length-1);
		//int[] c=mergeSort(m,(int)Math.floor((m.length/2)+1),m.length-1);
		//m=merge(b,c);

		System.out.println("::"+b.length);
		for(int i:b)
		{
			System.out.print((b[i]));
		}
	}
}
