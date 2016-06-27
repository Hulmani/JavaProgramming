public class KnapSackIndex0 {
	
	public static int dp(int[] v,int [] w,int limit)
	{
		int[][] m=new int [v.length+1][limit+1];
		for(int i=0;i<=limit;i++) 
		{
			m[0][i]=0;   //profit of Oth item and limit=i =0  i.e  m[0][0...limit]=0 
		}
		for(int i=1;i<=v.length;i++)    //ith item 
		{
				for(int j=1;j<=limit;j++)  //limit=j
				{
					int prev_best=m[i-1][j];
					if(j>=w[i-1])			//limit(j) of bag can accommodate the item 
					{
						int loo =m[i-1][j-w[i-1]]+v[i-1];  //items start from 0th index
						m[i][j]= (prev_best>loo)?prev_best:loo;
					}
					
					else m[i][j]=prev_best; // cannot accommodate item, take the previous item (i-1)at best 
				}
		
		
		}
		System.out.println(m[v.length][limit]);
			return 0;
	}

	public static void main(String[] args)
	{
		int[] v= {3,6,5,4};//items_values
	
		int[] w= {2,3,6,4};//items_weights
		
		int limit=13;
		dp(v,w,limit);
	}
}
