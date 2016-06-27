
public class MakeCHange {


	public static int makeChangeD(int k,int[] change)
	{
		int[] c=new int[k+1];
		c[0]=0;
		c[1]=1;

		for(int i=2;i<=k;i++)  
		{
			c[i]=Integer.MAX_VALUE;  //consider the 

			for(int j:change)
			{
				if(i==j)

					c[i]=1;
				else if(j<i)
				{
					c[i]= Math.min( c[i],c[i-j]+c[j]);
				}

			}
			
		}
		return c[k];
	}
	public static void makeChangeDP(int k,int[] change)
	{
		int[] c=new int[k+1];
		c[0]=0;
		//c[1]=1;


		for(int j:change)
		{
			for(int i=j;i<=k;i++)  
			{
				//c[i]=Integer.MAX_VALUE;  //consider the 

				if(i==j) c[i]=1;

				else
				{
					if(c[i]==0)
						{
						
						c[i]=c[i-j]+c[j];
						//System.out.println(i+" with"+j);
						}
							
					else 
						{
						
						int p=Math.min( c[i],c[i-j]+c[j]);
						c[i]= p;
						//System.out.println(i+" with"+j +" min :"+p);
						}
				}

			}
		}


		System.out.println(k+" "+c[k]);
	}

	public static void main(String[] args)
	{
		int[] change={1,10,25};
		//makeChangeDP(80,change);
		for(int i=1;i<=81;i++)
			makeChangeDP(i,change);
			//System.out.println(i+" "+makeChangeD(i,change));
	}

}
